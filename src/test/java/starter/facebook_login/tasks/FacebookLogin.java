package starter.facebook_login.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.actions.Switch;
import net.thucydides.core.annotations.Step;
import starter.facebook_login.tasks.user_interface.FacebookLoginPageElements;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FacebookLogin implements Task {
    private final String email_text;
    private final String password_text;

    @Step("{0} Login with email '#email_text' and password '#password_text'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(FacebookLoginPageElements.EMAIL_FIELD),
                SendKeys.of(this.email_text).into(FacebookLoginPageElements.EMAIL_FIELD),
                Click.on(FacebookLoginPageElements.PASSWORD_FIELD),
                SendKeys.of(this.password_text).into(FacebookLoginPageElements.PASSWORD_FIELD),
                Click.on(FacebookLoginPageElements.LOGIN_BUTTON),
                Switch.toTheOtherWindow()
                );

    }

    public FacebookLogin(String email_text, String password_text){
        this.email_text = email_text;
        this.password_text = password_text;

    }



    public static FacebookLogin loginWithFacebook(String email_text, String password_text) {
        return instrumented(FacebookLogin.class
                ,email_text,password_text);
    }

}

