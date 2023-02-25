package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//TODO waiting for something
public class Waiting {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\soft\\automation\\chromedriver\\chromedriver.exe");
        WebDriver driverGoogle = new ChromeDriver();

//waiting implicitly
        driverGoogle.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //waiting explicitly
        WebElement element = new WebDriverWait(driverGoogle, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("123")));
    }
}
