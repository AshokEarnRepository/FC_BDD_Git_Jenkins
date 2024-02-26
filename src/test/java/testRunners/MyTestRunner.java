package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
		
@CucumberOptions(
		
	    features = {"src/test/resources/parallel"},
	    glue = {"parallel", "AppHooks"},
//	   tags = "@all",
	    dryRun=false,
	    publish = true,
	    plugin   = {"pretty", "html:target/CucumberReport.html",
	    		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
	    		"timeline:test-output-thread/"
	    		}
	    
	)

//dryRun=true,
//dryRun=false,
public class MyTestRunner {
	
	

}
