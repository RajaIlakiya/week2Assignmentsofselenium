package weektwo.day2.assignments2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {
	/*http://leaftaps.com/opentaps/control/main
	 
	1	Launch the browser
	2	Enter the username
	3	Enter the password
	4	Click Login
	5	Click crm/sfa link
	6	Click Leads link
	7	Click Find leads
	8	Click on Email
	9	Enter Email
	10	Click find leads button
	11	Capture name of First Resulting lead
	12	Click First Resulting lead
	13	Click Duplicate Lead
	14	Verify the title as 'Duplicate Lead'
	15	Click Create Lead
	16	Confirm the duplicated lead name is same as captured name
	17	Close the browser (Do not log out)
	
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
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		driver.findElement(By.name("emailAddress")).sendKeys("ilakiyababu2821@gmail.com");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		String element = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a")).getText();
		System.out.println(element);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
		String title1 = driver.getTitle();
		if(title1.contains("Duplicate Lead")) {
			System.out.println(title1);
		}
		driver.findElement(By.className("smallSubmit")).click();
		String duplicateChk = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		if(element.equals(duplicateChk)) {
			System.out.println("Duplicated lead name is same as captured name");
		}
		else {
			System.out.println("Duplicated lead name is not same as captured name");
		}
//		driver.close();
	}

}
