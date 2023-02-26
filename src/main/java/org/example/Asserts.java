package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Asserts {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\soft\\automation\\chromedriver\\chromedriver.exe");
        WebDriver driverAssert = new ChromeDriver();
        driverAssert.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driverAssert, Duration.ofSeconds(10));

        try {
            driverAssert.get("http://127.0.0.1:5500/html/index.html");
            Thread.sleep(5000);
            String title = driverAssert.getTitle();
            org.testng.Assert.assertEquals(title, "Document");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driverAssert.quit();
        }
    }
}
