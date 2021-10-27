package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Irctc {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		
		
		driver.findElement(By.xpath("//a[text()=' FLIGHTS ']")).click();
		
		Set<String> winSet=driver.getWindowHandles();
		List<String> winList=new ArrayList<String>(winSet);
		Thread.sleep(2000);
		driver.switchTo().window(winList.get(1));
		
		String text=driver.findElement(By.xpath("(//a[@href='mailto:flights@irctc.co.in'])[1]")).getText();
		Thread.sleep(1000);
		System.out.println(text);
		
		driver.switchTo().window(winList.get(0)).close();
		

	}

}
