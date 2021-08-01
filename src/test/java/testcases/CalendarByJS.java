package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CalendarByJS
{
	@Test
	public static void ss(String gsar[])
	{
		System.setProperty("webdriver.chrome.driver", "E:\\QA_Infotech\\Training_Works\\Eclipse\\Utils\\Selenium_browser_drivers\\chromedriver\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://spicejet.com/");
		
		//WebElement date = driver.findElement(By.id("ctl00_mainContent_view_date1"));
		WebElement date = driver.findElement(By.xpath("//button[@class = 'ui-datepicker-trigger']"));
		String dateValue = "30-8";
		
		selectDateByJS(driver, date, dateValue);
	}
	
	
	public static void selectDateByJS(WebDriver driver, WebElement element, String dataValue)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].setAttribute('value', '"+dataValue+"');", element);
		
	}
}
