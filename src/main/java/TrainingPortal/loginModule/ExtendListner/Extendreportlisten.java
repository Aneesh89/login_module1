package TrainingPortal.loginModule.ExtendListner;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extendreportlisten {

	public static ExtentHtmlReporter report = null;
	public static ExtentReports extent = null;
	public static ExtentTest test = null;
	
	public static ExtentReports setUp() {
		String reportLocation ="./Reports/Extent_Report.html";
		report = new ExtentHtmlReporter(reportLocation);
		report.config().setDocumentTitle("Automation Test Report");
		report.config().setReportName("User Management Module - Testing");
		report.config().setTheme(Theme.STANDARD);
		System.out.println("Extent Report Location initialized ");
		report.start();
		
		extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Application", "CCTNS");
		extent.setSystemInfo("Operating System",System.getProperty("os.name"));
		extent.setSystemInfo("Username",System.getProperty("user.name"));
		System.out.println("System Info.set in Extent report");
		return extent;
	}
       public static void testStep(String teststatus,WebDriver driver,ExtentTest extenttest,Throwable throwable) {
       
       switch (teststatus) {
       case "FAIL":
    	   extenttest.fail(MarkupHelper.createLabel("Test Case is failed: ",ExtentColor.RED));
    	   extenttest.error(throwable.fillInStackTrace());
    	   
    	   try {
    		   extenttest.addScreenCaptureFromPath(captureScreenShot(driver));
    	   }catch (IOException e) {
    		   e.printStackTrace();
    	   }
    	   if(driver!=null) {
    		   driver.quit();
    	   }
    	   break;
    	   case "PASS":
    		   extenttest.pass(MarkupHelper.createLabel("Test Case is passed:", ExtentColor.GREEN));
    		   break;
       
       default:
		   break;
       } 
       }
       public static String captureScreenShot(WebDriver driver) throws IOException{
    	       TakesScreenshot screen=(TakesScreenshot) driver; 
    	       File src=screen.getScreenshotAs(OutputType.FILE);
    	       String dest ="E:\\My_WorkSpace2\\loginModule\\screenshots\\"+getcurrentdateandtime()+".png";
    	    		   File target=new File(dest);
    	       FileUtils.copyFile(src,target);
    	       return dest;
       }
       private static String getcurrentdateandtime() {
    	   String str=null;
    	   try {
    		   DateFormat dateFormat= new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
    		   Date date=new Date();
    		   str=dateFormat.format(date);
    		   str=str.replace(" ", "").replaceAll("/", "").replaceAll(":", "");
    	   }catch (Exception e) {
    	   }
    	   return str;
       }

}
