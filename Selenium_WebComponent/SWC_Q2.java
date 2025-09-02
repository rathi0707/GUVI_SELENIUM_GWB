package org.seleniumlearning.GWB.Selenium_WebComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SWC_Q2 {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(0);

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement destination = driver.findElement(By.id("droppable"));

        Actions action = new Actions(driver);
        action.dragAndDrop(source, destination).perform();

        String bgColor = destination.getCssValue("background-color");
        System.out.println("Background color after drop: " + bgColor);

        String droppedText = destination.getText();
        if (droppedText.equals("Dropped!")) {
            System.out.println("Drag and Drop Successful!");
        } else {
            System.out.println("Drag and Drop Failed!");
        }

        Thread.sleep(2000);
        driver.quit();
        }
    }
