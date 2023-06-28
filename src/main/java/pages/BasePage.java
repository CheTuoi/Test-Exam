package pages;

import helper.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private static final int TIMEOUT = 20;
    private static final int POLLING = 100;

    public BasePage(){
        PageFactory.initElements(DriverHelper.getInstance().getDriver(), this);
    }
}
