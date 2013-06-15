package net.hasnath.ridmikparser.test;

import java.io.*;
import net.hasnath.ridmikparser.RidmikParser;

public class FileTest {


	public static void main(String args[]) {
		try {
			
			FileInputStream fstream = new FileInputStream("wordlist.txt");

			RidmikParser parser = new RidmikParser();
			
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			long pretime = System.currentTimeMillis();
			
			while ((strLine = br.readLine()) != null) {
				System.out.println(parser.toBangla(strLine));
//				System.out.print("Assert.assertEquals(\""); //", p.parse("amar", false));
//				String sto = strLine.split(" ")[1];
//				System.out.print(parser.toBangla(sto));
//				System.out.print("\", p.parse(\"");
//				System.out.print(sto+"\", false));");
//				System.out.println();
			}
			System.out.println(System.currentTimeMillis() - pretime);
			in.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}