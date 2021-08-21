package weektwo.day2.assignments2;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class DeleteLead {
	/*http://leaftaps.com/opentaps/control/main
	 
	Delete Lead:
	1	Launch the browser
	2	Enter the username
	3	Enter the password
	4	Click Login
	5	Click crm/sfa link
	6	Click Leads link
	7	Click Find leads
	8	Click on Phone
	9	Enter phone number
	10	Click find leads button
	11	Capture lead ID of First Resulting lead
	12	Click First Resulting lead
	13	Click Delete
	14	Click Find leads
	15	Enter captured lead ID
	16	Click find leads button
	17	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
	18	Close the browser (Do not log out)
*/
	public static void main(String[] args)  {
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
		driver.findElement(By.xpath("(//span[@class='x-tab-strip-inner'])[2]")).click();
		WebElement phoneNo = driver.findElement(By.xpath("//input[@name='phoneCountryCode']"));
		phoneNo.clear();
		phoneNo.sendKeys("91");
		driver.findElement(By.xpath("//input[@name='phoneAreaCode']")).sendKeys("097");
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("7358653065");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String attribute = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]"))
				.getText();
		System.out.println(attribute);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
		driver.findElement(By.className("subMenuButtonDangerous")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(attribute);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String text = driver.findElement(By.className("x-paging-info")).getText();
		if (text.contains("No records to display")) {
			System.out.println("record deleted successfully");
		} else {
			System.out.println("record not deleted");
		}

//		driver.close();
	}
}
