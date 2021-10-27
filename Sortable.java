package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/sortable/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//switch to frame 
		driver.switchTo().frame(0);
		
		WebElement e1=driver.findElement(By.xpath("//ul[@id='sortable']/li[1]"));
		WebElement e4=driver.findElement(By.xpath("//ul[@id='sortable']/li[4]"));
		
		Point location=e4.getLocation();
		int x=location.getX();
		int y=location.getY();
		
		Actions builder=new Actions(driver);
		builder.dragAndDropBy(e1, x, y).perform();
		
		
		

	}

}
