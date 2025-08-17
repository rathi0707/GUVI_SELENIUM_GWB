package org.seleniumlearning.GWB;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumLocatorsQ2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.demoblaze.com/");

        driver.manage().window().maximize();

        String title = driver.getTitle();

        if(title.equals("STORE")){
            System.out.println("Page landed on correct website");
        }
        else{
            System.out.println("Page not landed on correct website");
        }

        Thread.sleep(10000);

        driver.quit();
    }
}
