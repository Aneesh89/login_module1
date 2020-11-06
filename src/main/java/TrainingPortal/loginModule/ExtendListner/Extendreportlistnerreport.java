package TrainingPortal.loginModule.ExtendListner;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;


public class Extendreportlistnerreport  extends Extendreportlisten implements ITestListener { 
	
	
	private static ExtentReports extent;
	@Override
	public void onFinish(ITestContext context) {
		System.out.println(" Report Completed.....");
		extent.flush();
		System.out.println("Generated Report.....");
		
		
	}
 
	@Override
	public void onStart(ITestContext context) {
		System.out.println("Excecution started.....");
	extent=setUp();
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		System.out.println("skipped");
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		System.out.println("Starting");
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		System.out.println("Success");
		
	} 

	
}
