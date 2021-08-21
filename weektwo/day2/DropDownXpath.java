package weektwo.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownXpath {


		public static void main(String[] args) {
			// TODO Auto-generated method stub
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver=new ChromeDriver();
			driver.get("http://leaftaps.com/opentaps");
			String title=driver.getTitle();
			System.out.println(title);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement webUser = driver.findElement(By.xpath("//input[@id='username']"));
			webUser.sendKeys("demosalesmanager");
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
//		  Click on Login Button 
			driver.findElement(By.className("decorativeSubmit")).click();
			driver.findElement(By.xpath("//a[contains(text(),'CRM')]")).click();

//			  Click on Leads Button	
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
//			  Click on create Lead Button
		driver.findElement(By.xpath("//a[text()='Create Lead']")).click();
			
			WebElement drpdwn1=driver.findElement(By.xpath("//select[@id='createLeadForm_dataSourceId']"));
			Select source=new Select(drpdwn1);
			source.selectByValue("LEAD_DIRECTMAIL");
			
			WebElement drpdwn2=driver.findElement(By.xpath("//select[@id='createLeadForm_ownershipEnumId']"));
			Select ownership=new Select(drpdwn2);
			ownership.selectByVisibleText("Corporation");
		}
			
		
		}
