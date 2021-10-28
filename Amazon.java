package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		//disable notifications
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//search oneplus9 pro
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro");
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		//get price
		WebElement price1=driver.findElement(By.xpath("(//span[@class='a-price'])[1]/span[2]/span[2]"));
		String price2=price1.getText();
		System.out.println("Price of the item is: " + price2);
		
		//print number of customer ratings
		WebElement ratings1=driver.findElement(By.xpath("(//span[contains(text(),'OnePlus 9 Pro 5G')])[1]/../../../../div[2]/div/span[2]/a/span"));
		String ratings2=ratings1.getText();
		System.out.println("No of ratings are: "+ratings2);
		
		//hover to stars icon and get the percentage
		Thread.sleep(2000);
		WebElement stars1=driver.findElement(By.xpath("(//i[contains(@class,'a-icon-popover')])[1]"));
		Actions builder=new Actions(driver);
		builder.moveToElement(stars1).click().perform();
		String perct=driver.findElement(By.xpath("(//a[contains(@title,'64% of reviews have 5 stars')])[3]")).getText();
		System.out.println("Percentage is: "+perct);
		
		//click on first product link
		driver.findElement(By.xpath("(//span[contains(text(),'OnePlus 9 Pro 5G')])[1]")).click();
		ArrayList<String> wlist=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(wlist.get(1));
		
		//get screenshot
		File src=driver.getScreenshotAs(OutputType.FILE);
		File dst=new File("./snap/pic1.png");
		FileUtils.copyFile(src, dst);
		
		//add to cart
		driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(3000);
		String carttotal=driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText();
		System.out.println(carttotal);
		
		if(carttotal.contains(price2))
		{
			System.out.println("Price verification successful");
		}
		
		driver.quit();
	}

}
