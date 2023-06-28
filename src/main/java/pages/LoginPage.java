package pages;

import helper.AssertHelper;
import helper.DriverHelper;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Getter
@Setter

public class LoginPage extends BasePage {

    @FindBy (xpath = "//input[@name='email']")
    private WebElement txtEmail;

    @FindBy (xpath = "//input[@name='password']")
    private WebElement txtPassword;

    @FindBy (xpath = "//button[@type='submit']")
    private WebElement btnLogIn;

    @FindBy (xpath = "//ins[@class='iCheck-helper']")
    private WebElement chkRememberMe;

    @FindBy (xpath = "//h1[contains(text(),'Dashboard')]")
    private WebElement dashboard;

    public void navigateToLogin(String url){
        DriverHelper.getInstance().getDriver().navigate().to(url);
    }

    public void login(String email, String password){
        txtEmail.clear();
        txtEmail.sendKeys(email);
        txtPassword.clear();
        txtPassword.sendKeys(password);
    }

    public void clickLoginBtn(){
        btnLogIn.click();
    }

    public void verifyDashboard(){
        new WebDriverWait(DriverHelper.getInstance().getDriver(), 10).until(ExpectedConditions.visibilityOf(dashboard));
        AssertHelper.verifyDisplay(dashboard.isDisplayed(), "dashboard is not displayed");
    }

    public void verifyPlaceholder(){
        String actualPlaceholderEmail = txtEmail.getAttribute("placeholder ");
        String actualPlaceholderPassword = txtPassword.getAttribute("placeholder");
        AssertHelper.verifyText(actualPlaceholderEmail, "Email", "email placeholder is wrong");
        AssertHelper.verifyText(actualPlaceholderPassword, "Password", "password placeholder is wrong");
    }

    public void verifyRememberMeChk() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) DriverHelper.getInstance().getDriver();
        js.executeScript("arguments[0].click();", chkRememberMe);
        Thread.sleep(10000);
        AssertHelper.verifyDisplay(chkRememberMe.isSelected(), "remember me checkbox is not selected");
    }
}
