package stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BestAnswer 
{
	WebDriver driver;

@Given("^Open browser and Login$")
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

@When("^Mark as best answer$")
public void mark_as_best_answer() throws Throwable 
{
	   driver.findElement(By.xpath("(//*[text()='what is data'])[3]")).click();
       Thread.sleep(50000);
       driver.findElement(By.xpath("//*[@id='answers_main_list']/descendant::a[3]")).click();
       Thread.sleep(5000);
}

@Then("^Log out$")
public void log_out() throws Throwable 
{
	driver.findElement(By.xpath("//*[@class='display_name']")).click();
	driver.findElement(By.xpath("//*[@id='header_sidebar']/preceding::*[2]")).click();
    Thread.sleep(5000);
}

}
