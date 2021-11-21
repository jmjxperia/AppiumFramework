package pageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    public DashboardPage(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Battery']")
    public MobileElement battery;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Network']")
    public MobileElement network;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='RAM']")
    public MobileElement ram;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Storage']")
    public MobileElement storage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='CPU Status']")
    public MobileElement cpuStats;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Temperatures']")
    public MobileElement temperatures;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Monitors']")
    public MobileElement monitors;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Benchmarks']")
    public MobileElement benchmarks;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Tools']")
    public MobileElement tools;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(resourceIdMatches(\"flar2.devcheck:id/model\"))")
    public MobileElement model;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='CANCEL']")
    public MobileElement cancel;

    @AndroidFindBy(id = "flar2.devcheck:id/info_title")
    public MobileElement title;
}
