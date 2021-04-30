package week2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

		public static void main(String[] args) throws InterruptedException {
			// TODO Auto-generated method stub

			WebDriverManager.chromedriver().setup();

			ChromeDriver driver = new ChromeDriver();
			System.out.println("The title of the page:");

			driver.get("http://leaftaps.com/opentaps/control/login");
			driver.manage().window().maximize();
			
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys("DemoSalesManager");
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
			driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();

			driver.findElement(By.linkText("CRM/SFA")).click();
			
			driver.findElement(By.linkText("Leads")).click();
			
			//Click Find leads
			
			driver.findElement(By.linkText("Find Leads")).click();
			
			
			driver.findElement(By.xpath("//span[text()='Phone']")).click();
			//9442777552
			driver.findElement(By.name("phoneNumber")).sendKeys("9442777552");
			
			driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
			Thread.sleep(2000);

			String leadid = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"))
					.getText();
			driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Delete")).click();

			// String pagetitle = driver.getTitle();

			// Click on the Find Leads
			driver.findElement(By.linkText("Find Leads")).click();

			// Enter the lead id
			driver.findElement(By.name("id")).sendKeys(leadid);

			// Click on Find Leads button
			driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
			
			Thread.sleep(2000);

			// No Records Found - Verification
			String leadid_del = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();

			if (leadid_del.contains("No records to display"))

			{
				System.out.println("No Records Found - Verified");
			} else {
				System.out.println("Verified - Records found");
			}
		}

		

}
