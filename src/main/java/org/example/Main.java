package org.example;
import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\soft\\automation\\chromedriver\\chromedriver.exe");
        WebDriver driverGoogle = new ChromeDriver();
        WebDriver driverOnliner = new ChromeDriver();

//locating element
        driverGoogle.get("https://google.com");
        WebElement entCookies = driverGoogle.findElement(By.xpath("(//a[text()='Odrzuć wszystko'])[2]"));
        entCookies.click();
        WebElement input = driverGoogle.findElement(By.xpath("//input[@aria-label='Szukaj']"));
        input.click();

//waiting for something
//waiting implicitly
        driverGoogle.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//waiting explicitly
        WebElement element = (new WebDriverWait(driverGoogle, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("123"))));

//attributes properties (getting property (not attribute)
        driverOnliner.get("www.onliner.by");
        WebElement element1 = driverOnliner.findElement(By.xpath("(//a[text()='Найти'])[1]"));
        String par = element1.getAttribute("offsetWidth");
        System.out.println(par);

//get text
        WebElement element2 = driverGoogle.findElement(By.cssSelector(".gLFyf"));
        String par2 = element2.getText();
        System.out.println(par2);

//get css style
        WebDriver driverDev = new ChromeDriver();
        driverDev.get("https://devby.io");
        WebElement element3 = driverDev.findElement(By.cssSelector("(.d-inline-block)[1]"));
        String par3 = element3.getCssValue("display");
        System.out.println(par3);

//send keys
        WebDriver driverUdemy = new ChromeDriver();
        driverUdemy.get("https://www.udemy.com");
        WebElement element4 = driverUdemy.findElement(By.xpath("//input[@name='q']"));
        element4.clear();
        element4.sendKeys("Java", Keys.ENTER);

//additional methods (combine them to perform some actions)

        Actions actions = new Actions(driverDev);
        actions
                .contextClick()
                .clickAndHold()
                .click()
                .doubleClick()
                .moveToElement(element4)
                .keyDown(element2, Keys.DOWN)
                .keyUp(element2, Keys.UP)
                .clickAndHold()
                .release()
                .build()
                .perform();

// example of sequence
        WebDriver driverCrossBrowser = new ChromeDriver();
        try {
            driverCrossBrowser.get("https://crossbrowsertesting.github.io/drag-and-drop");
            Thread.sleep(2000);
            WebElement element5 = driverCrossBrowser.findElement(By.id("draggable"));
            WebElement element6 = driverCrossBrowser.findElement(By.id("droppable"));

            Actions actions1 = new Actions(driverCrossBrowser);

            actions1
                    .dragAndDropBy(element5, 200, 200)
                    .pause(1000)
                    .moveToElement(element5)
                    .clickAndHold()
                    .moveToElement(element6)
                    .release()
                    .build()
                    .perform();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            Thread.sleep(20000);
            driverCrossBrowser.quit();
        }
    }
}