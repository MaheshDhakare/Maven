package my.practice.working;

public class TestSwap {

	public static void main(String[] args) {
		char c;		
		String test = "Mahesh is very good person";
	System.out.println("Original String is "+ test);
		int j = test.length();
		int a = j;
	char[] arrayC = new char [j];
	
		for (int i = 0; i < test.length(); i++) {
					try {
					c = test.charAt(i);
					arrayC[a-1] = c;
					a--;
			} catch (Exception e) {
					System.out.println("Test");
				}
		}
		System.out.print("After reverse String is ");
		for (char d : arrayC) {
			System.out.print(d);
		}	
		
			
		}		
		
	}


