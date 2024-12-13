package intershala_Assi;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Final_Project {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		WebDriver Driver=new EdgeDriver();
		Driver.get(" http://tutorialsninja.com/demo/");
		Driver.manage().window().maximize();
		Driver.findElement(By.xpath("//span[text()='My Account']")).click();
		Driver.findElement(By.xpath("//a[text()='Login']")).click();
		//use implicit wait
		Driver.manage().timeouts().implicitlyWait(30,TimeUnit.MILLISECONDS);



		Driver.findElement(By.id("input-email")).sendKeys("malarmannang1@gmail.com");
		Driver.findElement(By.id("input-password")).sendKeys("1234567890");
		Driver.findElement(By.xpath("//input[@value='Login']")).click();


		WebElement laptops=Driver.findElement(By.xpath("//a[text()='Laptops & Notebooks']"));
		WebElement ShowAlllaptop=Driver.findElement(By.xpath("//a[text()='Show AllLaptops & Notebooks']"));
		Actions action=new Actions(Driver);
		action.moveToElement(laptops).click(ShowAlllaptop).build().perform();
		Driver.findElement(By.xpath("(//span[text()='Add to Cart'])[3]")).click();

		WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Add to Cart'])[4]")));
		//WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Add to Cart'])[4]")));
		//element.click();

		Driver.findElement(By.xpath("//span[text()='Shopping Cart']")).click();

		WebElement Shopingbtn = Driver.findElement(By.xpath("//span[text()='Shopping Cart']"));
		((JavascriptExecutor) Driver).executeScript("arguments[0].scrollIntoView(true);", Shopingbtn);
		Shopingbtn.click();

		String product1=Driver.findElement(By.xpath("(//a[contains(@href,'product_id=44')])[4]")).getText();
		String product2=Driver.findElement(By.xpath("(//a[contains(@href,'product_id=45')])[4]")).getText();

		if(product1.equals("MacBook Air")) {
			System.out.println("product1 text is displayed correctly");
		}else {
			System.out.println("product 1 text is displayed wrongly");
		}
		if(product2.equals("MacBook Pro")) {
			System.out.println("product2 text is displayed correctly");
		}else {
			System.out.println("product1 text is not  displayed correctly");
		}
		// total amt validate
		String Totalamt=Driver.findElement(By.xpath("(//table[@class='table table-bordered'])[3]//tr[4]/td[2]")).getText();
		if(Totalamt.equals("$45,252.00")) {
			System.out.println("Total amt text is displayed correctly");
		}else {
			System.out.println("Total amt mismatched");
		}

		Driver.findElement(By.xpath("//a[text()='Checkout']")).click();
		Driver.quit();

	}
}
