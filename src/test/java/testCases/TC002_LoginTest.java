package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;


public class TC002_LoginTest extends BaseClass{
	@Test(groups= {"Sanity","Master"})
	public void verify_Login()
	{
		try
		{
		logger.info("***Starting TC002_LoginTest  .... ***");
		// Home Page
		HomePage hp = new HomePage(driver);
		hp.clickMyaccount();
		hp.clickLogin();
		
		//Login Page
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		 
		// MyAccount
		MyAccountPage myAcPage=new MyAccountPage(driver);
		boolean targetPage=myAcPage.isMyAccountHeaderExists();
		
	//	Assert.assertEquals(targetPage, true, "Login Failed");
		Assert.assertTrue(targetPage);
		
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("***  Finished TC002_LoginTest .... ***");
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
