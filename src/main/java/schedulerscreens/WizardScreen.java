package schedulerscreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class WizardScreen extends BaseScreen{
    public WizardScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

@FindBy(xpath = "//*[@resourse-id='com.example.svetlana.scheduler:id/wisard_setting_skip_container']")
    MobileElement skippButton;

    public HomeScreen skipWizart(){
        if(isDisplayedWithExp(skippButton)){
            skippButton.click();
        }
        return new HomeScreen(driver);
    }



}
