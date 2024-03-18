package utils;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import driver.PageDriver;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;

public class Take_Screenshot {


    // allure report
    @Step("Taking a screenshot for {0}")
    public static void screenshotForAllure(String name) {
        Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot) PageDriver.getCurrentDriver())
                .getScreenshotAs(OutputType.BYTES))
        );
    }


}
