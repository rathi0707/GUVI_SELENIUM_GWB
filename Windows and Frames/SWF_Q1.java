package org.seleniumlearning.GWB_TASKS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class SWF_Q1 {           //Selenium Windows and Frames

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/windows");

        WebElement Newwindowelement = driver.findElement(By.xpath("//a[contains(text(),'Click Here')]"));
        Newwindowelement.click();

        String ogwindow = driver.getWindowHandle();

        Set<String> Allwindows = driver.getWindowHandles();
        for(String window : Allwindows){
            if(!window.equals(ogwindow)){
                driver.switchTo().window(window);
                break;
            }
        }

        WebElement heading = driver.findElement(By.tagName("h3"));
        String text = heading.getText();
        if(text.equals("New Window")){
            System.out.println("Verified Text: " + text);
        }
        else{
            System.out.println("Text Not Matched");
        }

        driver.close();

        driver.switchTo().window(ogwindow);
        System.out.println("Back to og window: " + driver.getTitle());

        Thread.sleep(3000);
        driver.quit();

    }
}
