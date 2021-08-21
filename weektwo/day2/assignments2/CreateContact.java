package weektwo.day2.assignments2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * //Pseudo Code
 * 
 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
 * 
 * 2. Enter UserName and Password Using Id Locator
 * 
 * 3. Click on Login Button using Class Locator
 * 
 * 4. Click on CRM/SFA Link
 * 
 * 5. Click on contacts Button
 * 
 * 6. Click on Create Contact
 *  
 * 7. Enter FirstName Field Using id Locator
 * 
 * 8. Enter LastName Field Using id Locator
 * 
 * 9. Enter FirstName(Local) Field Using id Locator
 * 
 * 10. Enter LastName(Local) Field Using id Locator
 * 
 * 11. Enter Department Field Using any Locator of Your Choice
 * 
 * 12. Enter Description Field Using any Locator of your choice 
 * 
 * 13. Enter your email in the E-mail address Field using the locator of your choice
 * 
 * 14. Select State/Province as NewYork Using Visible Text
 * 
 * 15. Click on Create Contact
 * 
 * 16. Click on edit button 
 * 
 * 17. Clear the Description Field using .clear
 * 
 * 18. Fill ImportantNote Field with Any text
 * 
 * 19. Click on update button using Xpath locator
 * 
 * 20. Get the Title of Resulting Page.
 */

public class CreateContact {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		String title=driver.getTitle();
		System.out.println(title);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement webUser=driver.findElement(By.id("username"));
		webUser.sendKeys("demosalesmanager");
driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		driver.findElement(By.xpath("//a[text()='Create Contact']")).click();
		driver.findElement(By.xpath("//input[@id='firstNameField']")).sendKeys("Ilakiya");
		driver.findElement(By.xpath("//input[@id='lastNameField']")).sendKeys("Babu");
		driver.findElement(By.xpath("//input[@id='createContactForm_firstNameLocal']")).sendKeys("Ilakiya");
		driver.findElement(By.xpath("//input[@id='createContactForm_lastNameLocal']")).sendKeys("Babu");
		driver.findElement(By.xpath("//input[@id='createContactForm_departmentName']")).sendKeys("Tester");
		driver.findElement(By.xpath("//textarea[@id='createContactForm_description']")).sendKeys("NA");
		driver.findElement(By.xpath("//input[@id='createContactForm_primaryEmail']")).sendKeys("ilakiyababu2821@gmail.com");
		driver.findElement(By.xpath("//select[@id='createContactForm_generalStateProvinceGeoId']")).sendKeys("New York");
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		driver.findElement(By.xpath("//textarea[@name='description']")).clear();
		driver.findElement(By.xpath("//textarea[@name='importantNote']")).sendKeys("NA");
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		System.out.println("Title of the page is "+driver.getTitle());
	}
	
}
