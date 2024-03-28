package udemy_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class frames {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		  WebDriver driver= new ChromeDriver();
		  driver.get("https://jqueryui.com/droppable/");
		  driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		  Actions action = new Actions(driver);
		WebElement source=driver.findElement(By.id("draggable"));
		WebElement targer=driver.findElement(By.id("droppable"));
		  action.dragAndDrop(source, targer).build().perform();
		  // defaultcontent will take back to main window from the frames
         driver.switchTo().defaultContent();
	}

}
