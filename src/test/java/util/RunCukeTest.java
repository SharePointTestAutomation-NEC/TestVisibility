package util;

import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.junit.Cucumber;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterTest;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertTrue;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = {"step_definitions"},
        plugin  = {"pretty", "html:target/cucumber", "json:target/cucumber.json", "json:target/surefire-reports/cucumber.json"}
)

public class RunCukeTest {




}




