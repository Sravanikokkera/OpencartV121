package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

@Test(groups= {"Sanity"})
public class TC004_SearchProduct extends BaseClass{
	
	@Test(groups= {"sanity"})
	public void verifySearch()
	{
		logger.info("*****Starting Search Test*****");
	try {
	HomePage hp=new HomePage(driver);
	
	hp.EnterProduct("iphone");
	
	// validation1 : URL contains 'Search'
	 String url=driver.getCurrentUrl();
	 Assert.assertTrue(url.toLowerCase().contains("search"),"URL does not contain 'search'. Actual URL: " + url);
	
	 // validation2 :  page title contains search keyword product
	 
	 String title=driver.getTitle();
	 Assert.assertTrue(title.toLowerCase().contains("iphone"),"Title does not contain 'iphone'. Actual title: " + title);
	 
	 logger.info("*****Passed Search Test*****");
	} catch (Exception e)
	{
		logger.error("Test Failed " + e.getMessage());
		Assert.fail();
	}
	
	
	
	
	
	
	
	
	}

}
