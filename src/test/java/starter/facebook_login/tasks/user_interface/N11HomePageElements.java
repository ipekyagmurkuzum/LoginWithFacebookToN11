package starter.facebook_login.tasks.user_interface;

import net.serenitybdd.screenplay.actions.Switch;
import org.openqa.selenium.By;
import net.serenitybdd.screenplay.targets.Target;

public class N11HomePageElements {

    public static Target FACEBOOK_LOGIN_BUTTON = Target.the("facebook login button")
                    .located(By.xpath("//*[@id=\"loginContainer\"]/div/div[1]/div/div[3]"));
    public static Target USERNAME_LINK = Target.the("user account link")
                    .locatedBy(".menuLink.user");
}
