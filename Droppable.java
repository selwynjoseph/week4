package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Droppable {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//switch to frame 
		driver.switchTo().frame(0);
				
		//locate the element inside the frame
		WebElement draggable=driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement drop=driver.findElement(By.id("droppable"));
		
		//use actions class to perform the desired action
		Actions builder=new Actions(driver);
		Thread.sleep(2000);
		builder.dragAndDrop(draggable, drop).perform();
	
		
		
		

	}

}
