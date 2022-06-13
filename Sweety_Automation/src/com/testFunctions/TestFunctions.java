package com.testFunctions;
import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.functions.Sweety_FunctionLibrary;
import com.util.TestBase;
import com.util.Xl_Utility;

public class TestFunctions extends TestBase
{
	public String datafile = "D:\\Classes\\Testing\\Project\\@MyCodes\\Sweety_Automation\\TestData\\sweet_DATA.xlsx";
	
	@Test(priority=0)
	public void testUserLogin() throws IOException
	{
		
		String datasheet = "LOGIN_DATA";
		int rowcount = Xl_Utility.getRowCount(datafile, datasheet);
		Sweety_FunctionLibrary sfunctions = new Sweety_FunctionLibrary();
		sfunctions = new Sweety_FunctionLibrary();
		String userName = Xl_Utility.getStringCellData(datafile, datasheet, rowcount, 0);
		String passWord = Xl_Utility.getStringCellData(datafile, datasheet, rowcount, 1);
		boolean result = sfunctions.userLogin(userName, passWord);
		Assert.assertTrue(result);
		Reporter.log("User Logged in Successfully");
	
	}
	
	@Test(priority=1)
	public void testEnterUserData() throws IOException
	{
		
		String datasheet = "DATA_SHEET";
		int rowCount = Xl_Utility.getRowCount(datafile, datasheet);
		Sweety_FunctionLibrary sfunctions = new Sweety_FunctionLibrary();
		sfunctions = new Sweety_FunctionLibrary();
		
		for(int i=1; i<=rowCount; i++)
		{
			String userdata = Xl_Utility.getCellData(datafile, datasheet, i, 0);
			boolean result = sfunctions.enterUserData(userdata);
			Assert.assertTrue(result);
			Reporter.log("User Entered Data Successfully");
		}
		
	}
	
	@Test(priority=2)
	public void testUserReport()
	{
		Sweety_FunctionLibrary sfunctions = new Sweety_FunctionLibrary();
		boolean report = sfunctions.userReport();
		Assert.assertTrue(report);
		Reporter.log("User able to see Report");
	}

}


















