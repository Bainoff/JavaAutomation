package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//TODO example of sequence
public class ActionsSequence {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\soft\\automation\\chromedriver\\chromedriver.exe");
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
            Thread.sleep(2000);
            driverCrossBrowser.quit();
        }
    }
}