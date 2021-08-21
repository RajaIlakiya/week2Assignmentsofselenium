package weektwo.day2.assignment1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Link {
//	3) Complete all the 5 activities in HyperLink Page: http://leafground.com/pages/Link.html

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Link.html");

//		Go to home page
		driver.findElement(By.xpath("//a[contains(text(),'Go to Home Page')]")).click();
		String title1 = driver.getTitle();
		System.out.println(title1);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().back();

//		Find where am supposed to go without clicking me?
		String hrefLink = driver.findElement(By.xpath("//a[contains(text(),'without clicking me?')]")).getAttribute("href");
		System.out.println("Supposed to go:" + hrefLink);

//      Verify am I broken?
		driver.findElement(By.xpath("//a[contains(text(),'Verify am I broken?')]")).click();
        int responseCode = 404;
        
		if (responseCode >= 404)

		{
			System.out.println("Given link is broken");
		} else
			System.out.println("Given link is not a broken");

		String title = driver.getTitle();
		System.out.println(title);

//	    Go to Home Page (Interact with same link name)
		driver.navigate().to("http://leafground.com/home.html");
		String title2 = driver.getTitle();
		
//		Verify Interact with same link name or not
		
		if (title1.equals(title2)) {
			System.out.println("Interact with same link");
		} else {
			System.out.println("Interact with same link");
		}
		
//       back to link page
		driver.findElement(By.xpath("//div[@class='wp-landing-categories']//li[3]//img")).click();
//       count the total number of links in the current page
		int linksCount = driver.findElements(By.tagName("a")).size();
		System.out.println("Total number of links: " + linksCount);

	}

}
