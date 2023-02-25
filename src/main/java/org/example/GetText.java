package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//TODO get text
public class GetText {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\soft\\automation\\chromedriver\\chromedriver.exe");
        WebDriver driverGoogle = new ChromeDriver();
        WebElement element2 = driverGoogle.findElement(By.cssSelector(".gLFyf"));
        String par2 = element2.getText();
        System.out.println(par2);
    }
}
