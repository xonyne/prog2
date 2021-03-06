package xmlToConsole;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class Main {
	

	public static void main(String args[]) {
		byte [] array;
		
		try {
			// create object
			TimeUnit unit1 = new TimeUnit("s", 1234);	
			
			//serialize object to xml
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			XMLHelper.saveInstance(os, unit1);
			array = os.toByteArray();
			os.close();
			
			// deserialize xml to object
			InputStream is = new ByteArrayInputStream(array);
			TimeUnit timeUnit = (TimeUnit)XMLHelper.loadInstance(is, TimeUnit.class);
			System.out.println(timeUnit);
			
			/* read input stream to console
			Scanner s = new Scanner(is);
			while (s.hasNextLine()) {
				System.out.println(s.nextLine());
			}
			s.close(); */
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}


}
