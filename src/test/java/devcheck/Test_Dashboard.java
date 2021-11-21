package devcheck;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test_Dashboard extends Base{

    @BeforeTest
    public void setUp() throws IOException {
        AppiumDriver<MobileElement> driver=start();
    }

    @Test
    void test(){
    }
}
