package stepdefinition;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class InterviewhuntLogin 
{
	WebDriver driver; 
	
	
	@And("^Open chrome browseer and enter url stage\\.interviewhunt\\.com$")
	public void open_chrome_browseer_and_enter_url_stage_interviewhunt_com() throws Throwable 
	{
	   System.setProperty("webdriver.chrome.driver", "F:\\selenium228\\seleniumBrowserdrivers\\chromedriver.exe"); 
	   driver=new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.get("http://stage.interviewhut.com/");
	   Thread.sleep(10000);
	   
	         
	}

	@Given("^Click for register to signup for new user$")
	public void click_for_register_to_signup_for_new_user() throws Throwable 
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
		//JavascriptExecutor js= (JavascriptExecutor) driver;
		//js.executeScript("alert('manually select captcha');");
		Thread.sleep(50000);
		
		//DISABLE AN ELEMENT
		
		WebElement e=driver.findElement(By.name("undefined"));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].disabled=true",e);
		
		//driver.switchTo().frame("undefined");
		//driver.findElement(By.xpath("//*[@class='recaptcha-checkbox-checkmark']")).click();
		//Thread.sleep(10000);
		//driver.switchTo().defaultContent();
		//-----code for captcha-------
		driver.findElement(By.name("submit")).click();
		Thread.sleep(5000);
		
	}

	/*@When("^I complete login set new profile image$")
	public void i_complete_login_set_new_profile_image() throws Throwable 
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

	@Then("^Enter your details in profile and save$")
	public void enter_your_details_in_profile_and_save() throws Throwable 
	{
        driver.findElement(By.name("user_location")).sendKeys("sekarreddy");
        driver.findElement(By.name("user_facebook")).sendKeys("sekarReddy");
        driver.findElement(By.name("user_twitter")).sendKeys("sekar@sekarcReddy");
        driver.findElement(By.name("user_email")).sendKeys("sekarcreddy@gmail.com");
        driver.findElement(By.name("description")).sendKeys("hi i am graduate engineer in ece domain");
        driver.findElement(By.name("submit")).click();
        Thread.sleep(5000);
        //selecting a question with answer
        driver.findElement(By.linkText("How to become a billionaire in the next 5 years?")).click();
        Thread.sleep(5000);
        //vote up to a question
        driver.findElement(By.xpath("//*[@id='question_content']/descendant::a[1]")).click();
        Thread.sleep(5000);
        //comment for the question
        driver.findElement(By.xpath("(//*[@class='show-comments'])[1]")).click();
        Thread.sleep(5000);
        driver.switchTo().frame("insert_answer_78_ifr");
        driver.findElement(By.id("tinymce")).sendKeys("nice");
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//*[@id='submit_reply'])[1]")).click();
        Thread.sleep(5000);        
        //ANSWER A QUESTION
        driver.findElement(By.xpath("//*[text()='What is router?']")).click();
        driver.switchTo().frame("post_content_ifr");
        driver.findElement(By.id("tinymce")).click();
        
        File f=new File("F:\\answer.xls");
        Workbook w=Workbook.getWorkbook(f);
        Sheet s=w.getSheet(0);
        int nor=s.getRows();
        int noc=s.getColumns();
        
        WritableWorkbook wb=Workbook.createWorkbook(f,w);
        WritableSheet ws=wb.getSheet(0);
        for(int i=0; i<nor; i++)
        {
            String a=s.getCell(0, i).getContents();
            Thread.sleep(5000);
            driver.findElement(By.xpath("(//*[@id='submit_reply'])[2]")).click();	
        }
		
	}

	@Then("^Log out$")
	public void log_out() throws Throwable 
	{
		driver.findElement(By.xpath("//*[@class='display_name']")).click();
		driver.findElement(By.xpath("//*[@id='header_sidebar']/preceding::*[2]")).click();
	    Thread.sleep(5000);
	    
	    //MARK ANSWER AS BEST
        driver.findElement(By.xpath("((//*[text()='what is data'])[2]")).click();
	    driver.findElement(By.id("//*[@id='answers_main_list']/descendant::a[3]")).click();
	   
	}
	
	*/
	//ANSWER A QUESTION
    //driver.findElement(By.xpath("//*[text()='What is router?']")).click();
    //Thread.sleep(5000);
 //logout
    
     //driver.findElement(By.xpath("//*[@class='display_name']")).click();
	 //driver.findElement(By.xpath("//*[@id='header_sidebar']/preceding::*[2]")).click();
    // Thread.sleep(5000);
   
  /*  driver.switchTo().frame("post_content_ifr");
    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    Thread.sleep(5000);
    
    File f=new File("F:\\answer.xls");
    Workbook w=Workbook.getWorkbook(f);
    Sheet s=w.getSheet(0);
    int nor=s.getRows();
    int noc=s.getColumns();
    
    WritableWorkbook wb=Workbook.createWorkbook(f,w);
    WritableSheet ws=wb.getSheet(0);
    Thread.sleep(5000);
    for(int i=1; i<nor; i++)
    {
        String a=s.getCell(0, i).getContents();
        driver.findElement(By.id("tinymce")).sendKeys(a);
        Thread.sleep(5000);
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("(//*[@id='submit_reply'])[2]")).click();	
    }
    wb.write();
    wb.close();
    w.close();
    
	//selecting a question with answer
    driver.findElement(By.xpath("(//*[text()='How to become a billionaire in the next 5 years?'])[9]")).click();
    Thread.sleep(5000);
    //vote up to a question
    driver.findElement(By.xpath("//*[@id='question_content']/descendant::a[1]")).click();
    Thread.sleep(5000);
    //comment for the question
    driver.findElement(By.xpath("(//*[@class='show-comments'])[1]")).click();
    Thread.sleep(5000);
    driver.switchTo().frame("insert_answer_78_ifr");
    driver.findElement(By.id("tinymce")).sendKeys("nice");
    Thread.sleep(5000);
    driver.switchTo().defaultContent();
    driver.findElement(By.xpath("(//*[@id='submit_reply'])[1]")).click();
    Thread.sleep(5000);*/
    
}
	
/*	
	
	
}

@When("^check answer for the question$")
public void check_answer_for_the_question() throws Throwable 
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
		
		String qus=s.getCell(0,i).getContents();
	//getting data from excel for question
	driver.findElement(By.id("question_title")).sendKeys(qus);
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
	//getting data from excel for comment
	String des=s.getCell(1,i).getContents();
	driver.findElement(By.id("tinymce")).sendKeys(des);
	Thread.sleep(5000);
	driver.switchTo().defaultContent();
	String tag=s.getCell(2,i).getContents();
	driver.findElement(By.id("question_tags")).sendKeys(tag);
	Thread.sleep(5000);
	JavascriptExecutor js= (JavascriptExecutor) driver;
	js.executeScript("alert('manually select captcha');");
	Thread.sleep(90000);
	//-------code for captcha-------
	driver.findElement(By.id("btn_submit_question")).click();
	Thread.sleep(5000);
	wb.write();
	wb.close();
	w.close();
	
	
	}
}
*/
