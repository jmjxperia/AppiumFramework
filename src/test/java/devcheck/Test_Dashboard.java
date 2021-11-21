package devcheck;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
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
    void verifySubMenusPresent(){
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

    @Test
    void verifySubmenusAreMatched()
    {
        dashboard.battery.click();
        Assert.assertEquals(dashboard.title.getText(),"Battery","Battery menu doesnt match");
        dashboard.cancel.click();
        dashboard.network.click();
        Assert.assertEquals(dashboard.title.getText(),"Network","Network menu doesnt match");
        dashboard.cancel.click();
        dashboard.ram.click();
        Assert.assertEquals(dashboard.title.getText(),"Memory","Memory setting doesnt match");
        dashboard.cancel.click();
        dashboard.storage.click();
        Assert.assertEquals(dashboard.title.getText(),"Storage","Storage setting doesnt match");
        dashboard.cancel.click();
    }

    @AfterTest
    public void tearDown() {
        Base.stop();
        System.out.println("tear");
    }
}
