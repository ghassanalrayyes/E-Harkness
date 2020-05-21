# E-Harkness

I attended high school at King's Academy, where the Harkness Method is most often used for teaching. In a nutshell, it's a classroom model whereby the students and teacher sit around an oval table the whole time--no rows or seats. These discussions require skill and practice because they are not regulated by a teacher, so they are often documented in full detail to find weaknesses and improve.

All teachers nowadays still use a sheet of paper to map out and annotate the discussion as shown here:
<br>
<p align="center">
  <img src="https://i.pinimg.com/originals/29/66/07/2966078c75249aa22b77f77c25bbb73b.png" alt="Harkness" width="50%"  height="50%">
  <br>
 
</p>

<br>

### This piece of software makes all this digital...

<br>

<p align="center">
 <img width="1282" alt="E-Harkness" src="https://user-images.githubusercontent.com/30037359/82522384-ec658380-9b31-11ea-8543-f6ce9fafe7ee.png">

  <br>
 
</p>

<br>

Check it out in action:
========================

<p align="center">
<img alt="GIF" src="https://user-images.githubusercontent.com/30037359/82523419-db6a4180-9b34-11ea-9e5c-59fb3d3a5c56.gif">
</p>

<br>

Some features and functionality:
===============================
* Automatic even distribution of students on the table. The algorithm uses the most effecient and space-maximizing layout.
* The student data is pulled from a universal student directory PDF which has very inconsistent formatting. Unpacking this PDF was generally a nightmare, and required a convoluted decision tree (inside the Reader class).

Concepts/Technbologies (practiced):
========================

1. Java Swing for the graphics and UI.
2. PDF file parsing with PDFBox.
3. Linked lists to map out the discussion, Hashmaps to store all tbe student data for quick access.
4. OOP--inheritance with graphics; Member, Class, Table, Point data models.




