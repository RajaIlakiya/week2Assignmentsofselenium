package weektwo.day2.assignment1;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class EditPage {
//	1) Complete all the 5 activities in Edit Page: http://leafground.com/pages/Edit.html

public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/Edit.html");
		//Enter your email address
		WebElement app=driver.findElement(By.xpath("//input[@id='email']"));
		app.sendKeys("ilakiyababu2821@gmail.com");
	     //Append a text and press keyboard tab
		//Clear text in textbox
		driver.findElement(By.xpath("//input[@value='Append ']")).clear();
		//Append a text"ilakiya babu"
		WebElement append=driver.findElement(By.xpath("//input[@value='Append ']"));
		append.sendKeys("ilakiya babu");
		//press keyboard tab
	    WebElement inputField = driver.findElement(By.xpath("//input[@value='Append ']"));
	    inputField.sendKeys(Keys.TAB);
	    //Get default text entered.text="Test Leaf"
	    String text=driver.findElement(By.xpath("//input[@name='username']")).getAttribute("value");
	    System.out.println("Get default text is: " + text);
	    //Clear the text
	    driver.findElement(By.xpath("(//input[@name='username'])[2]")).clear();
	    //Confirm that edit field is disabled
	    boolean result=driver.findElement(By.xpath("//input[@disabled='true']")).isEnabled();
	    if(result!=true)
	    {System.out.println("Edit field is disabled");
	    }   
	    else
	    {System.out.println("Edit field is enabled");
	    } 
	    }
	

	}




