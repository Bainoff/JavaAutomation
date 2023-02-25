package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// TODO locating element
public class LocElem {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\soft\\automation\\chromedriver\\chromedriver.exe");
        WebDriver driverGoogle = new ChromeDriver();
        driverGoogle.get("https://google.com");
        WebElement entCookies = driverGoogle.findElement(By.xpath("(//a[text()='Odrzuć wszystko'])[2]"));
        entCookies.click();
        WebElement input = driverGoogle.findElement(By.xpath("//input[@aria-label='Szukaj']"));
        input.click();
    }
}
