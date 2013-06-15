package net.hasnath.ridmikparser;

import java.util.Scanner;

/**
 * 
 * @author Shamim Hasnath
 * @version 1.2
 * @since 2012
 *
 */


public class RidmikParser{
	
	private BanglaUnicode unicode = new BanglaUnicode();

	public static void main(String[] arg){
		RidmikParser parser = new RidmikParser();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter:");
		
		while(sc.hasNext()){
			String eng = sc.nextLine();
			System.out.println(parser.toBangla(eng));
		}
		
	}
	
	/**
	 * 
	 * @param engWord (String) the english word, might contain spaces or any other characters
	 * @return parsed Bangla string in unicode
	 */

	public String toBangla(String engWord){
		
		StringBuilder st = new StringBuilder();
		char carry = 0;
		char secondCarry = 0;
		char thirdCarry = 0;
		boolean tempNoCarry = false;
		boolean jukta = false;
		char[] charArray;
		boolean prevJukta = false;
		

		charArray = engWord.toCharArray();

		// ======================= The great for loop starts =======================
		for(char now : charArray){
			
			// we won't parse anything other than english letters & digits
			if(!((now >= 'a' && now <= 'z') || (now >= 'A' && now <= 'Z') || (now >= '0' && now <= '9'))){
				st.append(now);
				carry = 0;
                // if a bug shows up first thing to do is reset secondCarry, thirdCarry etc here
				continue;
			}
			
			if(now == 'A' || now == 'B' || now == 'C' || now == 'E' || now == 'F' || now == 'P' || now == 'X')
				now = Character.toLowerCase(now);
			if(now == 'K' || now == 'L' || now == 'M' || now == 'V' || now == 'Y' || now == 'W' || now == 'Q' )
				now = Character.toLowerCase(now);
			
			if(now == 'H' && carry != 'T') // khondiyo to -> TH
				now = 'h';
			
			// 'w' should be 'O' when it's the first one or comes after a vowel
			if((carry == 0 || isVowel(carry)) && now == 'w')
				now = 'O';

			
			if(isVowel(now)){
				
				// special for wri kar & wri
				if(carry=='r' && secondCarry == 'r' && now =='i'){
					
					if(thirdCarry == 0){
						st.delete(st.length()-2, st.length());
						st.append("\u098B"); // wri						
					}else {
						st.delete(st.length()-3, st.length());
						st.append("\u09C3"); // wri kar
					}
					carry = 'i';
					continue;

				}
				
				String dual;
				if(secondCarry != 0)
					dual = unicode.getDualKar(now, carry);
				else dual = unicode.getDual(now, carry); // dual as the first character of st
				
				if(dual != null){					
					if(carry != 'o')
						st.delete(st.length()-1, st.length());
					if(isVowel(secondCarry)){ // a dual kar does not applied on vowel
						st.append(unicode.get(carry)).append(unicode.get(now));
					}else
						st.append(dual);					
				}else if(now == 'o' && carry != 0){
					if(isVowel(carry))
						st.append(unicode.get('O'));
					else {
						thirdCarry = secondCarry;
						secondCarry = carry;
						carry =  now; // carry = 0 
						continue;
					}
				}else if(isVowel(carry) || carry == 0){
					if(now == 'a' && carry != 0) // not first a
						st.append(unicode.get('y')).append(unicode.getKar('a'));
					else
						st.append(unicode.get(now));
				}else {
					st.append(unicode.getKar(now));
				}
	
			}
			

			if(now == 'y' || now == 'Z' || now == 'r')
				jukta = false;
			
			// when previous was a jukta and dual of the later two is not available
			// go to the else part of the next if block i.e now is independent
			tempNoCarry = jukta && unicode.getDual(now, carry) == null;
			
			if(isConsonant(now) && isConsonant(carry) && !tempNoCarry){
				
				// handle jo fola
				
				if(now == 'y' || now == 'Z'){
					if(now == 'y' && carry == 'q' && secondCarry == 'q');
					else 
						now = 'z';
				}
				
				//handle gg as in gyan,
				//second carry not n, to skip onushar/unga
				
				if(carry=='g' && now=='g' && secondCarry !='N' && secondCarry != 'n'){
					st.delete(st.length()-1, st.length());
					st.append("\u099C\u09CD\u099E");
					prevJukta = jukta;
					jukta = true;
					secondCarry = 'g';
					continue;
				}
				
				// handle kkh = kSh
				if(secondCarry == 'k' && carry == 'k' && now == 'h')
					carry = 'S';
				
				// check if dual
				String dual = unicode.getDual(now, carry);
				
				if(dual != null){
					
					// handle kaNgkShito
					if(thirdCarry == 'g' && secondCarry == 'k' && carry == 'S' && now == 'h')
						prevJukta = jukta = false;
					
					boolean firstOrAfterVowelOrJukta = isVowel(secondCarry) || secondCarry == 0 || prevJukta;
					
					if(dualSitsUnder(thirdCarry, secondCarry, carry, now) && !firstOrAfterVowelOrJukta){
						st.delete(st.length()-1, st.length());
						if(secondCarry == 'r' && thirdCarry == 'r')
							st.delete(st.length()-1, st.length());
						if(jukta);
						else if(secondCarry != 0 && !isVowel(secondCarry))
							st.append("\u09CD");
						
						st.append(dual);
						prevJukta = jukta;
						// Jukta should be false in case we want to have three jukta letters
						jukta = true;
						
					}else {
						if(jukta)
							st.delete(st.length()-2, st.length());
						else st.delete(st.length()-1, st.length());
						
						if(secondCarry == 'g' && carry == 'g' && now == 'h'){ // handled gg previously, now more pain
							st.delete(st.length()-1, st.length());
							st.append(unicode.get('g'));
						}
						
						st.append(dual);
						prevJukta = jukta;
						jukta = false;
					}
					
					
				}else {
					
					prevJukta = jukta;
					jukta = false;
					
					if(secondCarry != 'r' && carry == 'r' && now == 'z'){
						st.append("\u200D\u09CD"); // handle rya as in ransom/rapid
					}
					else if(carry == 'r' && secondCarry != 'r');
					 // no ref when (c) rr (c)
					else if(carry == 'r' && secondCarry == 'r' && isConsonant(thirdCarry));
					 // ref when (v) rr (c)
					else if(carry == 'r' && secondCarry == 'r' && (isVowel(thirdCarry) || thirdCarry == 0)){
						st.delete(st.length()-1, st.length());						
						st.append("\u09CD"); // jukta added for ref, but jukta not true
					}
					
					else if(notJukta(thirdCarry, secondCarry, carry, now));
					else {
						st.append("\u09CD");
						//prevJukta = jukta;
						jukta = true;
					}
					
					st.append(unicode.get(now));

				}				
				
			} else if(isConsonant(now)){
				
				if(isVowel(carry) && now == 'Z')
					st.append("\u09CD");
				
				if(carry == 0 && now == 'x')
					st.append(unicode.get('e'));
				
				prevJukta = jukta;
				jukta = false;
				
				// to write b-fola 
				if(now == 'w' && isConsonant(carry) && isConsonant(secondCarry)){
					st.append("\u09CD");
					prevJukta = jukta;
					jukta = true;
				}
				// handle lakshmi/ lokhnou
				if(thirdCarry == 'k' && secondCarry == 'S' && carry == 'h' && (now == 'N' || now == 'm')){
					st.append("\u09CD");
					prevJukta = false;
					jukta = true;
				}
				st.append(unicode.get(now));

			}
			
			thirdCarry = secondCarry;
			secondCarry = carry;
			carry = now;
		} // end of for loop
		
		return st.toString();
	}
	
	boolean isVowel(char now){
		if("AEIOUaeiou".indexOf(now) == -1)
			return false;
		return true;
	}
	
	boolean isConsonant(char now){
		return !isVowel(now) && Character.isLetter(now);
	}
	
	boolean isCharInString(char now, String foo){
		if(foo.indexOf(now) == -1)
			return false;	
		return true;
	}
	
	boolean dualSitsUnder(char thirdCarry, char secondCarry, char carry, char now){
		
		if(secondCarry == 'r' && thirdCarry == 'r')
			return true;
		
		if(secondCarry == 'r')
			return false;
		
		String djkt = unicode.getDjkt(carry, now);
		if(djkt != null)
			if(isCharInString(secondCarry, djkt))
				return true;

		String djktt = unicode.getDjktt(carry, now);
		if(djktt != null)
			return djktt.contains(Character.toString(thirdCarry)+Character.toString(secondCarry)); // ? true : false;

		// if we didn't cover it here, let's assume it sits under a consonant so we return true
		// but making it false has some advantages, e.g. the blocks that has only two lines
		// can be removed.. So when we're finished this function should return false
		return false;
	}
	
	boolean notJukta(char thirdCarry, char secondCarry, char carry, char now){
		
		if(now == 'r' || now == 'z' || now == 'w')
			return false;
	
		String foo = unicode.getDualJkt(secondCarry, carry);

		if(foo != null)
			return !isCharInString(now, foo); //? false : true;
		
		foo = unicode.getJkt(carry);
		if(foo != null)
			return !isCharInString(now, foo); // ? false : true;
		
		
		// if we didn't cover it here let's assume a consonant sits under it so we return false
		// but making it true has some advantages, e.g. the blocks that has only two lines
		// can be removed.. So when we're finished, this function should return true
		return true;
	}
	
}
