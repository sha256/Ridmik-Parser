# Ridmik Parser #

**English to Bangla Phonetic Converter**

-----

Ridmik parser is used in **Ridmik Keyboard**, an on screen keyboard for the Android OS.

It's very light-weight, fast and can be converted to any other language very easily.


**Usage:**

first import

	import net.hasnath.ridmikparser.RidmikParser

then its pretty straight forward:

	RidmikParser parser = new RidmikParser();
	String bangla = parser.toBangla("amar sOnar bangla");
	System.out.println(bangla);

Output:
	
	আমার সোনার বাংলা


**License: New BSD License**




