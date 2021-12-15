package schedular;

import config.ConfigurationScheduler;
import config.DataProviderMy;
import config.ListenerTestNG;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import schedulerscreens.LoginScreen;
import schedulerscreens.SplashScreen;


//@Listeners(ListenerTestNG.class)
public class LoginTest extends ConfigurationScheduler {

    @Test
    public void loginSuccessTest(){

        boolean isFabPresent = new SplashScreen(driver)
                .checkVersion("0.0.3")
                .fillEmail("noa@gmail.com")
                .fillPassword("Nnoa12345$")
                .clickLoginBtn()
                .skipWizard()
                .isFabAddPresent();
        Assert.assertTrue(isFabPresent);


    }

    @Test(dataProvider = "loginData",dataProviderClass = DataProviderMy.class)
    public void loginStartLoginScreen(Auth auth){


        boolean isFabPresent = new LoginScreen(driver)
                //.fillEmail("your2@gmail.com")
                //  .fillPassword("Yy123456$")
                .fillEmail(auth.getEmail())
                .fillPassword(auth.getPassword())
                .clickLoginBtn()
                .skipWizard()
                .isFabAddPresent();
        Assert.assertTrue(isFabPresent);
    }
    @Test(dataProvider = "loginDataCSV",dataProviderClass = DataProviderMy.class)
    public void loginStartLoginScreenCSV(Auth auth){

        boolean isBTN =  new LoginScreen(driver)
                .loginComplex(auth)
                .skipWizard()
                .isFabAddPresentAssert()
                .openMenu()
                .logOut()
                .isLoginButtonPresent();

        Assert.assertTrue(isBTN);

    }

    @Test
    public void loginAuthTest(){
        boolean isFabPresent=
                new LoginScreen(driver)
                        .loginComplex(Auth.builder().email("your2@gmail.com").password("Yy123456$").build())
                        .skipWizard()
                        .isFabAddPresent();
        Assert.assertTrue(isFabPresent);

    }
    @Test(dataProvider = "loginData",dataProviderClass = DataProviderMy.class)
    public void loginAuthTestDP(Auth auth){

        boolean isBTN =  new LoginScreen(driver)
                .loginComplex(auth)
                .skipWizard()
                .isFabAddPresentAssert()
                .openMenu()
                .logOut()
                .isLoginButtonPresent();

        Assert.assertTrue(isBTN);

    }

    @Test
    public void loginComplexCheckErrorMessage(){
        boolean isLoginButtonPresent=
                new LoginScreen(driver)
                        .loginComplexWithErrorMessage(Auth.builder().email("your2@gmail.com").password("Yy123456").build())
                        .checkErrorMessage("Wrong email or password")
                        .confirmErrorMessage()
                        .isLoginButtonPresent();

        Assert.assertTrue(isLoginButtonPresent);

    }
}