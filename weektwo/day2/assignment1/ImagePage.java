package weektwo.day2.assignment1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImagePage {
//4) Complete all the 1,2 activities in Image Page: http://leafground.com/pages/Image.html
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
//		Click on this image to go home page
		driver.get("http://leafground.com/pages/Image.html");
		driver.findElement(By.xpath("//label[contains(text(),'Click on this image to go home page')]//following::img")).click();
		driver.navigate().back();
		
//		Am I Broken Image?
		

		driver.findElement(By.xpath("//label[contains(text(),'Am I Broken Image?')]//following::img"));
		String broken=driver.getTitle();
		System.out.println(broken);


		String brokenimg = driver.findElement(By.xpath("//label[text()='Am I Broken Image?']/following-sibling::img")).getAttribute("src");
		System.out.println(brokenimg);
		driver.navigate().to("http://leafground.com/images/abcd.jpg");
		String brokenImgTitle = driver.getTitle();
		if (brokenImgTitle.contains("HTTP Status 404"))
			System.out.println("The image is broken");
		else
			System.out.println("The image is not broken ");
		driver.navigate().back();
		
//		
// Click me using Keyboard or Mouse

WebElement click=driver.findElement(By.xpath("//label[contains(text(),'Click me using Keyboard or Mouse')]//following::img"));
Actions action =new Actions(driver);
action.click(click).build().perform();

	

		
	}

}
