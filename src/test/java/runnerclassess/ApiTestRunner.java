package runnerclassess;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/apitesting/api_test.feature"},
        glue = {"stepdefinitions"},
        plugin = {"pretty", "json:build/reports/cucumber/report.json", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"})
public class ApiTestRunner {
}