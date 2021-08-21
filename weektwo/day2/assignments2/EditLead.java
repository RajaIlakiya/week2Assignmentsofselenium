package weektwo.day2.assignments2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	/*http://leaftaps.com/opentaps/control/main
	
	* 1	Launch the browser
	* 2	Enter the username
	* 3	Enter the password
	* 4	Click Login
	* 5	Click crm/sfa link
	* 6	Click Leads link
	* 7	Click Find leads
	* 8	Enter first name
	* 9	Click Find leads button
	* 10 Click on first resulting lead
	* 11 Verify title of the page
	* 12 Click Edit
	* 13 Change the company name
	* 14 Click Update
	* 15 Confirm the changed name appears
	* 16 Close the browser (Do not log out)
*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("(//label[text()='First name:'])[3]/following::input")).sendKeys("Raja Ilakiya");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String titlePage = driver.getTitle();
		System.out.println("Title of the page : "+titlePage);
		if(title.equalsIgnoreCase("View Lead | opentaps CRM"))
			System.out.println("Page title has verified");
		
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		WebElement comName = driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']"));
		 String companyName = comName.getAttribute("value");
		comName.clear();
		comName.sendKeys("TCS");
		System.out.println("Company name before update : "+companyName);
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		String updatedCompanyName = driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText();
		System.out.println("Updated Company Name is :"+updatedCompanyName);
		if(companyName.equalsIgnoreCase(updatedCompanyName))
			System.out.println("Company name was not updated");
		else	
			System.out.println("Company Name updated successfully");
				
//        driver.close();
	}

}
