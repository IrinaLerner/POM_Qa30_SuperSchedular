package schedular;

import config.ConfigurationSchedular;
import config.ListenerTestNG;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import schedulerscreens.LoginScreen;
import schedulerscreens.SplashScreen;
@Listeners(ListenerTestNG.class)
public class LoginTest extends ConfigurationSchedular {
    @Test
    public void loginSuccessTest(){
        boolean isFabPresent = new SplashScreen(driver)
                .checkVersion("0.0.3")
                .fillEmail("noa@gmail.com")
                .fillPassword("Nnoa12345$")
                .clickLoginBtn()
                .skipWizart()
                .isFabAddPresent();
        Assert.assertTrue(isFabPresent);
    }
    @Test
    public void loginStartLoginScreenO(){
        new LoginScreen(driver)
                .fillEmail("")
                .fillPassword("")
                .clickLoginBtn()
                .

    }

}
