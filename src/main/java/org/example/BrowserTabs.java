package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BrowserTabs {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\soft\\automation\\chromedriver\\chromedriver.exe");
        WebDriver driverTab = new ChromeDriver();
        driverTab.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driverTab, Duration.ofSeconds(10));

        JavascriptExecutor js = (JavascriptExecutor)driverTab;

        try {
            driverTab.get("http://127.0.0.1:5500/html/index.html");
            Thread.sleep(5000);
            String window1 = driverTab.getWindowHandle();
            js.executeScript("window.open()");
            Set<String> currentWindows = driverTab.getWindowHandles();

            String window2 = null;
            for (String window : currentWindows) {
                if (!window.equals(window1)) {
                    window2 = window;
                    break;
                }
            }

            driverTab.switchTo().window(window2);
            driverTab.get("http://127.0.0.1:5500/html/index.html");
            driverTab.close();
            driverTab.switchTo().window(window1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driverTab.quit();
        }
    }
}

