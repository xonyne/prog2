package dice;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Scanner;

import javax.xml.bind.JAXBException;

import xmlToObject.XMLHelper;

public class Main {
	
	public static void main(String[] args) throws JAXBException, IOException {
		Dice dice = new Dice(1, 6);
		for (int i = 0; i < 30; i++) {
			dice.play();
		}
		System.out.println(dice);
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		XMLHelper.saveInstance(os, dice);
		byte[] array;
		array = os.toByteArray();
		Scanner s = new Scanner(new ByteArrayInputStream(array));
		while (s.hasNextLine())
			System.out.println(s.nextLine());
		s.close();

	}


}
