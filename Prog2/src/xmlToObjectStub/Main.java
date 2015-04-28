package xmlToObjectStub;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class Main {
	

	public static void main(String args[]) {
		byte [] array;
		
		try {
			// create object
			Dice dice = new Dice(1,6);
			
			// roll the dice 100 times 
			for (int i = 0; i < 100; i++) {
				dice.play();
			}
			
			//serialize complete dice object to xml
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			XMLHelper.saveInstance(os, dice);
			array = os.toByteArray();
			os.close();
			
			// load only statistics from xml
			InputStream is = new ByteArrayInputStream(array);
			DiceStatistics statistics = (DiceStatistics)XMLHelper.loadInstance(is, DiceStatistics.class);
			System.out.println(statistics);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}


}
