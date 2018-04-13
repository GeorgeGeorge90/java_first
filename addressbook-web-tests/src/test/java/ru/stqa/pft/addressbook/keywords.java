import com.sun.org.apache.xpath.internal.compiler.Keywords;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class keywords {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
//        int width = 1920;
//        int height = 1080;
//        wd.manage().window().setSize(new Dimension(width, height));
//        wd.manage().window().setPosition(new Point(0, 0));
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.findElement(By.tagName("body")).sendKeys(Keys.F11);
    }
    
    @Test
    public void keywords() throws InterruptedException, IOException {
        wd.get("https://www.carid.com/");
        wd.findElement(By.cssSelector("label.header-search-btn.js-search-btn")).click();
        for (String keyword: this.getKeyWordsList()) {
            wd.findElement(By.id("headsearch-field-input")).click();
            wd.findElement(By.id("headsearch-field-input")).clear();
            wd.findElement(By.id("headsearch-field-input")).sendKeys(keyword);
            Thread.sleep(10000);
            File scrFile = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
        }
//        File path = new File("C:\\screen\\");
        // Now you can do whatever you need to do with it, for example copy somewhere
//        Files.copy(scrFile.toPath(), path.toPath(), StandardCopyOption.COPY_ATTRIBUTES);
        //        FileUtils.copyFile(scrFile, new File("c:\\tmp\\screenshot.png"));        wd.findElement(By.id("headsearch-field-input")).click();

    }
    
    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public String[] getKeyWordsList ()
    {
        String[] keywords = {
                "turbo",
                "seat",
                "turbo kit"
        };
        
        return keywords;
    }
}
