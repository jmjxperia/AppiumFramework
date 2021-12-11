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

    @AndroidFindBy(id = "dashboard_battery")
    public MobileElement battery;

    @AndroidFindBy(id="dashboard_network")
    public MobileElement network;

    @AndroidFindBy(id="dashboard_memory")
    public MobileElement ram;

    @AndroidFindBy(id="dashboard_storage")
    public MobileElement storage;

    @AndroidFindBy(id="dashboard_cpufreqs")
    public MobileElement cpuStats;

    @AndroidFindBy(id = "dashboard_temp_card")
    public MobileElement temperatures;

    @AndroidFindBy(id="monitor_layout")
    public MobileElement monitors;

    @AndroidFindBy(id="benchmark_layout")
    public MobileElement benchmarks;

    @AndroidFindBy(id="tools_layout")
    public MobileElement tools;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(resourceIdMatches(\"flar2.devcheck:id/model\"))")
    public MobileElement model;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='CANCEL']")
    public MobileElement cancel;

    @AndroidFindBy(id = "info_title")
    public MobileElement title;
}
