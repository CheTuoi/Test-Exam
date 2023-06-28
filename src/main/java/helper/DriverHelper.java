package helper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverHelper {

    private static DriverHelper instance;
    private ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    public static synchronized DriverHelper getInstance(){
        if (instance == null){
            instance = new DriverHelper();
        }
        return instance;
    }

    public void setDriver(WebDriver webDriver){
        drivers.set(webDriver);
    }

    public WebDriver getDriver(){
        return drivers.get();
    }

    public void createDriver(){
        WebDriver driver = null;
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        DriverHelper.getInstance().setDriver(driver);
    }

    public void tearDown() {

        if (null != DriverHelper.getInstance().getDriver()) {
            DriverHelper.getInstance().getDriver().quit();
            AssertHelper.assertAll();
        }
    }
}
