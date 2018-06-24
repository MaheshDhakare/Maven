package my.practice.working;

public class Test_unmatchedvalues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		

		String aa[] = {"Aa","Bb","Zz", "Ll", "Cc","Dd","Kk","Ll", "Cc","Pp","Oo"};
		
		int size = aa.length;
		
	String ref = "null";	

		for (int i = 0; i < size; i++) {
			for (int j = i+1; j < size; j++) {
				
				if (aa[i] == aa[j]) 
				{
					aa[j] = ref;
								
				}
			}
		}
	for (String string : aa) {
		System.out.println(string);
//		if (!string.contains("null")) {
//			
//			System.out.println(string);
//		}
	}
	
	}
}
