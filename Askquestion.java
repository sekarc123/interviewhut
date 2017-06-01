package stepdefinition;


import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Askquestion 
{
	WebDriver driver;

	@Given("^Open browser and login$")
	public void open_browser_and_login() throws Throwable 
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

	@When("^Posting a question with sutable title and caregory$")
	public void posting_a_question_with_sutable_title_and_caregory() throws Throwable
	{
		driver.findElement(By.xpath("(//*[@class='action ask-question'])[2]")).click();
		//get data from excel 
		File f=new File("F:\\Interviewhutlogindata.xls");
		Workbook w=Workbook.getWorkbook(f);
		Sheet s=w.getSheet(0);
		int nor=s.getRows();
		int noc=s.getColumns();
		WritableWorkbook wb=Workbook.createWorkbook(f,w);
		WritableSheet ws=wb.getSheet(0);
		for(int i=0; i<nor; i++)
		{
			
		String q=s.getCell(0,i).getContents();
		driver.findElement(By.id("question_title")).sendKeys(q);
		Thread.sleep(5000);
		WebElement e=driver.findElement(By.xpath("(//*[@class='select-categories']/descendant::span[1])[3]"));
		Actions a=new Actions(driver);
		a.click(e).build().perform();
		Thread.sleep(5000);
		a.sendKeys("Education").build().perform();
		Thread.sleep(5000);
		a.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(5000);
		driver.switchTo().frame("insert_question_ifr");
		String d=s.getCell(1,i).getContents();
		driver.findElement(By.id("tinymce")).sendKeys(d);
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.findElement(By.id("question_tags")).sendKeys("google",Keys.ENTER,"facebook",Keys.TAB,Keys.ENTER);
		driver.findElement(By.id("question_tags")).sendKeys("twitter",Keys.ENTER);
		Thread.sleep(5000);		
		//Alert for captcha
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("alert('Manually select captcha within a MINUTE');");
		Thread.sleep(100000);

		driver.findElement(By.id("btn_submit_question")).click();
		Thread.sleep(5000);
		wb.close();
		w.close();
		}
	}

	@Then("^logout$")
	public void logout() throws Throwable 
	{
		driver.findElement(By.xpath("//*[@class='display_name']")).click();
		driver.findElement(By.xpath("//*[@id='header_sidebar']/preceding::*[2]")).click();
	    Thread.sleep(5000);	
	}
	    
	}