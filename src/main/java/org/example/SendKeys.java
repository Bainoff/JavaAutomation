package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//TODO send keys
public class SendKeys {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\soft\\automation\\chromedriver\\chromedriver.exe");
        WebDriver driverUdemy = new ChromeDriver();
        driverUdemy.get("https://www.udemy.com");
        WebElement element4 = driverUdemy.findElement(By.xpath("//input[@name='q']"));
        element4.clear();
        element4.sendKeys("Java", Keys.ENTER);
    }
}