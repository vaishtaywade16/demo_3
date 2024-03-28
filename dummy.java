package udemy_project;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dummy {

	public static void main(String[] args) throws InterruptedException {
		int j=0;
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String[] itemsNeeded= {"Brocolli","Cucumber","Beetroot","Carrot"};
		 List<String> itemsNeededList = Arrays.asList(itemsNeeded)  ;
		
	    Thread.sleep(3000);
	    
	     List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
	     
	     List<WebElement> buttons=driver.findElements(By.xpath("//div[@class='product-action']/button"));
	     
	     
	     for(int i=0; i<products.size(); i++) {
	    	 String productName =  products.get(i).getText().split("-")[0].trim();
	    	 // String formatedname=name[0].trim();
	    	  //System.out.println(formatedname);
	    	  
	    	
	    	  
	  	if(itemsNeededList.contains(productName)){
	  		
	  	    	j++;
	 
	  	    	buttons.get(i).click();
	  	    	System.out.println("Clicked on product: " + productName);
	  	    	
	  	    	if( j==4) {
	  		    	break;
	  		    }
	  	    	
	  	    }
	}
	// driver.quit();    
	}
}
