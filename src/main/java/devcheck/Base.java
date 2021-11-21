package devcheck;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public static AppiumDriver<MobileElement> driver;

    public static AppiumDriver<MobileElement> start() throws IOException {
        Properties prop=new Properties();
        String projectPath=System.getProperty("user.dir");
        FileInputStream fis=new FileInputStream(projectPath+"\\src\\main\\java\\resources\\config.properties");
        prop.load(fis);
        String platform=prop.getProperty("platform");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "\\src\\main\\java\\resources\\app\\");
        File app;
        switch(platform){
            case "android":
                app = new File (appDir, "DevCheck.apks");
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("deviceName", "Pixel");
                capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
                capabilities.setCapability("appPackage", "flar2.devcheck");
                capabilities.setCapability("appActivity", "flar2.devcheck.SplashActivity");
                driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                break;
            case "ios":
                classpathRoot = new File(System.getProperty("user.dir"));
                appDir = new File(classpathRoot, "/src/main/resources/app");
                app = new File(appDir, "");
                capabilities.setCapability("platformName", "ios");
                capabilities.setCapability("deviceName", "iPhone 11");
                capabilities.setCapability("resources/app", app.getAbsolutePath());
                capabilities.setCapability("automationName", "XCUITest");
                driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                break;
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }

}
