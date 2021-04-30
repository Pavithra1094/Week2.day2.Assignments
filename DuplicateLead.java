package week2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

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

		// Click on Email
		driver.findElement(By.xpath("//span[text()='Email']")).click();

		// Enter the Email address
		driver.findElement(By.name("emailAddress")).sendKeys("123@abc.com");

		// Click on Find Leads
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();

		String companyName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		String comp1 = companyName.replaceAll("[^a-zA-Z]", "");
		System.out.println("Company Name-" + comp1);

		// Click on Duplicate in View Page

		driver.findElement(By.linkText("Duplicate Lead")).click();

		String pagetitle = driver.getTitle();

		if (pagetitle.contains("Duplicate Lead")) {
			System.out.println("The Page is Duplicate Lead");

		} else {
			System.out.println("The Page is not  Duplicate Lead");
		}

		// Click on Create Lead
		driver.findElement(By.className("smallSubmit")).click();

		// company 2 name in View page
		String compname2 = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		String comp2 = compname2.replaceAll("[^a-zA-Z]", "");
		System.out.println("Company Name-" + comp2);

		// Verifying the company names are same
		if (comp1.equals(comp2)) {
			System.out.println("Company names are same");
		} else {
			System.out.println("Company names are not same");
		}
		
		
	}

}
