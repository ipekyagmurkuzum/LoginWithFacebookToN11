package starter.facebook_login.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import starter.facebook_login.tasks.user_interface.N11HomePage;

public class NavigateToN11 {
    public static Performable theN11LoginPage() {
        return Task.where("{0} opens the n11 login page",
                Open.browserOn().the(N11HomePage.class));
    }
}
