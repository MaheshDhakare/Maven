package my.practice.working;

public class TestLengthWIthoutLengthMethod {

	public static void main(String[] args) {
int cnt = 0;
		String value = "Mahesh Dhakare";
		
		char[] charArray = value.toCharArray();
		for (char c : charArray) {
			String of = String.valueOf(c);
		if (!of.contains(" ")) {
				cnt++;
			}			
		}
		System.out.println("Length of string is " +"'"+ cnt + "'");
		
	}

}
