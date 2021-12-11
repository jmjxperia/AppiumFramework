package devcheck;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.DashboardPage;
import pageObject.HardwarePage;

import java.io.IOException;
import java.time.Duration;

public class Test_Dashboard extends Base{

    static Logger log= LogManager.getLogger(Base.class.getName());

    DashboardPage dashboard;
    HardwarePage hardware;

    @BeforeMethod
    public void setUp() throws IOException {
        AppiumDriver<MobileElement> driver=start();
        log.info("Initialized driver");
        dashboard=new DashboardPage(driver);
        hardware=new HardwarePage(driver);
    }

    @Test
    void verifySubMenusPresent(){
        Assert.assertTrue(dashboard.battery.isDisplayed(),"Battery not present");
        log.info("Battery submenu is present");
        Assert.assertTrue(dashboard.cpuStats.isDisplayed(),"CPU Status not present");
        log.info("CPU stats submenu is present");
        Assert.assertTrue(dashboard.monitors.isDisplayed(),"Monitors not present");
        log.info("Monitors submenu is present");
        Assert.assertTrue(dashboard.benchmarks.isDisplayed(),"Benchmarks not present");
        log.info("Benchmarks submenu is present");
        Assert.assertTrue(dashboard.network.isDisplayed(),"Network not present");
        log.info("Network submenu is present");
        Assert.assertTrue(dashboard.ram.isDisplayed(),"RAM not present");
        log.info("RAM submenu is present");
        Assert.assertTrue(dashboard.temperatures.isDisplayed(),"Temperatures not present");
        log.info("Temperatures submenu is present");
        Assert.assertTrue(dashboard.tools.isDisplayed(),"Tools not present");
        log.info("Tools submenu is present");
        Assert.assertTrue(dashboard.model.isDisplayed(),"Model not present");
        log.info("Model submenu is present");
    }

    @Test
    void verifySubmenusAreMatched()
    {
        dashboard.battery.click();
        log.info("Clicked on battery sub menu");
        Assert.assertEquals(dashboard.title.getText(),"Battery","Battery menu doesnt match");
        dashboard.cancel.click();
        log.info("Clicked on cancel button");
        dashboard.network.click();
        log.info("Clicked on network sub menu");
        Assert.assertEquals(dashboard.title.getText(),"Network","Network menu doesnt match");
        dashboard.cancel.click();
        log.info("Clicked on cancel button");
        dashboard.ram.click();
        log.info("Clicked on ram sub menu");
        Assert.assertEquals(dashboard.title.getText(),"Memory","Memory setting doesnt match");
        dashboard.cancel.click();
        log.info("Clicked on cancel button");
        dashboard.storage.click();
        log.info("Clicked on storage sub menu");
        Assert.assertEquals(dashboard.title.getText(),"Storage","Storage setting doesnt match");
        dashboard.cancel.click();
        log.info("Clicked on cancel button");
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
        log.info("Performed swipe to right");
        Assert.assertTrue(hardware.processor.isDisplayed(),"Not landed on Processor page");
        action.press(PointOption.point(x1,y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(PointOption.point(x2,y)).release().perform();
        log.info("Performed swipe to left");
        Assert.assertTrue(dashboard.cpuStats.isDisplayed(),"Not landed on Dashboard page");


    }

    @AfterMethod
    public void tearDown() {
        Base.stop();
        log.info("Closed driver session");
    }
}
