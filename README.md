# JavaAutomation
Training automation project using Selenium WebDriver and TestNG

![Selenium](https://github.com/Bainoff/JavaAutomation/blob/master/selenium.jpg?raw=true)

This is my first dive into the dark waters of testing automation (with indispensable [Alexey Marshal's](https://youtu.be/L2jMIJy0u90) support).
```Java
//TODO disappearing elements
public class DisappearElements {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\soft\\automation\\chromedriver\\chromedriver.exe");
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
```
It seems to be not so fearful as I thought! :)
