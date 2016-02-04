package com.retrospect.aditya;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {


        FirefoxBinary binary = new FirefoxBinary(new File("C:\\Program Files (x86)\\Mozilla Firefox\\Firefox.exe"));
        FirefoxProfile profile = new FirefoxProfile();
        WebDriver driver = new FirefoxDriver(binary, profile);
        driver.manage().window().maximize();
        driver.get("http://www.linkedin.com/");

        WebElement id = driver.findElement(By.id("login-email"));
        WebElement pass = driver.findElement(By.id("login-password"));
        id.sendKeys("hekulitibo@thrma.com");
        pass.sendKeys("Asdfvcxz");

        driver.findElement(By.xpath("//input[@value='Sign in' and @type='submit']")).click();

        driver.get("https://www.linkedin.com/vsearch/p?f_CC=861427");


        /*List<WebElement> allElements = driver.findElements(By.xpath("//div[@id='results-container']/ol/li"));

        for (WebElement element: allElements) {
            System.out.println(element.getText());
        }*/

        if(driver.getPageSource().contains("https://www.linkedin.com/profile")) {
            System.out.println(1);
        }


    }

}
