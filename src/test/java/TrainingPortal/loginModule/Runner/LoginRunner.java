package TrainingPortal.loginModule.Runner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(features = { "./features" }, glue = { "TrainingPortal.loginModule.StepDef" }, tags = {"@fea1"})


public class LoginRunner {

	private TestNGCucumberRunner testNGCucumberRunner;
	WebDriver driver;

	@BeforeClass(alwaysRun = true)
	public void setupClass() throws Exception {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}

	@Test(dataProvider = "features")
	public void feature(CucumberFeatureWrapper cucumberFeature) {
	
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());

	}

	@DataProvider
	public Object[][] features() {
		return testNGCucumberRunner.provideFeatures();
	}

	@AfterClass(alwaysRun = true)
	public void teardownclass() throws Exception {
		testNGCucumberRunner.finish();
		

	}
	

}
