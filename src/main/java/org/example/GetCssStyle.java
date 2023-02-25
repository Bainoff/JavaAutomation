package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//TODO get css style
public class GetCssStyle {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\soft\\automation\\chromedriver\\chromedriver.exe");
        WebDriver driverDev = new ChromeDriver();
        driverDev.get("https://devby.io");
        WebElement element3 = driverDev.findElement(By.cssSelector("(.d-inline-block)[1]"));
        String par3 = element3.getCssValue("display");
        System.out.println(par3);
    }
}