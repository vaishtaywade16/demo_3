package udemy_project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class locators1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	     String password= passmethod(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		String name="vaishnavi";
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
        
        System.out.println(driver.findElement(By.tagName("h2")).getText());
        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(), "Hello "+name+",");
        
        //xpath for buttons---> //tagname[text()='Attributevalue']
        driver.findElement(By.xpath("//button[text()='Log Out']")).click();
       
        driver.close();
       
        
	}
	public static String passmethod(WebDriver driver  ) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		String pass =driver.findElement(By.cssSelector("form p")).getText();
		String[] passwordarray=pass.split("'");
	    String[] passwordarray1=passwordarray[1].split("'");
	   String Actualpass= passwordarray1[0];
	   return Actualpass;
	}
	
	

}
