package helpers;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class TakeScreenShotHelper {

    public static void takeScreenshot(String titleFile, WebDriver webDriver) {
        File screenshotSrc = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        String targetFileName = titleFile + System.currentTimeMillis() + ".png";
        String urlFullPath = String.format("%s\\photos\\%s", System.getProperty("user.dir"), targetFileName);
        File targetFile = new File(urlFullPath);
        try {
            FileUtils.copyFile(screenshotSrc, targetFile);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
