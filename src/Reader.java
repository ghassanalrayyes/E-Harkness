

import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.text.PDFTextStripper;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.imageio.ImageIO;


public class Reader extends PDFStreamEngine {
	
	
	/**
     * Default constructor.
     *
     * @throws IOException If there is an error loading text stripper properties.
     */
	
	HashMap<String, Member> members;
	String[] text_arr;
	
	//storing the entries from the PDF here to process them later
	ArrayList<String> filtered_student_data;
	
	public Reader() throws IOException {
		
		members = new HashMap<String, Member>();
		
		PDDocument doc = null;
		String pdf_file = "pdfs/Senior Pics Final.pdf";
		
		try {
			doc = PDDocument.load(new File(pdf_file));
			PDFTextStripper text_stripper = new PDFTextStripper();
			
			//to be processed
			String parsed_text = text_stripper.getText(doc);
			
			//because you can't access these vars in the main method -- should be reworked
			Setter1(parsed_text);
			Setter2();
			
			PDPageTree pages = doc.getPages();
			int pageNum = 0;
			for(PDPage page : pages) {
				
				processPage(page);
				
			}
			
			
		}finally
        {
            if( doc != null )
            {
                doc.close();
            }
            
            //return sth??
        }
		
		
	}
	
	
	private void Setter1(String input) {
		text_arr = input.split("\n");
	}
	private void Setter2() {
		filtered_student_data = preProcessNamesList();
		System.out.println("ddddd");
		System.out.println(filtered_student_data);
	}
	
	boolean upper_school = false;
	boolean first = true;
	
	
	/*
	 * There is no point in trying to understand this.
	 * This is all the logic behind unpacking the format of the PDF to extract the JPEG images
	 * The PDF is formatted inconsistently and required a decision tree to be made from scratch
	 * i.e not all pages are encoded the same
	 * In short, I use the headings at the top of every page to tell me how to handle it
	 * */
	
	private ArrayList<String> preProcessNamesList() {
		
		ArrayList<String> names_list = new ArrayList<String>();
		boolean take_next = false;
		boolean take_2nd_next = false;
		for (int i = 0; i < text_arr.length; i++) {
			System.out.print(text_arr[i] + " --- " );
			if(!upper_school) {
				if(take_next) {
					if(text_arr[i].indexOf("Student") > -1) {
						if(text_arr[i].indexOf("09") > -1) {
							upper_school = true;
							first = true;
						}
						continue;
					}
					take_next = false;
					names_list.add(text_arr[i]);
				}
				else if(text_arr[i].indexOf("Day") > -1 || text_arr[i].indexOf("Student") > -1){
					take_next = true;
				}
				else if(text_arr[i].indexOf("GRADE") > -1) {
					names_list.add(text_arr[i].substring(6));
				}
			}else {
				if(first) {
					first = false;
					//was take_2nd_next
					take_next = true;
				}
				else if(take_next) {
					//System.out.print(text_arr[i] + ",");
					names_list.add(text_arr[i]);
					take_next = false;
				}
				else if(text_arr[i].indexOf("GRADE") > -1) {
					//System.out.print(text_arr[i].substring(6) + ",");
					names_list.add(text_arr[i].substring(6));
				}
				else if(text_arr[i].indexOf("Day") > -1 || text_arr[i].indexOf("Boarding") > -1 || text_arr[i].indexOf("Student") > -1) {
					take_2nd_next = true;
				}
				else if (take_2nd_next) {
					take_next = true;
					take_2nd_next = false;
				}
			}
			
			
		}
		
		return names_list;
	}
	
	private void createMember(String name, String grade, BufferedImage img) {
		
		//clean up the data from the PDF (eliminate spaces, etc)
		String id = name.replaceAll("\\s","");
		members.put(id, new Member(name, grade, id, img));
		
	}
	
	
	
	public int image_number = 0;
	
	 /**
     * @param operator The operation to perform.
     * @param operands The list of arguments.
     * 
     * 
     * This function is called for every page and provides a stream of images (inside the "operator")
     *
     * @throws IOException If there is an error processing the operation.
     */
    @Override
    protected void processOperator( Operator operator, List<COSBase> operands) throws IOException
    {
        String operation = operator.getName();
        
        if( "Do".equals(operation) )
        {
        	
            COSName objectName = (COSName) operands.get( 0 );
            PDXObject xobject = getResources().getXObject( objectName );
            
            if( xobject instanceof PDImageXObject)
            {
            		
            		PDImageXObject image = (PDImageXObject)xobject;
                	int imageWidth = image.getWidth();
                	int imageHeight = image.getHeight();
 
                	
                	BufferedImage bImage = new BufferedImage(imageWidth,imageHeight,BufferedImage.TYPE_INT_ARGB);
                	
                	
                	bImage = image.getImage();
                	System.out.println(filtered_student_data.get(image_number));
                	
                	
                	File output = new File("storage/AHMAD/" + filtered_student_data.get(image_number) + ".jpg");
                	System.out.println(output.getPath());
                	
                	//store image
                	ImageIO.write(bImage, "jpg", output);
                	
                	//instantiate a member from the data pulled from the PDF
                	createMember( filtered_student_data.get(image_number), filtered_student_data.get(image_number+1), bImage);
                	image_number+=2;
         
            }
            
            
            else if(xobject instanceof PDFormXObject)
            {
                PDFormXObject form = (PDFormXObject)xobject;
                showForm(form);
             
                
            }
            else {
            	
            }
        }
        
        else
        {
            super.processOperator( operator, operands);
        }
    }

}
