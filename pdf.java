package Doggy;


	import java.io.FileNotFoundException;
import java.io.FileOutputStream;
	 

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

	import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

	 
	public class pdf {
		
	   public static void main(String[] args) throws SQLException
	   {
		   
		   DbConnection db= new DbConnection();
	         PreparedStatement ps=null;
	         ResultSet rs=null;
	         String que="null"; 
		   
		   
	      Document document = new Document();
	      
	      
	      que="select * from godoggy_register where id=30";
	        
				   ps= db.getConnection(que);
				  // ps.setString(1,cp_id);
				   rs=ps.executeQuery();
				   
				   while(rs.next())
					 
	        
	        												
	      try
	      {
	         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("world.pdf"));
	         document.open();
	       
	         document.add(new Paragraph("Registration Table"));
	         document.add(new Paragraph("id="+rs.getInt(1)));
	         document.add(new Paragraph("name="+rs.getString(2)));
	         document.add(new Paragraph("email="+rs.getString(3)));
	         document.add(new Paragraph("phone="+rs.getString(4)));
	         document.close();
	         writer.close();
	      } catch (DocumentException e)
	      {
	         e.printStackTrace();
	      } catch (FileNotFoundException e)
	      {
	         e.printStackTrace();
	      }
	   }
	   }


