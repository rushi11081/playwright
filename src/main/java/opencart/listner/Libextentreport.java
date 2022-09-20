package opencart.listner;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Libextentreport {

	public static ExtentReports extent;
	  
	  public static ExtentReports getreport()
	  {
		  
		  String path=System.getProperty("user.dir")+"//myreport//index.html";
		  
		  ExtentSparkReporter spark=new ExtentSparkReporter(path);
		 
		  spark.config().setReportName("UI TESTING");
		  
		  spark.config().setDocumentTitle("Extent reort of OPENCART APP");
		  
		  extent=new ExtentReports();
		  
		  extent.attachReporter(spark);
		  extent.setSystemInfo("UI", "OPENCART");
		  return extent;
		  
	  
		  
		
		  
	  }
	
}
