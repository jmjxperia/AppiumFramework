package devcheck;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.DashboardPage;
import pageObject.HardwarePage;

import java.io.IOException;
import java.time.Duration;

public class Test_Dashboard extends Base{

    DashboardPage dashboard;
    HardwarePage hardware;

    @BeforeTest
    public void setUp() throws IOException {
        AppiumDriver<MobileElement> driver=start();
        dashboard=new DashboardPage(driver);
        hardware=new HardwarePage(driver);
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

    @Test
    void checkSwipeFunctionality()
    {
        Dimension size = driver.manage().window().getSize();
        int x1 = (int) (size.width * 0.02);
        int x2 = (int) (size.width * 0.80);
        int y= (int) (size.height*0.60);
        TouchAction action=new TouchAction(driver);
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(dashboard.cpuStats));
        action.press(PointOption.point(x2,y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(PointOption.point(x1,y)).release().perform();
        Assert.assertTrue(hardware.processor.isDisplayed(),"Not landed on Processor page");
        action.press(PointOption.point(x1,y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(PointOption.point(x2,y)).release().perform();
        Assert.assertTrue(dashboard.cpuStats.isDisplayed(),"Not landed on Dashboard page");


    }

    @AfterTest
    public void tearDown() {
        Base.stop();
        System.out.println("tear");
    }
}
