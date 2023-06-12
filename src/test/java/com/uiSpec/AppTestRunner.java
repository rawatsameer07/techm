package com.uiSpec;



import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/com/uiSpec/UISpec.feature",
		glue = "com.uiSpec",
		tags = "@smoke",
				plugin = {
				        "pretty", // Prints the output of the scenarios in a readable format
				        "html:target/cucumber-reports/report.html", // Generates HTML reports in the specified directory
				        "json:target/cucumber-reports/report.json" // Generates JSON report in the specified file
				    }	)
public class AppTestRunner {
}
