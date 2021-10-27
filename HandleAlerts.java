package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleAlerts {

	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/Alert.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//simple alert
		driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
		Thread.sleep(2000);
		Alert al1=driver.switchTo().alert();
		String text1=al1.getText();
		System.out.println("Simple alert text: " + text1);
		al1.accept();
		
		if(text1.contains("alert box"))
		{
			System.out.println("Simple alert is validated");
		}
		
		//confirmation alert
		driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
		Thread.sleep(2000);
		String text2=al1.getText();
		System.out.println("Confirmation alert text: " + text2);
		al1.dismiss();
		
		if(text2.contains("Press a button"))
		{
			System.out.println("Confirmation alert is validated");
		}
		
		//prompt alert
		driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
		Thread.sleep(2000);
		al1.sendKeys("abcdef");
		Thread.sleep(1000);
		al1.accept();
		Thread.sleep(1000);
		driver.close();
		
		
	}
}
