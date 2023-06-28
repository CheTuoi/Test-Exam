package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class MyStepDefs {
    LoginPage loginPage = new LoginPage();

    @When("Go to website")
    public void goToWebsite(){
        loginPage.navigateToLogin("https://phptravels.net/admin");
    }

    @And("Enter username and password")
    public void enterUsernameAndPass(){
        loginPage.login("admin@phptravels.com","demoadmin");
    }

    @And("Click login button")
    public void clickLoginButton(){
        loginPage.clickLoginBtn();
    }

    @Then("Verify dashboard")
    public void verifyDashboard(){
        loginPage.verifyDashboard();
    }

    @Then("Verify placeholder")
    public void verifyPlaceholder(){
        loginPage.verifyPlaceholder();
    }

    @Then("Verify Remember checkbox is selected")
    public void verifyRememberMeChk() throws InterruptedException {
        loginPage.verifyRememberMeChk();
    }
}
