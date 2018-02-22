package polling;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.io.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

class FileRead 
{
 public static void main(String args[])
  {
	 
	 FileReader fileReader = null;
     BufferedReader br = null;
     FileOutputStream fos = null;
	 ZipOutputStream zipOut = null;
	 FileInputStream fis = null;
     try
  	{
	  
	  File folder = new File("C:/STS/sts-bundle/sts-3.9.2.RELEASE/CitiProject/polling/pollinputfolder/");
	  
	  fos = new FileOutputStream("C:/STS/sts-bundle/sts-3.9.2.RELEASE/CitiProject/polling/zipfiles.zip");
      zipOut = new ZipOutputStream(new BufferedOutputStream(fos));
        
	  if (folder.isDirectory()) 
      {
          for (File file : folder.listFiles()) 
          {
              fileReader = new FileReader(file);
              br = new BufferedReader(fileReader);
              String line = null;
              int lineno=0;
              int flag=0;
              System.out.println("=============================");
              while ((line = br.readLine()) != null)  
              {
            	  lineno=lineno+1;
            	  // Print the content on the console
            	  System.out.println();
            	  System.out.print(lineno+" ");
            	  System.out.println(line); //Read File Line By Line
            	  
            	  if(lineno==1)
            	  {
            		  System.out.println("Alphanumeric : "+line.matches("[A-Za-z0-9]+"));
            		  System.out.println("Field length : "+line.length());
            		  if(line.length()!=12)
            		  {
            			  flag=1;
            		  }
            		 
               	  }
            	  else if(lineno==2)
            	  {
            		  SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            		  sdf.setLenient(false);
            		  try
            		  {
            			  Date d=sdf.parse(line);
                		  //System.out.println(line);
            		  }
            		  catch(Exception e)
            		  {
            			  System.out.println("Date is in wrong format");
            			  flag=1;
            		  }
            		  
            	  }          		 
            	
            	  if(lineno==3 || lineno==5)
            	  {
            		  System.out.println("Alphanumeric : "+line.matches("[A-Za-z0-9 ]+"));//returns true or false value
            		  System.out.println("Field length : "+line.length());
            		  if(line.length()>35)
            		  {
            			  System.out.println("Invalid name");
            			  flag=1;
            		  }
            	  }
            	  if(lineno==4 || lineno==6)
            	  {
            		  System.out.println("Alphanumeric : "+line.matches("[A-Za-z0-9]+"));//returns true or false value
            		  System.out.println("Field length : "+line.length());
            		  if(line.length()>12)
            		  {
            			  System.out.println("Invalid account number");
            			  flag=1;
            		  }
            	  }
            	 
            	  if(lineno==7)
            	  {
            		  line.matches("[0-9.]+");
            		  
            		  if(line.length()==13 && (line.indexOf(".")==10))
            		  {
            			  System.out.println("correct INR format");
            		  }
            		  else
            		  {
            			  System.out.println("incorrect INR format");

            			  flag=1;
            		  }
            	  }
            	  
            	  
              }
              System.out.println();
              
              if(flag==1)
              {
            	  System.out.println("discard file");
              }
              else
              {
            	  //File input = new File(file.getName());
            	  fis = new FileInputStream(file);
                  ZipEntry ze = new ZipEntry(file.getName());
                  System.out.println("Zipping the file: "+file.getName());
                  zipOut.putNextEntry(ze);
                  byte[] tmp = new byte[4*1024];
                  int size = 0;
                  while((size = fis.read(tmp)) != -1){
                      zipOut.write(tmp, 0, size);
                  }
                  zipOut.flush();
                  fis.close();
            	  
               }
          }
     }
	  zipOut.close();
      System.out.println("Done... Zipped the files...");
  	}
     catch (FileNotFoundException e) 
  	{
        e.printStackTrace();
    } 
     catch (IOException e) 
  	{
        e.printStackTrace();
    } 
     finally 
  	{
        if (null != br)
            try 
        	{
                br.close();
            } 
        	catch (IOException e) 
        	{
                e.printStackTrace();
            }
    }
}

}