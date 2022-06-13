package com.functions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.util.TestBase;

public class Sweety_FunctionLibrary extends TestBase
{
	public boolean userLogin(String uname, String password)
	{
		driver.findElement(By.id("user_email")).sendKeys(uname);
		driver.findElement(By.id("user_password")).sendKeys(password);
		driver.findElement(By.name("commit")).click();
		if(driver.findElement(By.xpath("//div[@class='alert alert-info fade in']")).getText().equals("Signed in successfully."))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean enterUserData(String data)
	{
		driver.findElement(By.xpath("//a[normalize-space()='Levels']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='btn btn-primary']")));
		driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
		driver.findElement(By.id("entry_level")).sendKeys(data);
		driver.findElement(By.name("commit")).click();
		if(driver.findElement(By.xpath("//div[@class='alert alert-info fade in']")).getText().equals("Entry was successfully created."))
		{
			driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public boolean userReport()
	{
		driver.findElement(By.xpath("//a[@href='/report']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Monthly']")).click();
		if(driver.findElement(By.xpath("//div[@class='panel-heading']")).isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
		
}
