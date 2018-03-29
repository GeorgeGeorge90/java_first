package ru.stqa.pft.addressbook;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class KeywordCreationTests {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void KeywordCreationTests() {
        wd.get("https://www.carid.com/");
        wd.findElement(By.cssSelector("label.header-search-btn.js-search-btn")).click();
        wd.findElement(By.id("headsearch-field-input")).click();
        wd.findElement(By.id("headsearch-field-input")).clear();
        wd.findElement(By.id("headsearch-field-input")).sendKeys("turbo");
        wd.findElement(By.cssSelector("input.search-btn")).click();
        wd.findElement(By.cssSelector("div.search-result-total")).click();
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
}
