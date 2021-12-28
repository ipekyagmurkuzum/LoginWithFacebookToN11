package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import starter.facebook_login.tasks.FacebookLogin;
import starter.facebook_login.tasks.NavigateToN11;
import starter.facebook_login.tasks.user_interface.FacebookLoginPageElements;
import starter.facebook_login.tasks.user_interface.N11HomePageElements;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;


public class FacebookLoginStepDefinitions {


    Actor actor = new Actor("ipek");
    @Managed
    WebDriver webDriver;

    @Given("I launch browser and am on the main page")
    public void i_launch_browser_and_am_on_the_main_page() {
        actor.can(BrowseTheWeb.with(webDriver));
        actor.attemptsTo(NavigateToN11.theN11LoginPage());
    }

    @When("I choose to login with Facebook")
    public void i_choose_to_login_with_facebook() {
        actor.attemptsTo(
                Click.on(N11HomePageElements.FACEBOOK_LOGIN_BUTTON),
                Switch.toTheOtherWindow(),
                WaitUntil.the(FacebookLoginPageElements.LOGIN_BUTTON, isClickable()).forNoMoreThan(3).seconds());
    }


    @Then("I enter valid credentials")
    public void i_enter_valid_credentials() {
        actor.attemptsTo(FacebookLogin.loginWithFacebook("lespazalte@vusra.com","user1234"));

    }

    @And("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actor.attemptsTo(
                Ensure.that(N11HomePageElements.USERNAME_LINK).isDisplayed(),
                Ensure.that(N11HomePageElements.USERNAME_LINK).hasText("Lespazalte Lespazalte")
        );
    }
}
