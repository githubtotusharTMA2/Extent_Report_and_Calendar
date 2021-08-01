package testcases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarSelectTest
{
	@FindBy(xpath = "(//button[@class = 'ui-datepicker-trigger'])[1]")
	static WebElement calendar_Button;
	
	@FindBy(xpath = "(//span[@class = 'ui-datepicker-year'])[2]")
	static WebElement year;
	
	@FindBy(xpath = "//span[contains(text(), 'Next')]")
	static WebElement nextButton;
	
	@FindBy(xpath = "(//span[@class = 'ui-datepicker-month'])[2]")
	static WebElement month;
	
	
	public static void main(String gsar[])
	{

		System.setProperty("webdriver.chrome.driver", "E:\\QA_Infotech\\Training_Works\\Eclipse\\Utils\\Selenium_browser_drivers\\chromedriver\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		PageFactory.initElements(driver, new CalendarSelectTest());
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://spicejet.com/");
		
		String date[] = "5-June-2022".split("-");
		
		if(calendar_Button.isDisplayed())
		{
		
		// click on calendar icon -
		calendar_Button.click();
		
		
		// choose year -
		while(!year.getText().equals(date[2]))
			nextButton.click();
		
		// choose month -
		while(!month.getText().equals(date[1]))
			nextButton.click();
		
		String day_start_part = "/html/body/div[2]/div[2]/table/tbody/tr[";
		String day_middle_part = "]/td[";
		String day_end_part = "]/a";
		
		boolean flag = false;
		for(int i = 1; i <= 5; i++)
		{
			for(int j = 1; j <= 7; j++)
			{
				String date_xpath = "";
				WebElement day_in_calendar = null;
				try
				{
					date_xpath = day_start_part + i + day_middle_part + j + "]";
					day_in_calendar = driver.findElement(By.xpath(date_xpath));
					if(day_in_calendar.getText().equals(date[0]))
					{
						day_in_calendar.click();
						flag = true;
						break;
					}
					
				}
				catch(Exception e)
				{
					date_xpath = day_start_part + i + day_middle_part + j + day_end_part;
					day_in_calendar = driver.findElement(By.xpath(date_xpath));
					if(day_in_calendar.getText().equals(date[0]))
					{
						day_in_calendar.click();
						flag = true;
						break;
					}
				}
			}
			if(flag)
				break;
		}
		
		System.out.println("All Done");
		
		} //  if
		else
		{
			System.out.println("calendar button not loaded");
		}
	}
}
