package com.cybertek;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MockarooDataValidation {

	WebDriver driver;

	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://mockaroo.com/");
	}


	@Test(priority=1)
	public void titleValidation() {
		String title = "Mockaroo - Random Data Generator and API Mocking Tool | JSON / CSV / SQL / Excel";
		Assert.assertEquals(driver.getTitle(), title);
	}

	@Test(priority=2)
	public void isMackarooDisplayed() {
		String title = "mockaroo";
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='brand']")).getText(), title);
		String title1 = "realistic data generator";
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='tagline']")).getText(), title1);
	}

	@Test(priority=3)
	public void removeByX(){
		List<WebElement> ls = driver.findElements(By.xpath("//a[@class='close remove-field remove_nested_fields']"));
		for (WebElement el : ls) {
			el.click();
		}
	}
	@Test(priority=4)
	public void isFieldsDisplayed() {
		String fieldName = "Field Name";
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='column column-header column-name']")).getText(), fieldName);
		String type = "Type";
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='column column-header column-type']")).getText(), type);
		String option = "Options";
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='column column-header column-options']")).getText(), option);
	}
	@Test(priority=5)
	public void isAddAnotherFieldEnabled() {
		Assert.assertTrue(driver.findElement(By.xpath("//a[@class='btn btn-default add-column-btn add_nested_fields']")).isEnabled());
	}
	@Test(priority=6)
	public void isRow1000() {
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='num_rows']")).getAttribute("value"),"1000");
	}
	@Test(priority=7)
	public void isDefaultCSV() {
		Assert.assertEquals(driver.findElement(By.xpath("//select[@id='schema_file_format']/option")).getText(),"CSV");
	}
	@Test(priority=8)
	public void isLineEndingUnix() {
		Assert.assertEquals(driver.findElement(By.xpath("//select[@id='schema_line_ending']/option")).getText(),"Unix (LF)");
	}
	@Test(priority=9)
	public void isChecked() {
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='schema_include_header']")).isSelected());
		Assert.assertFalse(driver.findElement(By.xpath("//input[@id='schema_bom']")).isSelected());
	}
	
	@Test(priority=10)
	public void addingCity() {
		driver.findElement(By.xpath("//div[@class='table-body']/a")).click();
		
	}

	@Test(priority=11)
	public void addingCity1() {
		driver.findElement(By.xpath("//div[@id='fields']/div[7]/div[2]/input[starts-with(@id,'schema_columns_attributes')]")).sendKeys("City");
	}
	@Test(priority=12)
	public void chooseTypeIsDisplayed() throws InterruptedException {
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='fields']/div[7]/div[3]/input[@class='btn btn-default']")).isDisplayed());
		driver.findElement(By.xpath("//div[@id='fields']/div[7]/div[3]/input[@class='btn btn-default']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='type_search_field']")).sendKeys("City");
		driver.findElement(By.xpath("//div[@class='examples']")).click();
		Thread.sleep(2000);

	}
	@Test(priority=13)
    public void addingCountry() throws InterruptedException {
		driver.findElement(By.cssSelector("a[class='btn btn-default add-column-btn add_nested_fields']")).click();
		driver.findElement(By.xpath("//div[@class='fields'][8]/div[2]/input[@class='column-name form-control']")).clear();
		driver.findElement(By.xpath("//div[@class='fields'][8]/div[2]/input[@class='column-name form-control']")).sendKeys("Country");
		driver.findElement(By.xpath("(//input[@class='btn btn-default'])[8]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='type_search_field']")).sendKeys("country");
		driver.findElement(By.xpath("(//div[@class='examples'])[1]")).click();
			
		}
	@Test(priority=14) 
	public void download() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='download']")).click();
	}
    
	
	
	
	
	
	
	

	

}
