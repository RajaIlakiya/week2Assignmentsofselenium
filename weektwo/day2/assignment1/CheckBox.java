package weektwo.day2.assignment1;



import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBox {
//	7) Complete all 4 activities in CheckBox Page: http://leafground.com/pages/checkbox.html

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
//		Click on this image to go home page
		driver.get("http://leafground.com/pages/checkbox.html");
		
		//Select the languages that you know?
        driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
		driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).click();
		driver.findElement(By.xpath("(//input[@type='checkbox'])[4]")).click();

		
	// Confirm Selenium is checked	
		boolean checkbox2=driver.findElement(By.xpath("(//label[contains(text(),'Confirm Selenium is checked')]//following::input)[1]")).isSelected();

		if(checkbox2)
		{
			System.out.println("Yes.Selenium is checked");
		}
		else
		{
			System.out.println("No,Selenium is not checked");
		}

	//DeSelect only checked	
		boolean deSelectCheck = driver.findElement(By.xpath("(//label[text()='DeSelect only checked']/following::input)[2]")).isSelected();
		if(!deSelectCheck)
		driver.findElement(By.xpath("(//label[text()='DeSelect only checked']/following::input)[2]")).click();
		driver.findElement(By.xpath("(//label[text()='DeSelect only checked']/following::input)[2]")).click();
		boolean checkbox3=driver.findElement(By.xpath("//label[contains(text(),'DeSelect only checked')]//following::div[2]//input")).isSelected();
		if(checkbox3)
			driver.findElement(By.xpath("//label[contains(text(),'DeSelect only checked')]//following::div[2]//input")).click();
	

//	/Select all below checkboxes
	
	driver.findElement(By.xpath("(//label[text()='Select all below checkboxes ']/following::input)[1]")).click();
	driver.findElement(By.xpath("(//label[text()='Select all below checkboxes ']/following::input)[2]")).click();
	driver.findElement(By.xpath("(//label[text()='Select all below checkboxes ']/following::input)[3]")).click();
	driver.findElement(By.xpath("(//label[text()='Select all below checkboxes ']/following::input)[4]")).click();	
	driver.findElement(By.xpath("(//label[text()='Select all below checkboxes ']/following::input)[5]")).click();

	}

}