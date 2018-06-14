package guru99Bank_Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class CommanMethods {
	
WebDriver driver;
	
	
public CommanMethods(WebDriver driver1) {

 this.driver = driver1;

}		
	
	public WebElement findElement(By webElement) {

		WebElement element = driver.findElement(webElement);
		return element;
		
	}
	
}
