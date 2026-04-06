package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps", "hooks"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/SauceDemoCucumberFinalReport.html",
                "json:target/cucumber-reports/SauceDemoCucumberFinalReport.json"
        },
        tags = "@smoke",
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}