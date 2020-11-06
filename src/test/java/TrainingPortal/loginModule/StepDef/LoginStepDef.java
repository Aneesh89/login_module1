package TrainingPortal.loginModule.StepDef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Background;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.aventstack.extentreports.gherkin.model.ScenarioOutline;

import TrainingPortal.loginModule.ExtendListner.Extendreportlisten;
import TrainingPortal.loginModule.managers.PageObjectManager;
import TrainingPortal.loginModule.managers.Webdrivermanager;
import TrainingPortal.loginModule.pageObjectClass.HomePage;
import TrainingPortal.loginModule.pageObjectClass.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LoginStepDef extends Extendreportlisten {

	
	WebDriver driver;
	Webdrivermanager webDriverManager;
	PageObjectManager pageObjectManager;
	HomePage homePage;
	LoginPage loginPage;

	
	@Given("^User is on the Home Page$")
	public void user_is_on_the_Home_Page() throws Throwable {
		ExtentTest logInfo = null;
		try {
			test = extent.createTest(Feature.class, "Login Functionality Testing");
			test = test.createNode(Background.class, "User Navigate to Home Page");
			logInfo = test.createNode(new GherkinKeyword("Given"), "User is on the Home Page");

			webDriverManager = new Webdrivermanager();
			driver = webDriverManager.getDriver();

			pageObjectManager = new PageObjectManager(driver);
			homePage = pageObjectManager.getHomePage();
			homePage.navigateTo_HomePage();

			logInfo.pass("Home Page Navigation Done Successfully");
//			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
		
			testStep("FAIL", driver, logInfo, e);
		}
	}

	
	@Given("^Enter username \"([^\"]*)\" and Password\"([^\"]*)\"$")
	public void enter_username_and_Password(String arg1, String arg2) throws Throwable {

		
		ExtentTest logInfo = null;
		try {
			test = extent.createTest(Scenario.class, "validate the Positive login functionality(SHO,EO,IO,EO)- Username:" +arg1);
			test = test.createNode(Scenario.class, "validate the Positive login functionality(SHO,EO,IO,EO)");
			logInfo = test.createNode(new GherkinKeyword("Given"),"Enter username  and Password"); 
			loginPage = pageObjectManager.getLoginPage();
			loginPage.sendUserName(arg1);
			loginPage.sendPassword(arg2);	
			Thread.sleep(3000);
			
			logInfo.pass("Data entered successfully");
//			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
		
			testStep("FAIL", driver, logInfo, e);
		}
	    
	}

	@Given("^Enter Invalid Username \"([^\"]*)\" and Password\"([^\"]*)\"$")
	public void enter_Invalid_Username_and_Password(String arg1, String arg2) throws Throwable {
		
		ExtentTest logInfo = null;
		try {
			test = extent.createTest(Scenario.class, "validate the negative login functionality- Username:" +arg1);
			test = test.createNode(ScenarioOutline.class, "validate the negative login functionality");
			logInfo = test.createNode(new GherkinKeyword("Given"),
					"^Enter username \"([^\"]*)\" and \"([^\"]*)\"$");

			loginPage = pageObjectManager.getLoginPage();
			loginPage.sendUserName(arg1);
			loginPage.sendPassword(arg2);	
			Thread.sleep(3000);
			logInfo.pass("Successfully send incorrect username and paswsword");
//			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			
			testStep("FAIL", driver, logInfo, e);
		}
	    
	}
	
	
	

	@Then("^Validate the error message \"([^\"]*)\"$")
	public void validate_the_error_message(String arg1) throws Throwable {
		
		ExtentTest logInfo = null;
		try {
			logInfo = test.createNode(new GherkinKeyword("Then"),
					"Validate the error message");

			loginPage = pageObjectManager.getLoginPage();
			loginPage.error_validation(arg1);
	
			Thread.sleep(3000);
			logInfo.pass("Validation done successfully");
//			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			
			testStep("FAIL", driver, logInfo, e);
		}
	  
	}
	
	@Then("^Validate the error message \"([^\"]*)\" without data$")
	public void validate_the_error_message_without_data(String arg1) throws Throwable {
	    
		
		ExtentTest logInfo = null;
		try {
			test = extent.createTest(Scenario.class, "validate the negative login functionality without data ");
			test = test.createNode(Scenario.class, "validate the negative login functionality without data");
			logInfo = test.createNode(new GherkinKeyword("Then"),
					"Validate the error message");

			loginPage = pageObjectManager.getLoginPage();
			loginPage.error_validation2(arg1);
	
			Thread.sleep(3000);
			logInfo.pass("Validation done successfully");
//			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			
			testStep("FAIL", driver, logInfo, e);
		}
	}

	
	@Then("^Click on sign in button$")
	public void click_on_sign_in_button() throws Throwable {
		ExtentTest logInfo = null;
		try {
			logInfo = test.createNode(new GherkinKeyword("Then"),
					"Click on sign in button");

			loginPage = pageObjectManager.getLoginPage();
			loginPage.click_Login_Button();
			logInfo.pass("Pass the case");
//			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			
			testStep("FAIL", driver, logInfo, e);
		}
	}
	
	@Then("^Click on Forgot Password$")
	public void click_on_Forgot_Password() throws Throwable {
		ExtentTest logInfo = null;
		try {
			test = extent.createTest(Scenario.class, "To verify the Forget Password is working ");
			test = test.createNode(Scenario.class, "To verify the Forget Password is working ");
			logInfo = test.createNode(new GherkinKeyword("Then"),
					"Click on Forgot Password");

			loginPage = pageObjectManager.getLoginPage();
			loginPage.click_forgotPwd();
			
			logInfo.pass("click the forgot password link successfully");
//			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			
			testStep("FAIL", driver, logInfo, e);
		}
	}

	@Then("^User enters UserName and security Q&A details$")
	public void user_enters_UserName_and_security_Q_A_details() throws Throwable {
		ExtentTest logInfo = null;
		try {
			logInfo = test.createNode(new GherkinKeyword("Then"),
					"User enters UserName and security Q&A details");

			loginPage = pageObjectManager.getLoginPage();
			driver.switchTo().frame(driver.findElement(By.id("fancybox-frame")));
			loginPage.reset_password();
			
			logInfo.pass("enter all details successfully");
//			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			
			testStep("FAIL", driver, logInfo, e);
		}
	}
	
	@Then("^Logout From Home Page$")
	public void logout_From_Home_Page() throws Throwable {
		ExtentTest logInfo = null;
		try {
			logInfo = test.createNode(new GherkinKeyword("Then"),
					"Logout From Home Page");

			loginPage = pageObjectManager.getLoginPage();
			loginPage.logout();
			
			logInfo.pass("Logout successfully");
//			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			
			testStep("FAIL", driver, logInfo, e);
		}
	}
}










