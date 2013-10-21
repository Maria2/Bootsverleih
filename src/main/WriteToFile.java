/**
 * 
 */
package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Maria
 *
 */
public class WriteToFile  {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WriteToFile wtf = new WriteToFile();
		wtf.writeAll();
	}
	
	public void writeAll()
	{
		 try {
	          File file = new File("example.txt");
	          BufferedWriter output = new BufferedWriter(new FileWriter(file));
	          for(int x=0, y=0; x>arg.length; x++, y++ ){
	        	  
	        	  if(y==5){
	        		  
	        		  output.write("\n");
	        		  y=0;
	        	  }
	          output.write(arg[x]+"   ");
	          
	          }
	          output.close();
       } 	
       catch ( IOException e ) {
          e.printStackTrace();
       }
		
	}

}
