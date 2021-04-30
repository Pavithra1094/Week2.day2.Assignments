package week2.day2.assignments;
//import java.util.List;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leaftaps.com/opentaps/control/main");

		driver.manage().window().maximize();

		// Enter the username
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");

		// Enter the Password
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// Click on login button
		driver.findElement(By.className("decorativeSubmit")).click();

		// Click on the CRM/SFA link
		driver.findElement(By.linkText("CRM/SFA")).click();

		// Click on the Leads

		driver.findElement(By.linkText("Leads")).click();

		// Click on the Find Leads
		driver.findElement(By.linkText("Find Leads")).click();

		// Enter the firstname for search

		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("J1");
		Thread.sleep(2000);

		// Click on Find Leads
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);

		// Capture the leadid
		String leadid = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"))
				.getText();

		// Click on first resulting lead
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		Thread.sleep(2000);

		// 11 Verify title of the page
		String pagetitle = driver.getTitle();
		System.out.println("The Page is:" + pagetitle);

		if (pagetitle.contains("View"))
			System.out.println("The Page is View");
		else
			System.out.println("The Page is not  View Page");

		// Click on Edit

		driver.findElement(By.linkText("Edit")).click();

		// update the company name
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("Edit Test click update");

		// Click on the Update button
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		Thread.sleep(2000);

		// company 2 name in View page
		String compname2 = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		String comp2 = compname2.replaceAll("[^a-zA-Z]", "");
		System.out.println("Company Name2-" + comp2);
		Thread.sleep(2000);

		// Click on the Find Leads
		driver.findElement(By.linkText("Find Leads")).click();

		// Enter the lead id
		driver.findElement(By.name("id")).sendKeys(leadid);

		// Click on Find Leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);

		// Click on first resulting lead
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		Thread.sleep(2000);

		String companyName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		;
		String comp1 = companyName.replaceAll("[^a-zA-Z]", "");
		System.out.println("Company Name1-" + comp1);

		// Verifying the company names are same
		if (comp1.equals(comp2)) {
			System.out.println("Both the Company Name are Same");
		} else {
			System.out.println("Both the Company Name are Not Same");
		}

	}
}
