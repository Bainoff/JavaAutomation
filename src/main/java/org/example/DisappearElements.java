package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

//TODO disappearing elements
public class DisappearElements {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\soft\\automation\\chromedriver\\chromedriver.exe");
    WebDriver driverPaginator = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driverPaginator, Duration.ofSeconds(10));
        try {
        driverPaginator.get("https://pagination.js.org/");
        Thread.sleep(2000);
        List<WebElement> elements = driverPaginator.findElements(By.xpath("//div[@class='data-container']/ul/li"));
        List<WebElement> pages = driverPaginator.findElements(By.xpath("//div[@class='paginationjs-pages']/ul/li"));
        String text = elements.get(5).getText();
        System.out.println(text);
        pages.get(2).click();
        wait.until(ExpectedConditions.stalenessOf(elements.get(5)));
        elements = driverPaginator.findElements(By.xpath("//div[@class='data-container']/ul/li"));
        text = elements.get(5).getText();
        System.out.println(text);
    } catch (InterruptedException e) {
        e.printStackTrace();
    } finally {
        driverPaginator.quit();
    }
}
}
