package udemy_project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class locators {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		
		driver.findElement(By.id("inputUsername")).sendKeys("vaishnavi");
		driver.findElement(By.name("inputPassword")).sendKeys("myacademy");
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(3);
		
		// css using ---> tagname.classname
		System.out.println(driver.findElement(By.cssSelector("p[class='error']")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		//this generic xpath--> //tagname[@attribute='value']
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("john");
		
		//css selector --> tagname[attribute='value']
		driver.findElement(By.cssSelector("input[placeholder='Email'] ")).sendKeys("john@arc");
		
		//xpath --> //tagname[@attribute='value'][index value]
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		
		//css selector if no option 
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("john@gmail.com");
		
		// xpath with only tagname from parent to child tagname with index value
		// --> //parent tagname/child tagname
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("1234567890");
		
		//css selctor --> tagname.classname
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		
		//css selector with only tagname
		//---> parent tagname(space)childtagname
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		driver.findElement(By.xpath("//button[@class='go-to-login-btn']")).click();
		
		// css selector using only id --> #id
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("vaishnavi");
		
		// css selector when atrribute value is dynamic in nature ---> tagname[attribute*=const value]
		driver.findElement(By.cssSelector("input[type*=pass]")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("chkboxOne")).click();
		
		//xpath when 
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
	}

}
