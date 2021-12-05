package schedular;

import config.ConfigurationSchedular;
import org.testng.Assert;
import org.testng.annotations.Test;
import schedulerscreens.SplashScreen;

public class LaunchAppTest extends ConfigurationSchedular {

    @Test
    public void launchTest(){
        String version = new SplashScreen(driver).getCurrencyVersion();
        Assert.assertEquals(version,"0.0.3");
    }


}
