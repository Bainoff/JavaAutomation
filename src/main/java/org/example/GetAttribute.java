package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttribute {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\soft\\automation\\chromedriver\\chromedriver.exe");
        WebDriver driverOnliner = new ChromeDriver();
        driverOnliner.get("www.onliner.by");
        WebElement element1 = driverOnliner.findElement(By.xpath("(//a[text()='Найти'])[1]"));
        String par = element1.getAttribute("offsetWidth");
        System.out.println(par);
    }
}
