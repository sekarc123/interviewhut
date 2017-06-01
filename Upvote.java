package stepdefinition;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Upvote 
{
	WebDriver driver;
	
	@Given("^open browser and Login$")
	public void open_browser_and_Login() throws Throwable 
	{	 
		 System.setProperty("webdriver.chrome.driver", "F:\\selenium228\\seleniumBrowserdrivers\\chromedriver.exe"); 
		   driver=new ChromeDriver();
		   driver.manage().window().maximize();
		   driver.get("http://stage.interviewhut.com/");
		   Thread.sleep(5000);
		    driver.findElement(By.linkText("Login or Register")).click();
		    Thread.sleep(5000);
		    driver.findElement(By.id("username")).sendKeys("sekarreddy");
		    driver.findElement(By.id("password")).sendKeys("112411106075");
			driver.findElement(By.name("submit")).click();
			Thread.sleep(5000);
	}

	@When("^upvote an answer$")
	public void upvote_an_answer() throws Throwable 
	{
		//selecting a question with answer
	    driver.findElement(By.xpath("//*[@data-id='1728']/descendant::h2[1]")).click();
	    Thread.sleep(5000);
	    //vote up to an answer
	    driver.findElement(By.xpath("//*[@id='answers_main_list']/descendant::a[1]")).click();
	    Thread.sleep(5000);
	    //switch back to home page
	    driver.findElement(By.xpath("//*[text()='Home']")).click();
	    Thread.sleep(5000);
	}

	@Then("^Log Out$")
	public void log_Out() throws Throwable 
	{
		driver.findElement(By.xpath("//*[@class='display_name']")).click();
		driver.findElement(By.xpath("//*[@id='header_sidebar']/preceding::*[2]")).click();
	    Thread.sleep(5000);	
	}
  
	
}
