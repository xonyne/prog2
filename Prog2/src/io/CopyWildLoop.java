package io;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class CopyWildLoop {
	
	public static void main(String args[]) throws IOException {
		

		InputStream is=System.in;
		Scanner s=new Scanner(is);
		
		PrintWriter pw=new PrintWriter(new FileOutputStream("test.txt"));
		pw.write(s.nextLine());

		s = new Scanner(new BufferedReader(new FileReader(new File("test.txt"))));
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		pw = new PrintWriter(new GZIPOutputStream(baos));
		while (s.hasNext()) {
			pw.println(s.next());
		}
		byte[] byteArray = baos.toByteArray();
		System.out.println(byteArray.toString());
		s = new Scanner(new GZIPInputStream(new ByteArrayInputStream(byteArray)));
		System.out.println(s.next());
		
		pw.flush();
		pw.close();
		s.close();
	}
}
