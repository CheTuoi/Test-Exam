package stepdefs;

import helper.DriverHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ServiceHooks extends DriverHelper{
    DriverHelper seleniumBase = new DriverHelper();

    @Before
    public void initializeTest(){
        seleniumBase.createDriver();
    }

    @After
    public void afterHookFunction(Scenario scenario){
        if (scenario.isFailed()){
            scenario.attach(((TakesScreenshot)DriverHelper.getInstance()).getScreenshotAs(OutputType.BYTES),
                    "image/png","image");
        }
        seleniumBase.tearDown();
    }
}
