package net.hasnath.ridmikparser;

import java.util.HashMap;
import java.util.Map;

public class BanglaUnicode {
	
	private Map<String, String> map = new HashMap<String, String>();
	private Map<String, String> kars = new HashMap<String,String>();
	private Map<String, String> jkt = new HashMap<String, String>();
	private Map<String, String> djkt = new HashMap<String, String>();
	private Map<String, String> djktt = new HashMap<String, String>();
	
	public BanglaUnicode(){
		// Same : a, k, g, c, f, e, b, v, l, m, p
		map.put("o", "\u0985"); // shore o
		map.put("O", "\u0993"); // rossho o
		map.put("a", "\u0986"); // aa
		map.put("A", "\u0986"); // aa
		map.put("S", "\u09B6"); // talobbo sho
		map.put("sh", "\u09B6"); // talobbo sho
		map.put("s", "\u09B8");  // donto sho
		map.put("Sh", "\u09B7"); // murdonno sho
		map.put("h", "\u09B9"); // ho
		map.put("H", "\u09B9"); // ho
		map.put("r", "\u09B0"); // ro
		map.put("R", "\u09DC"); // dhoye shunne ro
		map.put("Rh", "\u09DD"); // dhoye shunne ro
		map.put("k", "\u0995"); // ko
		map.put("K", "\u0995"); // ko
		map.put("q", "\u0995");
		map.put("qq", "\u0981"); // chondro bindu
		map.put("kh", "\u0996"); // kho
		map.put("g", "\u0997"); // go
		map.put("G", "\u0997"); //go
		map.put("gh", "\u0998"); // gho
		map.put("Ng", "\u0999"); // unga		
		map.put("c", "\u099A"); // cho
		map.put("C", "\u099A"); // cho
		map.put("ch", "\u099B"); // ccho
		map.put("j", "\u099C"); // jo
		map.put("jh", "\u099D"); // jho
		map.put("J", "\u099C"); // jho
		map.put("NG", "\u099E"); // niyo
		map.put("T", "\u099F"); // To
		map.put("Th", "\u09A0"); // Tho
		map.put("TH", "\u09CE"); // khondiyo to
		map.put("f", "\u09AB"); // fo
		map.put("F", "\u09AB"); // fo
		map.put("ph", "\u09AB"); // fo
		map.put("i", "\u0987"); // rossho i
		map.put("I", "\u0988"); // dhirgo i
		map.put("e", "\u098F"); // e
		map.put("E", "\u098F"); // e
		map.put("u", "\u0989"); // rossho u
		map.put("U", "\u098A"); // dhirgo u
		map.put("b", "\u09AC"); // bo
		map.put("B", "\u09AC"); // bo
		map.put("w", "\u09AC"); // bo
		map.put("bh", "\u09AD"); // bho
		map.put("V", "\u09AD"); // bho
		map.put("v", "\u09AD"); // bho
		map.put("t", "\u09A4"); // to
		map.put("th", "\u09A5"); // tho
		map.put("d", "\u09A6"); // do
		map.put("dh", "\u09A7"); // dho
		map.put("D", "\u09A1"); // do
		map.put("Dh", "\u09A2"); // dho
		map.put("n", "\u09A8"); // donto no
		map.put("N", "\u09A3"); // murdo no
		map.put("z", "\u09AF"); // zho
		map.put("Z", "\u09AF"); // zho fola
		map.put("y", "\u09DF"); // ontosto yo
		map.put("l", "\u09B2"); // lo
		map.put("L", "\u09B2"); // lo
		map.put("m", "\u09AE"); // mo
		map.put("M", "\u09AE"); // mo
		map.put("P", "\u09AA"); // po
		map.put("p", "\u09AA"); // po
		map.put("ng", "\u0982"); // onushar
		map.put("cb", "\u0981"); // chondro point
		map.put("x", "\u0995\u09CD\u09B8");
		map.put("OU", "\u0994");
		map.put("OI", "\u0990");
		map.put("hs", "\u09CD");
		map.put("nj", "\u099E\u09CD\u099C"); //
		map.put("nc", "\u099E\u09CD\u099A"); //
		
		
		kars.put("o", ""); // o kar
		kars.put("a", "\u09BE"); // aa kar
		kars.put("A", "\u09BE"); // aa kar
		kars.put("e", "\u09C7"); // e kar
		kars.put("E", "\u09C7"); // e kar
		kars.put("O", "\u09CB"); // O kar
		kars.put("OI", "\u09C8"); // OI kar
		kars.put("OU", "\u09CC");
		kars.put("i", "\u09BF"); // rossho i kar
		kars.put("I", "\u09C0"); //dhirgo i karu
		kars.put("u", "\u09C1"); // rossho u kar
		kars.put("U", "\u09C2"); // dhirgo u kar
		kars.put("oo", "\u09C1"); // rossho u kar
		
		// each of 2nd sits under 1st
		jkt.put("k", "kTtnNslw");
		jkt.put("g", "gnNmlw");
		jkt.put("ch", "w");
		jkt.put("Ng", "gkm");
		jkt.put("NG", "cj");
		jkt.put("g", "gnNmlw");
		jkt.put("G", "gnNmlw");
		jkt.put("th", "w");
		jkt.put("gh", "Nn");
		jkt.put("c", "c");
		jkt.put("j", "jw");
		jkt.put("T", "T");
		jkt.put("D", "D");
		jkt.put("R", "g");
		jkt.put("N", "DNmw");
		jkt.put("t", "tnmwN");
		jkt.put("d", "wdm");
		jkt.put("dh", "wn");
		jkt.put("n", "ndwmtsDT");
		jkt.put("p", "plTtns");
		jkt.put("f", "l");
		jkt.put("ph", "l");
		jkt.put("b", "jdbwl");
		jkt.put("v", "l");
		jkt.put("bh", "l");
		jkt.put("m", "npfwvmlb");
		jkt.put("l", "lwmpkgTDf");
		jkt.put("Sh", "kTNpmf");
		jkt.put("S", "clwnm");
		jkt.put("sh", "clwnm");
		jkt.put("s", "kTtnpfmlw");
		jkt.put("h", "Nnmlw");
		jkt.put("cb", "");
		jkt.put("jh", "");
		jkt.put("TH", "");
		jkt.put("qq", "");
		jkt.put("ng", "");
		jkt.put("kh", "");
		jkt.put("gg", "");
		jkt.put("dh", "");
		jkt.put("Th", "");
		
		// first sits under each of 2nd
		djkt.put("kh", "Ngs");
		djkt.put("ch", "c"); 
		djkt.put("Dh", "N");
		djkt.put("ph", "mls");
		djkt.put("dh", "gdnbl");
		djkt.put("bh", "dm");
		djkt.put("Sh", "k");
		djkt.put("th", "tns");
		djkt.put("Th", "Nn");
		djkt.put("jh", "j");
		djkt.put("NG", "cj");
		
		// first sits under 2nd(dual)
		djktt.put("ch", "NG");
		djktt.put("gh", "Ng");
		djktt.put("Th", "Sh");
		djktt.put("jh", "NG");
		djktt.put("sh", "ch");
		
	}
	
	public String getDual(char x, char carry){
		return map.get(Character.toString(carry)+Character.toString(x));
	}
	public String get(char x){
		return map.get(Character.toString(x));
	}
	public String getKar(char x){
		return kars.get(Character.toString(x));
	}
	public String getDualKar(char x, char carry){
		return kars.get(Character.toString(carry)+Character.toString(x));
	}
	public String getJkt(char carry){
		return jkt.get(Character.toString(carry));
	}
	public String getDualJkt(char secondCarry, char carry){
		return jkt.get(Character.toString(secondCarry)+Character.toString(carry));
	}
	public String getDjkt(char secondCarry, char carry){
		return djkt.get(Character.toString(secondCarry)+Character.toString(carry));
	}
	public String getDjktt(char secondCarry, char carry){
		return djktt.get(Character.toString(secondCarry)+Character.toString(carry));
	}
	public static void main(String[] a){
		RidmikParser.main(new String[]{});
	}
}
