package my.practice.working;

import java.util.Random;

public class Random_Number_Generation {

	public static void main(String[] args) {


		String string = generateRandomChars("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 3);
		String num = generateRandomChars("1234567890", 3);		
		String nameCap = generateRandomChars("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 1);
		String nameCap1 = generateRandomChars("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 1);
		String nameSmall = generateRandomChars("abcdefghijklmnopqrstuvwxyz", 5);
		String nameSmall1 = generateRandomChars("abcdefghijklmnopqrstuvwxyz", 5);
		String number0 = generateRandomChars("1234567890", 4);
		String number1 = generateRandomChars("1234567890", 4);
		String number2 = generateRandomChars("1234567890", 4);
		String number3 = generateRandomChars("1234567890", 4);
		String password = generateRandomChars("1234567890",3);

		System.out.println("AA"+ "-" +string + num);
		System.out.println(nameCap+nameSmall + " " + nameCap1+nameSmall1);
		System.out.println(number0+ "-" +number1+ "-" +number2+ "-" +number3);
		System.out.println("Password@" + password);

	}
	public static String generateRandomChars(String characters, int length) {
				
	    StringBuilder strBuilder = new StringBuilder();
	    Random random = new Random();
	    for (int i = 0; i < length; i++) {
	        strBuilder.append(characters.charAt(random.nextInt(characters.length())));	        
	    }

	    return strBuilder.toString();
	}

	}

