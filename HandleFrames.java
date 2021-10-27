package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleFrames {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//switch to frame
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		
		//handle alert
		Alert alert=driver.switchTo().alert();
		Thread.sleep(2000);
		//alert.accept();
		alert.dismiss();
	
		//get text and verify
		WebElement element1=driver.findElement(By.xpath("//p[@id='demo']"));
		String text=element1.getText();
		System.out.println(text);
		
		if(text.contains("OK"))
		{
			System.out.println("You pressed OK button");
		}
		
		else if (text.contains("Cancel"))
		{
			System.out.println("You pressed Cancel button");
		}
		
		
		driver.close();
	}
}
