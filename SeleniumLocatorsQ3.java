package org.seleniumlearning.GWB;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumLocatorsQ3 {
    public static void main(String[] args) throws InterruptedException{

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.wikipedia.org/");

        driver.manage().window().maximize();

        WebElement searchbox = driver.findElement(By.name("search"));
        searchbox.sendKeys("Artificial Intelligence");
        searchbox.sendKeys(Keys.ENTER);

        Thread.sleep(5000);

        WebElement historyLink = driver.findElement(By.linkText("History"));
        historyLink.click();

        Thread.sleep(3000); // wait for section to load

        WebElement sectionTitle = driver.findElement(By.id("History"));
        System.out.println("Section Title: " + sectionTitle.getText());

        // Manual wait (10 seconds before closing)
        Thread.sleep(10000);

        driver.quit();
    }
}
