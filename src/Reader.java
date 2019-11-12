

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
	ArrayList<String> filtered_student_data;
	
	public Reader() {
		members = new HashMap<String, Member>();
	}
	
	
	
	//quick helper
	private void printArr() {
		/*System.out.print("[");
		for (String string : text_arr) {
			System.out.print(string + ", ");
		}
		System.out.print("]");
		 */
		
		System.out.println(members);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Reader reader = new Reader();
		PDDocument doc = null;
		String pdf_file = "pdfs/StudentDirectory2019-2020.pdf";
		
		try {
			doc = PDDocument.load(new File(pdf_file));
			PDFTextStripper text_stripper = new PDFTextStripper();
			
			//to be processed
			String parsed_text = text_stripper.getText(doc);
			
			//because you can't access these vars in the main method -- should be reworked
			reader.Setter1(parsed_text);
			reader.Setter2();
			
			reader.printArr();
			
			PDPageTree pages = doc.getPages();
			int pageNum = 0;
			for(PDPage page : pages) {
				
				reader.processPage(page);
				
			}
			
			System.out.println("\n");
			System.out.println(reader.members);
			//System.out.println(reader.members.get("DimahAl-Gburi").full_name);
			
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
	}
	
	boolean upper_school = true;
	boolean first = true;
	private ArrayList<String> preProcessNamesList() {
		
		ArrayList<String> names_list = new ArrayList<String>();
		boolean take_next = false;
		boolean take_2nd_next = false;
		for (int i = 0; i < text_arr.length; i++) {
			//System.out.print(text_arr[i] + " --- " );
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
					take_2nd_next = true;
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
		
		String id = name.replaceAll("\\s","");
		System.out.print(id + " - ");
		members.put(id, new Member(name, grade, id, img));
		
	}
	
	
	
	public int image_number = 0;
	
	 /**
     * @param operator The operation to perform.
     * @param operands The list of arguments.
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
                
                	createMember( filtered_student_data.get(image_number), filtered_student_data.get(image_number+1), bImage);
                	
                	image_number++;
         
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
