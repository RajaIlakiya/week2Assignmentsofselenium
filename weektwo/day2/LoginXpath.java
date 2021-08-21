package weektwo.day2;

	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class LoginXpath {
		// Step 1: Download and set the path 
		// Step 2: Launch the chromebrowser
		// Step 3: Load the URL
		// Step 4: Maximise the window
		// Step 5: Locate the username and type "demosalesmanager"
		// Step 6: Locate the password and type "crmsfa"
		// Step 7: Locate the Login button and click it
		// Step 9: Click CRM/SFA link

		
		public static void main(String[] args) {
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver=new ChromeDriver();
			driver.get("http://leaftaps.com/opentaps");
			String title=driver.getTitle();
			System.out.println(title);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement webUser=driver.findElement(By.xpath("username"));
			webUser.sendKeys("demosalesmanager");
	driver.findElement(By.xpath("//input[@id='username']")).sendKeys("crmsfa");
			driver.findElement(By.xpath("decorativeSubmit")).click();
			driver.findElement(By.linkText("CRM/SFA")).click();
			
			

			driver.close();
			}


}
