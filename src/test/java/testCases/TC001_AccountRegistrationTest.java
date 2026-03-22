package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	
	
	@Test(groups= {"Regression","Master"})
	public void verify_registration()
	{
		// Access logger here
		logger.info("***Starting TC001_AccountRegistrationTest***");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyaccount();
		logger.info("Clicked on MyAccount Link");
		
		hp.clickMyregister();
		logger.info("Clicked on Register Link");
		
	    AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
	    logger.info("Providing Customer Details");
		regpage.setFirstName(randomString());
		regpage.setLstName(randomString());
		regpage.setEmail(randomString()+"@gmail.com");
		regpage.setTelephone(randomNumber()); 
		
		String password=randomAlphaNumeric(); // for matching same passwords
		regpage.setPassword( password);
		regpage.setconfmPasswd( password);
		
		// String 
		regpage.setNewsLetter("yes");
		regpage.setprivacyPolicy();
		regpage.clickContiue_btn();
		
		logger.info("Validating Expected Message...");
		String act_confmsg=regpage.getConfirmationMsg();
		if(act_confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test Failed.");
			logger.debug("Debug logs...");
			Assert.assertTrue(false);
		}
		
			Assert.assertEquals(act_confmsg,"Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			
			Assert.fail();
		}
		logger.info("*** Finished TC001_AccountRegistrationTest ***");
	 }
	
	

}
