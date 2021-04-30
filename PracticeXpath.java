package week2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeXpath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		// Launch the URL

		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		
		//Enter the username based on its label
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("DemoSalesManager");
		
		//Enter the password based on its label
		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		
		//Click on Login
		
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		
		// Click on CRMSFA link
		
		driver.findElement(By.xpath("//a[contains(@href,'/crmsfa')]")).click();
		
		//Click on Leads link
		
		driver.findElement(By.xpath("//a[@href='/crmsfa/control/leadsMain']")).click();
		
		
		//Click on Merge Leads 
		
		driver.findElement(By.xpath("//a[@href='/crmsfa/control/mergeLeadsForm']")).click();
		
		//Click the first img icon
		
		driver.findElement(By.xpath("//img[@src='/images/fieldlookup.gif']")).click();

		
		//Click on first result
		//driver.findElement(By.xpath("//div[@class ='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.xpath("(//div[@class ='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")).click();
		
		//Select the second resulting lead
		//driver.findElement(By.xpath("(//div[@class ='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();
		driver.findElement(By.xpath("(//div[@class ='x-grid3-cell-inner x-grid3-col-partyId'])[2]/a")).click();

		
		//Click on Merge Lead (submit) button
		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		
		
		
		//Get the company name text based on its label
		driver.findElement(By.xpath("//span[@id ='viewLead_companyName_sp']"));
	}

}
