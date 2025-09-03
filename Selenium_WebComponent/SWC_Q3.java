package org.seleniumlearning.GWB.Selenium_WebComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SWC_Q3 {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.guvi.in/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[contains(text(), 'Sign up')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("name")).sendKeys("Jegan");
        driver.findElement(By.id("email")).sendKeys("testuserjegan@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Jegan@2002");
        driver.findElement(By.id("mobileNumber")).sendKeys("8838762653");

        driver.findElement(By.xpath("//a[@class='btn signup-btn']")).click();

        Thread.sleep(20000);

        driver.findElement(By.xpath("//a[@id='login-btn']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("email")).sendKeys("testuserjegan@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Jegan@2002");
        driver.findElement(By.xpath("//a[@id='login-btn']")).click();

        String loginTitle = driver.getTitle();
        System.out.println("Page title after login: " + loginTitle);

        if (loginTitle.equals("GUVI")) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed!");
        }

        // Step 10: Close browser
        driver.quit();
    }


    }
