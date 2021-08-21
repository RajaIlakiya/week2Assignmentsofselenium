package weektwo.day2.assignment1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownPage {

//	5) Complete all the 5 activities in DropDown Page: http://leafground.com/pages/Dropdown.html

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

//		Click on this image to go home page
		driver.get("http://leafground.com/pages/Dropdown.html");

		// selectByIndex
		WebElement drpdwn1 = driver.findElement(By.xpath("//select[@id='dropdown1']"));
		Select dropDown1 = new Select(drpdwn1);
		dropDown1.selectByIndex(1);

		// selectByVisibleText
		WebElement drpdwn2 = driver.findElement(By.xpath("//select[@name='dropdown2']"));
		Select dropDown2 = new Select(drpdwn2);
		dropDown2.selectByVisibleText("Appium");

		// selectByValue
		WebElement drpdwn3 = driver.findElement(By.xpath("//select[@id='dropdown3']"));
		Select dropDown3 = new Select(drpdwn3);
		dropDown3.selectByValue("3");

		// Get the number of dropdowns options
		driver.findElement(By.xpath("//select[@class='dropdown']")).click();
		List<WebElement> optionCount = driver.findElements(By.xpath("//select[@class='dropdown']//option"));
		System.out.println("Total options: " + optionCount.size());
		
		//(OR)

		// Count all dropdown option in one dropdown box
		WebElement ele = driver.findElement(By.xpath("//select[@class='dropdown']"));
		Select sel = new Select(ele);
		int drpdwmList = sel.getOptions().size();
		System.out.println("Number of dropdownmoption in particular feild: " + drpdwmList);


		// click dropdown option using sendkeys
WebElement ele1=	driver.findElement(By.xpath("//div[@id='contentblock']//div[5]//select"));
ele1.sendKeys("UFT/QTP");

		// Select your program

		WebElement selectprgm = driver.findElement(By.xpath("//section[@class='innerblock']//div[6]//select"));
		Select program = new Select(selectprgm);
		int listSize = program.getOptions().size();
		System.out.println("List size: " + listSize);
		program.selectByIndex(listSize - 1);

	}
}
