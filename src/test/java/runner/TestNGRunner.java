package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "C:\\Users\\rajat\\eclipse-workspace\\dbankDemo\\RLL\\src\\test\\java\\feature\\SignUp.feature",
    glue = {"StepDef", "Pages"},
    plugin = {
        "pretty", "html:target/sample.html",
        "json:target/stepdefinition.json", "junit:target/stepReport.xml",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:targer/extentsampleReport.html"
    },
    monochrome = true
)
public class TestNGRunner extends AbstractTestNGCucumberTests {
    
}
