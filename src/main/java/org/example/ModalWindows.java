package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Alert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class ModalWindows {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\soft\\automation\\chromedriver\\chromedriver.exe");
        WebDriver driverMod = new ChromeDriver();
        driverMod.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driverMod, Duration.ofSeconds(10));
        try {
            driverMod.get("http://127.0.0.1:5500/html/index.html");
            Thread.sleep(5000);
            WebElement element = driverMod.findElement(By.id("a"));
            WebElement element2 = driverMod.findElement(By.id("b"));
            WebElement element3 = driverMod.findElement(By.id("c"));

            element.click();
            Alert alert = wait.until(alertIsPresent());
            alert.accept();

            element2.click();
            Alert prompt = wait.until(alertIsPresent());

            prompt.sendKeys("Super!!");
            prompt.accept();

            Alert alert2 = wait.until(alertIsPresent());
            Thread.sleep(4000);
            alert2.accept();

            element3.click();
            Alert alert3 = wait.until(alertIsPresent());
            alert3.dismiss();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driverMod.quit();
        }
    }
}
