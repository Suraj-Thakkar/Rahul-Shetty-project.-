package com.stepDef;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Features", glue="com.stepDef",
                 tags = "@ErrorValidation", monochrome =true,plugin = {"html:target/Features.html"})

public class TestNgrunners extends AbstractTestNGCucumberTests {
}
