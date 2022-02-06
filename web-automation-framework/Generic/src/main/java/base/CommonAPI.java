package base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.util.concurrent.TimeUnit;

public class CommonAPI {
    public WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\19176\\IdeaProjects\\selenium-homework6\\Generic\\src\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();// this is a class
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// to make selenuim to wait for 10 second in order to give selenium time to look for needed elements.
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        //driver.findElement(By.cssSelector("#widgets-view-email-modal-mount > div > div > div:nth-child(1) > div > div > div > div > button")).click();
        // String expectedTitle= "Best Buy | Official Online Store | Shop Now & Save";
        // String actualTitle= driver.getTitle();
        //Assert.assertEquals(actualTitle,expectedTitle, "title validation success");
    }

    @AfterMethod
    public void afterMethod() {

        driver.close();
    }

    public void click(String locator) {
        try {
            driver.findElement(By.xpath(locator)).click();
        } catch (Exception e) {
            driver.findElement(By.cssSelector(locator)).click();
        }
    }

    public void input(String locator, String text) {
        try {
            driver.findElement(By.xpath(locator)).sendKeys(text);
        } catch (Exception e) {
            driver.findElement(By.cssSelector(locator)).sendKeys(text);
        }
    }

    public void alertAccept() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void alertDismiss() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public void scrollDown() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("0,3000");
        Thread.sleep(4000);
    }

    public void hoverOver(String locater) throws InterruptedException {
        WebElement element = driver.findElement(By.xpath(locater));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        Thread.sleep(3000);


    }

    public void tabHandle() {
        String parentWindowHandle = driver.getWindowHandle();
        for (String chidTab : driver.getWindowHandles()) {
            driver.switchTo().window(chidTab);
        }
        System.out.println(driver.getTitle());


    }
}
