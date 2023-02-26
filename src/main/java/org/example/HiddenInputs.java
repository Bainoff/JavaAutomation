package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HiddenInputs {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\soft\\automation\\chromedriver\\chromedriver.exe");
        WebDriver driverInput = new ChromeDriver();
        driverInput.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driverInput, Duration.ofSeconds(10));

        JavascriptExecutor js = (JavascriptExecutor)driverInput;

        try {
            driverInput.get("http://127.0.0.1:5500/html/index.html");
            Thread.sleep(5000);
            WebElement element = driverInput.findElement(By.id("a"));
            js.executeScript("document.querySelector('#a').setAttribute('style', 'opacity:1', 'width:100px', 'height:100px', 'display:block')");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driverInput.quit();
        }
    }
}

