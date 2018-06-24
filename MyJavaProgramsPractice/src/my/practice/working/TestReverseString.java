package my.practice.working;

public class TestReverseString {

	public static void main(String[] args) {

		int num1 = 10;
		int num2 = 20;
		int temp;
		System.out.println("Before swap numbers are " + "num1 is - "+num1 +" and "+"num2 is - "+ num2 );
		temp = num1;
		num1 = num2;
		num2= temp;
		System.out.println("After swap numbers are " + "num1 is - "+num1 +" and "+"num2 is - "+ num2 );
		
	}
}

