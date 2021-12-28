package starter.facebook_login.tasks.user_interface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FacebookLoginPageElements {

    public static Target LOGIN_BUTTON =
            Target.the("login button")
                    .located(By.id("loginbutton"));
    public static Target EMAIL_FIELD =
            Target.the("email field")
                    .located(By.id("email"));
    public static Target PASSWORD_FIELD =
            Target.the("password field")
                    .located(By.id("pass"));

}
