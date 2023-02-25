package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//TODO additional methods (combine them to perform some actions)
public class MoreMethods {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\soft\\automation\\chromedriver\\chromedriver.exe");
        WebDriver driverDev = new ChromeDriver();
        WebElement element = driverDev.findElement(By.cssSelector("(.d-inline-block)[1]"));
        Actions actions = new Actions(driverDev);
        actions
                .contextClick()
                .clickAndHold()
                .click()
                .doubleClick()
                .moveToElement(element)
                .keyDown(element, Keys.DOWN)
                .keyUp(element, Keys.UP)
                .clickAndHold()
                .release()
                .build()
                .perform();
    }
}