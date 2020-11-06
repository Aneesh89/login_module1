package TrainingPortal.loginModule.pageObjectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "IDToken1")
	private WebElement userName;

	@FindBy(how = How.ID, using = "IDToken2")
	private WebElement password;

	@FindBy(how = How.ID, using = "button")
	private WebElement login;

	@FindBy(how = How.ID, using = "lang_select1")
	private WebElement drpdwm_language;

	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div[3]/div[1]/div[2]/div[1]/form/table/tbody/tr[8]/td/font")
	private WebElement error_msg;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[5]/div/div[9]/div/div/div[1]")
	private WebElement error_msg2;
	
	@FindBy(how = How.ID, using = "forgotpassword_popup")
	private WebElement forgot_pwd;
	
	@FindBy(how = How.ID, using = "loginId")
	private WebElement login_id;
	
	@FindBy(how = How.ID, using = "securityanswera")
	private WebElement answer1;
	
	@FindBy(how = How.ID, using = "securityanswerb")
	private WebElement answer2;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div[1]/form/div/input[1]")
	private WebElement reset_pwd_btn;
	
	@FindBy(how = How.ID, using = "fancybox-frame")
	private WebElement ifra;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div[2]/div[2]/a[6]/img")
	private WebElement logout;
	

	public void sendUserName(String user) {
		userName.sendKeys(user);
	}

	public void sendPassword(String pwd) {
		password.sendKeys(pwd);
	} 

	public void click_Login_Button() {
		login.click();
	}

	public void select_Language() {

		Select dropdown = new Select(drpdwm_language);
		dropdown.selectByVisibleText("English");
	}

	public void error_validation(String arg) {
		String msg = error_msg.getText();
		Assert.assertEquals(msg, arg);
	}
	
	public void error_validation2(String arg) {
		String msg2 = error_msg2.getText();
		Assert.assertEquals(msg2, arg);
	}
	
	public void click_forgotPwd() {
		forgot_pwd.click();
	}
  
	public void reset_password() throws InterruptedException
	{

		login_id.sendKeys("cb1003");
		answer1.click();
		Thread.sleep(3000);
		answer1.sendKeys("Thiruvannathapuram");
		answer2.sendKeys("suzuki");
		reset_pwd_btn.click();
	}
	public void logout()
	{
		logout.click();
	}
}















