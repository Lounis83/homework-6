package us.piit;


import base.CommonApi;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AppTest extends CommonApi {

    @Test
    public void checkbox() throws InterruptedException {
        List<WebElement> listOfElements = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (WebElement options : listOfElements) {
            options.click();
        }

        Thread.sleep(1000);
        WebElement Option2 = driver.findElement(By.xpath("//input[@id='checkBoxOption2']"));
        boolean isSelected = Option2.isDisplayed();
        if (isSelected) {
            Option2.click();
        }
        if (!isSelected) {
            Option2.isDisplayed();
        }
    }
    @Test
    public void elementDisplay() throws InterruptedException{
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        WebElement display = driver.findElement(By.xpath("//legend[text()='Element Displayed Example']"));
        scroll.executeScript("arguments[0].scrollIntoView()", display);
        Thread.sleep(2000);

    /*JavascriptExecutor scroll = (JavascriptExecutor) driver;
    scroll.executeScript("window.scrollBy(0, 500)");
    Thread.sleep(2000);*/

        //driver.findElement(By.xpath("//input[@id='displayed-text']")).sendKeys("Rachid");
        input("//input[@id='displayed-text']", "Rachid");
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//input[@id='hide-textbox']")).click();
        click("//input[@id='hide-textbox']");
        Thread.sleep(2000);
        click("//input[@id='show-textbox']");
        //driver.findElement(By.xpath("//input[@id='show-textbox']")).click();
    }


    @Test
    public void RadioButton() {

        List<WebElement> radioButton= driver.findElements(By.xpath("//input[@type='radio']"));
        for (WebElement element:radioButton) {
            if (!element.isSelected());
            element.click();
        }


    }


    @Test
    public void SuggessionClass() throws InterruptedException {
        input("//input[@id='autocomplete']","cen");
        List<WebElement> suggessionList=driver.findElements(By.xpath("//ul[@class='ui-menu ui-widget ui-widget-content ui-autocomplete ui-front']"));
        for (WebElement element:suggessionList) {
            if (element.equals("Central African Republic"));
            element.click();
            Thread.sleep(2000);

        }


    }
    @Test
    public void switchWindow(){
        driver.findElement(By.xpath("//Button[@id='openwindow']")).click();
        tabHandle();
        driver.findElement(By.xpath("//a[text()='Contact']")).click();


    }

    @Test
    public void switshToAlert() throws InterruptedException {
        input("//input[@id='name']", "lounis");
        Thread.sleep(2000);
        click("//input[@id='alertbtn']");
        Thread.sleep(2000);
        alertAccept();
        Thread.sleep(2000);

    }

    @Test
    public void switshConfirm() throws InterruptedException {
        input("//input[@id='name']", "lounis");
        Thread.sleep(2000);
        click("//input[@id='confirmbtn']");
        Thread.sleep(2000);
        alertDismiss();
        Thread.sleep(2000);
    }

    @Test
    public void mousehover() throws InterruptedException {
        scrollDown();
        hoverOver("//button[@id=\"mousehover\"]");
        Thread.sleep(2000);
        click("//a[text()=\"Top\"]");
        Thread.sleep(3000);
    }


}
