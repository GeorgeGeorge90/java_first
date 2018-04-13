import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

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
            File scrFile = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);

            DateFormat dateFormat = new SimpleDateFormat("yyyy MM dd");
            Date date = new Date();

            Path path = FileSystems.getDefault().getPath("d:\\screen\\");
            File Folder = new File(path.toString() + "\\" + dateFormat.format(date).toString());
            Folder.mkdir();
            File newFile = new File(Folder.toPath().toString(), keyword + ".png");
//           Now you can do whatever you need to do with it, for example copy somewhere
            Files.copy(scrFile.toPath(), newFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
//        FileUtils.copyFile(scrFile, new File("c:\\tmp\\screenshot.png"));
//            wd.findElement(By.id("headsearch-field-input")).click();
//        Files.copy(src, dst, StandardCopyOption.REPLACE_EXISTING);
        }

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
