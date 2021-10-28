package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();
		//disable notifications
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.snapdeal.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
		
		
		//hover to mens fashion
		WebElement mf=driver.findElement(By.xpath("(//span[contains(text(),'Fashion')])[5]"));
		Actions builder=new Actions(driver);
		builder.moveToElement(mf).perform();
		Thread.sleep(1000);
		WebElement ss=driver.findElement(By.xpath("//span[contains(text(),'Sports Shoes')]"));
		builder.moveToElement(ss).click().perform();
		
		//get count of shoes
		WebElement shoecount=driver.findElement(By.xpath("//div[text()='Sports Shoes']/following-sibling::div"));
		String shoecount2=shoecount.getText();
		System.out.println("Shoe count is: " + shoecount2);
		
		//click on training shoes
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		
		//sort by low to high
		driver.findElement(By.xpath("//div[@class='sort-drop clearfix']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[@data-sorttype='plth']")).click();
		Thread.sleep(1000);
		
		
		
		//enter range 
		WebElement from=driver.findElement(By.name("fromVal"));
		from.clear();
		from.sendKeys("900");
		Thread.sleep(1000);
		
		WebElement to=driver.findElement(By.name("toVal"));
		to.clear();
		to.sendKeys("1200");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();
		Thread.sleep(1000);
		
		//scroll down
		//WebElement vm=driver.findElement(By.xpath("(//div[@class='filter-type-name lfloat'])[2]"));
		WebElement vm=driver.findElement(By.xpath("//span[@data-displaytype='rangeSlider']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",vm);
		
		
		//select colour
		WebElement black=driver.findElement(By.xpath("//label[@for='Color_s-Black']"));
		builder.moveToElement(black).click().perform();
		
		Thread.sleep(1000);
		//verify the filters
		Thread.sleep(6000);
		WebElement price1=driver.findElement(By.xpath("(//a[@data-key='Price|Price'])[1]"));
		WebElement colour1=driver.findElement(By.xpath("(//a[@data-key='Color_s|Color'])[1]"));
		Thread.sleep(1000);
		String pricecheck=price1.getText();
		String colourcheck=colour1.getText();
		System.out.println(pricecheck);
		System.out.println(colourcheck);
		
		
		//mouse over to first image
		WebElement firstres=driver.findElement(By.xpath("//img[@title='Sparx SM438 Black Training Shoes']"));
		builder.moveToElement(firstres).perform();
		driver.findElement(By.xpath("//div[@pogid='681488102464']")).click();
		Thread.sleep(1000);
		
		//print cost and discount percentage
		WebElement price2=driver.findElement(By.xpath("//span[@class='payBlkBig']"));
		WebElement discount2=driver.findElement(By.xpath("//span[@class='percent-desc ']"));
		String printprice2=price2.getText();
		String printdiscount2=discount2.getText();
		System.out.println("Price is: " + printprice2);
		System.out.println("Discount is: " + printdiscount2);
		
		//take snapshot
		File src=driver.getScreenshotAs(OutputType.FILE);
		File dst=new File("./snap/pic1.png");
		FileUtils.copyFile(src, dst);
		
		//close the window and the main page
		WebElement close=driver.findElement(By.xpath("//*[@id='sidebar_modal_right']/div[2]/div[2]"));
		builder.moveToElement(close).click().perform();
		driver.close();
		
		

	}

}
