package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.nykaa.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//mouse over to brands
		Actions builder=new Actions(driver);
		WebElement brands=driver.findElement(By.xpath("//a[text()='brands']"));
		builder.moveToElement(brands).perform();
		//Thread.sleep(1000);
		
		//search brand name and click on it
		driver.findElement(By.id("brandSearchBox")).sendKeys("Loreal");
		//Thread.sleep(1000);
		WebElement LP=driver.findElement(By.xpath("(//a[contains(text(),'Oreal Paris')])[1]"));
		builder.moveToElement(LP).click().perform();

		//check if title contains brand name
		String text1=driver.getTitle();
		//Thread.sleep(1000);
		//System.out.println(text1);
		if(text1.contains("L'Oreal Paris"))
		{
			System.out.println("Brand name verified: " + text1);
		}
		
		//filter to shampoo
		driver.findElement(By.xpath("//span[text()='Sort By : popularity']")).click();
		driver.findElement(By.xpath("//label[@for='radio_customer top rated_undefined']/div[2]")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[@id='first-filter']/div/span")).click();
		//Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='custom-scroll']/ul/li[1]/div/span[1]")).click();
		//Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='custom-scroll']/ul/li/ul/li[1]/div/span[1]")).click();
		//Thread.sleep(1000);
		driver.findElement(By.xpath("//label[@for='checkbox_Shampoo_316']/div[2]")).click();
		//Thread.sleep(1000);
		
		
		//click concern
		driver.findElement(By.xpath("//*[@id='filters-strip']/div/div/div[6]/div/span")).click();
		//Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='custom-scroll']/div/div[4]/label/div[2]")).click();
		//Thread.sleep(1000);
		
		//click on product
		driver.findElement(By.xpath("//a[@href='/l-oreal-paris-color-protect-shampoo/p/6282?productId=6282&pps=1']")).click();
		//Thread.sleep(1000);
		
		//switch to 2nd window
		Set<String> winset=driver.getWindowHandles();
		List<String> winlist=new ArrayList<String>(winset);
		//Thread.sleep(1000);
		driver.switchTo().window(winlist.get(1));
		
		//select 704ml
		driver.findElement(By.xpath("//span[text()='704ml']")).click();
		//Thread.sleep(1000);
		
		
		//print the mrp
		String mrp=driver.findElement(By.xpath("(//span[text()='MRP:'])[1]/following-sibling::span")).getText();
		System.out.println("MRP: " + mrp);
		
		//add to bag and click on cart
		driver.findElement(By.xpath("(//span[text()='ADD TO BAG'])[1]")).click();
		driver.findElement(By.xpath("//span[@class='cart-count']/..")).click();
		
		//switch to frame
		driver.switchTo().frame(0);
		
		//print grand total amount
		String gt=driver.findElement(By.xpath("(//span[text()='Grand Total'])[2]/following-sibling::div")).getText();
		System.out.println("Grand total: " + gt);
		
		//click proceed
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		driver.findElement(By.xpath("//button[@class='btn full big']")).click();
		
		//check if grand total is same
		String gt1=driver.findElement(By.xpath("//div[text()='Grand Total']/following-sibling::div")).getText();
		if(gt.equals(gt1))
		{
			System.out.println("Grand Total verified " + gt1);
		}
		
		driver.quit();
		
		
	}

}
