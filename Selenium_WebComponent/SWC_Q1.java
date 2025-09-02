package org.seleniumlearning.GWB.Selenium_WebComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SWC_Q1 {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/datepicker/");
        driver.switchTo().frame(0);

       WebElement datepicker = driver.findElement(By.xpath("//input[@id='datepicker']"));
        datepicker.click();
       // String CurrentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

        WebElement nextmonth = driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']"));
        nextmonth.click();

        String date = "22";
        List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
        for (WebElement dates : allDates) {
            if (dates.getText().equals(date)) {
                dates.click();
                break;
            }
        }

        String selectedDate = datepicker.getAttribute("value");
        System.out.println("Selected Date: " + selectedDate);

        Thread.sleep(3000);
        driver.quit();


    }
}
