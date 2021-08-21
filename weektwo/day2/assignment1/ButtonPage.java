package weektwo.day2.assignment1;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ButtonPage {
//	2) Complete all the 4 activities in Button Page: http://leafground.com/pages/Button.html

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Button.html");
//Click button to travel home page
		driver.findElement(By.xpath("//button[contains(text(),'Go to Home Page')]")).click();
//Find position of button (x,y)
		driver.navigate().back();
		WebElement position = driver.findElement(By.xpath("//button[@id='position']"));
		Point location = position.getLocation();
		int x = location.getX();
		int y = location.getY();
		System.out.println("Find position of button (x,y) : " + x + " and " + y);

		// Find button color
		String colr = driver.findElement(By.xpath("//button[@id='color']")).getCssValue("background-color");
		System.out.println(colr);
//		 Find the height and width
		WebElement hgtwid = driver.findElement(By.xpath("//button[@id='position']"));
		Dimension dimension = hgtwid.getSize();
		int height = dimension.getHeight();
		int width = dimension.getWidth();
		System.out.println("Find position of button (height,width) : " + height + " and " + width);

	}

}
