package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

 
public class TC003_LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="Datadriven")// getting dataprovider from different class
	public void verify_ligiDDT(String email, String pwd, String exp) throws InterruptedException
	{
		
		logger.info("***Starting TC003_LoginDDT...***");
		try
		{
		// Home Page
		HomePage hp = new HomePage(driver);
		hp.clickMyaccount();
		hp.clickLogin();
		
		//Login Page
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
		 
		// MyAccount
		MyAccountPage myAcPage=new MyAccountPage(driver);
		boolean targetPage=myAcPage.isMyAccountHeaderExists();
		
		/*  
		 * Data is valid -- login success-- Test pass--logout
		                 -- login fail---Test fail
		 * Data is invalid --login pass --Test fail--logout
		                  --login failed--Test Pass
		 */
		if(exp.equalsIgnoreCase("Valid"))
		{
		    if(targetPage==true)
		    {
		        myAcPage.clickLogout();
		        Assert.assertTrue(true);
		    }
		    else
		    {
		        Assert.assertTrue(false);
		    }
		}
		else if(exp.equalsIgnoreCase("Invalid"))
		{
		    if(targetPage==true)
		    {
		        myAcPage.clickLogout();
		        Assert.assertTrue(false);
		    }
		    else
		    {
		        Assert.assertTrue(true);
		    }
		}
	    }catch(Exception e)
		{
	    	logger.error("Test Failed: " + e.getMessage());
			Assert.fail();
		}
		Thread.sleep(3000);
		logger.info("***Finished TC003_LoginDDT...***");
		
	 }
	
}
