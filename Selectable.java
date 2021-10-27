package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectable {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/selectable/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//switch to frame 
		driver.switchTo().frame(0);
		
		WebElement el1=driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement el3=driver.findElement(By.xpath("//li[text()='Item 3']"));
		WebElement el5=driver.findElement(By.xpath("//li[text()='Item 5']"));
		
		Actions builder=new Actions(driver);
		//builder.clickAndHold(el1).moveToElement(el5).release().perform();
		
		builder.keyDown(Keys.CONTROL).click(el1).click(el3).click(el5).keyUp(Keys.CONTROL).perform();
		
		
		
		
	}
}
