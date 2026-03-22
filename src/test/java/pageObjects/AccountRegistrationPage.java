package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

   //step1:Constructor invoke

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		
	}
	  // Step2 : Locating the Elements in Page Object Class
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txt_FirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txt_LastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txt_Email;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txt_Telephn;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txt_Password;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txt_CnfirmPassword;
	
	@FindBy(xpath="//input[@name='newsletter' and @value='1']")
	WebElement rd_newsYes;
	
	@FindBy(xpath="//input[@name='newsletter' and @value='0']")
	WebElement rd_newsNo;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkdPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement confirmMsg;
	
	 // Step3 : Action Method to perform operations
	
	public void setFirstName(String fname )
	{
		txt_FirstName.sendKeys(fname);
	}
	
	public void setLstName(String Lname )
	{
		txt_LastName.sendKeys(Lname);
	}
	public void setEmail(String email )
	{
		txt_Email.sendKeys(email);
	}
	public void setTelephone(String telphn )
	{
		txt_Telephn.sendKeys(telphn);
	}
	public void setPassword(String pwd )
	{
		txt_Password.sendKeys(pwd);
	}
	public void setconfmPasswd(String pwd )
	{
		txt_CnfirmPassword.sendKeys(pwd);
	}
	
	public void setNewsLetter(String option )
	{
		if(option.equalsIgnoreCase("yes"))
		{
			 rd_newsYes.click();
		 }
		else
		{
			rd_newsNo.click();
		}
	}
	public void setprivacyPolicy()
	{
		chkdPolicy.click();
	}
	
	public void clickContiue_btn()     // solution1  or 
	{
		btnContinue.click();
	}
	
	//  btnContinue.submit();            // sol 2
	 
	//Actions act=new Actions(driver);                      //sol3
	//act.moveToElement(btnContinue).click().perform();
	
	public String getConfirmationMsg() {
	 try {	
		    return (confirmMsg.getText());
	      }
	 catch (Exception e) 
	     {
		    return (e.getMessage());
	      }
		
	}
	
	
	
	
	
	
	
	
	
	

}
