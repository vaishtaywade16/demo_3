package udemy_project;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import assignments.windowAssignment;

import org.openqa.selenium.*;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

public class ecommerce {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		driver.findElement(By.id("userEmail")).sendKeys("taywadevaishnavi@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Captcha@1");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement>products=driver.findElements(By.cssSelector(".mb-3"));
	
		WebElement prod=products.stream().filter(s->s.findElement(By.cssSelector("b"))
		.getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

		
		//flashing box of items added
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		// wait until screen to be active back // xpath of loading screen
		wait.until(ExpectedConditions.invisibilityOf(driver
				.findElement(By.cssSelector(".ng-animating"))));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("button[routerlink*='cart']"))));
		driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
		
		List<WebElement> items=driver.findElements(By.cssSelector(".cartSection h3"));
	Boolean match=	items.stream().anyMatch(s->s.getText().equalsIgnoreCase("ZARA COAT 3"));
	Assert.assertTrue(match);
	driver.findElement(By.xpath("//button[text()='Checkout']")).click();
	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted"))));
	JavascriptExecutor js =(JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,650)");
	//Thread.sleep(5000);
	Actions action = new Actions(driver);
	action.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india")
	.build().perform();
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-item")));
	driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ta-item")));
	
	
    driver.findElement(By.cssSelector(".action__submit")).click();
	}
}
