package week2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) {
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

		// Click on the Contacts tab
		driver.findElement(By.linkText("Contacts")).click();

		// Click on the Create Contact
		driver.findElement(By.linkText("Create Contact")).click();

		// Enter the FirstName
		driver.findElement(By.xpath("//input[@id='firstNameField']")).sendKeys("TestFname");

		// Enter the LastName
		driver.findElement(By.xpath("//input[@id='lastNameField']")).sendKeys("TestLname");

		// Enter the FirstName Local
		driver.findElement(By.xpath("//input[@name='firstNameLocal']")).sendKeys("TestFname");

		// Enter the LastName Local
		driver.findElement(By.xpath("//input[@name='lastNameLocal']")).sendKeys("TestName");

		// Enter the Department
		driver.findElement(By.xpath("//input[@name='departmentName']")).sendKeys("TestDept");

		// Enter the Description
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("Descriptoin");

		// Enter the Important Note
		driver.findElement(By.xpath("//textarea[@name='importantNote']")).sendKeys("Important note");

		// Enter the Email
		driver.findElement(By.xpath("//input[@name='primaryEmail']")).sendKeys("test@gmail.com");

		// Enter State
		WebElement state = driver.findElement(By.xpath("//select[@name='generalStateProvinceGeoId']"));
		Select state1 = new Select(state);
		state1.selectByVisibleText("New York");

		// Click on Create Contact
		driver.findElement(By.xpath("//input[@value='Create Contact']")).click();

		// Click on EDIT in View Page

		driver.findElement(By.linkText("Edit")).click();

		// update the Description
		driver.findElement(By.xpath("//textarea[@id='updateContactForm_description']")).clear();

		// update the Important Note)
		driver.findElement(By.xpath("//textarea[@id='updateContactForm_importantNote']")).clear();

		// update the Important Note)
		driver.findElement(By.xpath("//textarea[@id='updateContactForm_importantNote']"))
				.sendKeys("updatedtestdescription");

		driver.findElement(By.xpath("//input[@value='Update']")).click();

		String title = driver.getTitle();

		System.out.println(title);


	}

}
