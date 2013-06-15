package net.hasnath.ridmikparser.test;

import static org.junit.Assert.*;
import junit.framework.Assert;

import net.hasnath.ridmikparser.RidmikParser;
import org.junit.Test;

public class ParserTest {
	
	@Test
	public void specialTest(){
		RidmikParser p = new RidmikParser();
		Assert.assertEquals("উদ্ধত", p.toBangla("uddhot"));
		Assert.assertEquals("রাষ্ট্র", p.toBangla("raShTro"));
		Assert.assertEquals("বৈষ্ণব", p.toBangla("bOIShNb"));
		Assert.assertEquals("লক্ষ্মী", p.toBangla("lokkhmI"));
		Assert.assertEquals("বাংলা", p.toBangla("bangla"));
		Assert.assertEquals("চাঁদ", p.toBangla("cacbd"));
		Assert.assertEquals("ভাঙাঘর", p.toBangla("vaNgaghor"));
		Assert.assertEquals("র‍্যান্সম", p.toBangla("ryansom"));
		Assert.assertEquals("আঘ্নেয়া", p.toBangla("aghneya"));
		Assert.assertEquals("কর্তৃক", p.toBangla("korrtrrik"));
		Assert.assertEquals("বঞ্চনা", p.toBangla("boNGcona"));
		Assert.assertEquals("ঝঞ্ঝা", p.toBangla("jhoNGjha"));
		Assert.assertEquals("উধভ্রান্ত", p.toBangla("udhbhranto"));
		Assert.assertEquals("অয়ার", p.toBangla("oar"));
		Assert.assertEquals("বিজ্ঞান", p.toBangla("biggan"));
		Assert.assertEquals("চিহ্ন", p.toBangla("cihn"));
		Assert.assertEquals("", p.toBangla(""));
	
	}


}
