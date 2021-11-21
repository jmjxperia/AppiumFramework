package devcheck;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.DashboardPage;

import java.io.IOException;

public class Test_Dashboard extends Base{

    DashboardPage dashboard;

    @BeforeTest
    public void setUp() throws IOException {
        AppiumDriver<MobileElement> driver=start();
        dashboard=new DashboardPage(driver);
    }

    @Test
    void verifySubMenus(){
        Assert.assertTrue(dashboard.battery.isDisplayed(),"Battery not present");
        Assert.assertTrue(dashboard.cpuStats.isDisplayed(),"CPU Status not present");
        Assert.assertTrue(dashboard.monitors.isDisplayed(),"Monitors not present");
        Assert.assertTrue(dashboard.benchmarks.isDisplayed(),"Benchmarks not present");
        Assert.assertTrue(dashboard.network.isDisplayed(),"Network not present");
        Assert.assertTrue(dashboard.ram.isDisplayed(),"RAM not present");
        Assert.assertTrue(dashboard.temperatures.isDisplayed(),"Temperatures not present");
        Assert.assertTrue(dashboard.tools.isDisplayed(),"Tools not present");
        Assert.assertTrue(dashboard.model.isDisplayed(),"Model not present");
    }
}
