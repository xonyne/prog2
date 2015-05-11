package io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialiser {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Message m = new Message("Hallo Welt", "Kevin");
//		
//		// Serialize object
//		ByteArrayOutputStream baos = new ByteArrayOutputStream();
//		ObjectOutputStream oos = new ObjectOutputStream(baos);
//		oos.writeObject(m);
//		byte[] byteArray = baos.toByteArray();
//		oos.close();
//	
//		//Deserialize object
//		InputStream is = new ByteArrayInputStream(byteArray);
//		ObjectInputStream ois=new ObjectInputStream(is);
//		Object o=ois.readObject();
//		ois.close();
//		
//		System.out.println(">>> " + o);
		
//		// Serialize to file
//		FileOutputStream fos = new FileOutputStream(new File("message.ser"));
//		ObjectOutputStream oos2 = new ObjectOutputStream(fos);
//		oos2.writeObject(m);
//		oos2.close();
		
		// Deserialize from file
		FileInputStream fis = new FileInputStream(new File("message.ser"));
		ObjectInputStream ois2=new ObjectInputStream(fis);
		Object o2=ois2.readObject();
		ois2.close();
		
		System.out.println(">>> " + o2);
		
		
	}
}
