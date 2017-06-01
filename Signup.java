package stepdefinition;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Signup 
{
	WebDriver driver;
	
	@Given("^Open chrome browser enter url interviewhut\\.com$")
	public void open_chrome_browser_enter_url_interviewhut_com() throws Throwable 
	{
		 System.setProperty("webdriver.chrome.driver", "F:\\selenium228\\seleniumBrowserdrivers\\chromedriver.exe"); 
		   driver=new ChromeDriver();
		   driver.manage().window().maximize();
		   driver.get("http://stage.interviewhut.com/");
		   Thread.sleep(10000);
	}

@When("^Click register and fill the fields$")
public void click_register_and_fill_the_fields() throws Throwable 
{
	driver.findElement(By.linkText("Login or Register")).click();
	Thread.sleep(5000);
	driver.findElement(By.linkText("Sign up here")).click();
	Thread.sleep(10000);
	driver.findElement(By.xpath("(//*[@id='username'])[2]")).sendKeys("sekarreddy"); 
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	driver.findElement(By.xpath("(//*[@id='email'])[1]")).sendKeys("sekarcreddy@gmail.com");
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	driver.findElement(By.id("password1")).sendKeys("112411106075");
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	driver.findElement(By.id("re_password")).sendKeys("112411106075");
	//create alert for captcha
	JavascriptExecutor js= (JavascriptExecutor) driver;
	js.executeScript("alert('manually select captcha');");
	Thread.sleep(50000);
	driver.findElement(By.name("submit")).click();
	Thread.sleep(5000);   
}

@When("^Update profile picture$")
public void update_profile_picture() throws Throwable 
{
	   driver.findElement(By.xpath("//*[@class='display_name']")).click();
	   driver.findElement(By.xpath("//*[@class='open-edit-profile edit_profile']")).click();
	   driver.findElement(By.id("user_avatar_browse_button")).click();
	   driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	   //upload image use javaRobot
	   Robot r=new Robot();
	   StringSelection s=new StringSelection("F:\\cartoon-man-working-computer.jpg");
	   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
	   r.keyPress(KeyEvent.VK_CONTROL);
	   r.keyPress(KeyEvent.VK_V);
	   r.keyRelease(KeyEvent.VK_V);
	   r.keyRelease(KeyEvent.VK_CONTROL);
	   Thread.sleep(5000);
	   r.keyPress(KeyEvent.VK_ENTER);
	   r.keyRelease(KeyEvent.VK_ENTER);
	   Thread.sleep(5000);   
}

@When("^Enter your personal details and save$")
public void enter_your_personal_details_and_save() throws Throwable 
{
	driver.findElement(By.name("user_location")).sendKeys("banglore");
    driver.findElement(By.name("user_facebook")).sendKeys("sekarReddy");
    driver.findElement(By.name("user_twitter")).sendKeys("sekar@sekarcReddy");
    driver.findElement(By.name("user_email")).sendKeys("sekarcreddy@gmail.com");
    driver.findElement(By.name("description")).sendKeys("hi i am graduate engineer in ece domain");
    driver.findElement(By.name("submit")).click();
    Thread.sleep(5000);
}

@Then("^Logout$")
public void logout() throws Throwable 
{
	driver.findElement(By.xpath("//*[@class='display_name']")).click();
	driver.findElement(By.xpath("//*[@id='header_sidebar']/preceding::*[2]")).click();
    Thread.sleep(5000);
}

}
