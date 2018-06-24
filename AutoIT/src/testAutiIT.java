import java.io.File;

import autoitx4java.AutoItX;

import com.jacob.com.LibraryLoader;


public class testAutiIT {

	public static void main(String[] args) throws InterruptedException {

		
		File file = new File("Libs", "jacob-1.18-x64.dll");
		System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());
		System.out.println(file.getAbsolutePath());
		getVersionOfDll();
		
		AutoItX autoIT = new AutoItX();
		autoIT.run("calc");
		autoIT.winActivate("Calculator");
		Thread.sleep(2000);
		autoIT.send("100");
		Thread.sleep(2000);
		autoIT.send("+");
		Thread.sleep(2000);
		autoIT.send("100");
		Thread.sleep(2000);
		autoIT.send("=");
//		Thread.sleep(1000);
//		autoIT.controlClick("Calculator", "", "139");
//		Thread.sleep(1000);
//		autoIT.controlClick("Calculator", "", "131");
//		Thread.sleep(1000);
//		autoIT.controlClick("Calculator", "", "93");
//		Thread.sleep(1000);
//		autoIT.controlClick("Calculator", "", "121");
	}
public static void getVersionOfDll() {
	System.out.println(System.getProperty("sun.arch.data.model"));
}
}
