package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","D:\\soft\\automation\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

//locating element
        driver.get("https://google.com");
        WebElement input = driver.findElement(By.xpath("//input[@aria-label='Szukaj']"));
        input.click();

//waiting for something
//waiting implicitly
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//waiting explicitly
        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("123"))));
    }
}