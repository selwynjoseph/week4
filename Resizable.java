package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Resizable {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/resizable/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//switch to frame 
		driver.switchTo().frame(0);
				
		//locate the element inside the frame
		WebElement element1=driver.findElement(By.xpath("//div[@id='resizable']/div[3]"));
		
		//use actions class to perform the desired action
		Actions builder=new Actions(driver);
		
		//click and hold on the element
		builder.clickAndHold(element1).perform();
		Thread.sleep(1000);
		
		//move it by dragging the element
		builder.moveByOffset(170, 170).perform();
		
		//release after action is performed
		builder.release();
		
		
		
		
		
	}

}
