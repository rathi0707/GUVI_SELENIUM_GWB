package org.seleniumlearning.GWB_TASKS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SWF_Q2 {
    static WebDriver driver;

    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/nested_frames");
        driver.manage().window().maximize();

        // ---- Switch to TOP frame and verify there are 3 child frames ----
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-top']")));
        int topFrameCount = driver.findElements(By.xpath("//frame")).size();
        System.out.println("Number of frames in top frame: " + topFrameCount);

        // ---- LEFT FRAME ----
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-left']")));
        String leftText = driver.findElement(By.xpath("//body")).getText();
        System.out.println("Left frame text: " + leftText);
        driver.switchTo().parentFrame(); // back to top frame

        // ---- MIDDLE FRAME ----
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-middle']")));
        String middleText = driver.findElement(By.id("content")).getText();
        System.out.println("Middle frame text: " + middleText);
        driver.switchTo().parentFrame(); // back to top frame

        // ---- RIGHT FRAME ----
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-right']")));
        String rightText = driver.findElement(By.xpath("//body")).getText();
        System.out.println("Right frame text: " + rightText);
        driver.switchTo().parentFrame(); // back to top frame

        // Go back to MAIN page before moving to bottom
        driver.switchTo().defaultContent();

        // ---- BOTTOM FRAME ----
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-bottom']")));
        String bottomText = driver.findElement(By.xpath("//body")).getText();
        System.out.println("Bottom frame text: " + bottomText);
        driver.switchTo().defaultContent(); // return to main page

        // ---- VERIFY PAGE TITLE ----
        String actualTitle = driver.getTitle();
        if ("Frames".equals(actualTitle)) {
            System.out.println("Page title verification PASSED: " + actualTitle);
        } else {
            System.out.println("Page title verification FAILED. Actual title: " + actualTitle);
        }

        // Close browser
        driver.quit();
    }
}
