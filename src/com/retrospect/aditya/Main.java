package com.retrospect.aditya;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {


        FirefoxBinary binary = new FirefoxBinary(new File("C:\\Program Files (x86)\\Mozilla Firefox\\Firefox.exe"));
        FirefoxProfile profile = new FirefoxProfile();
        WebDriver driver = new FirefoxDriver(binary, profile);
        driver.manage().window().maximize();
        driver.get("http://www.linkedin.com/");

        WebElement id = driver.findElement(By.id("login-email"));
        WebElement pass = driver.findElement(By.id("login-password"));
        id.sendKeys("dreruslejo@thrma.com");
        pass.sendKeys("Asdfvcxz");

        driver.findElement(By.xpath("//input[@value='Sign in' and @type='submit']")).click();


        //getCompanyProfiles(driver);


        Scanner s = new Scanner(new File("a.txt"));
        ArrayList<String> profiles = new ArrayList<String>();
        while (s.hasNextLine()) {
            profiles.add(s.next());
        }
        s.close();

        PrintWriter outputStream = null;
        try {
            outputStream = new PrintWriter(new FileOutputStream("stuff.txt", true));
        } catch (FileNotFoundException e) {
            System.out.println("Error opening the file stuff.txt.");
            System.exit(0);
        }

        Random random = new Random();
        for (int i = 651; i < profiles.size(); i++) {
            System.out.println("Profile List Index: " + i);
            try {
                int randNum = random.nextInt(5000) + 1000;
                Thread.sleep(randNum);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            driver.get(profiles.get(i));
            List<WebElement> allElements = driver.findElements(By.xpath("//div[@class='insights-browse-map']/ul/li/a"));
            for (WebElement element : allElements) {
                System.out.println(element.getAttribute("href"));
                outputStream.println();
                outputStream.print(element.getAttribute("href"));
            }
        }


    }

    private static void getCompanyProfiles(WebDriver driver) {
        Random random = new Random();

        PrintWriter outputStream = null;
        try {
            outputStream = new PrintWriter(new FileOutputStream("stuff.txt", true));
        } catch (FileNotFoundException e) {
            System.out.println("Error opening the file stuff.txt.");
            System.exit(0);
        }

        for (int i = 70; i < 250; i++) {

            try {
                int randNum = random.nextInt(5000) + 5000;
                System.out.println(randNum);
                Thread.sleep(randNum);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

            driver.get("https://www.linkedin.com/vsearch/p?f_CC=861427&page_num=" + i);

            List<WebElement> allElements = driver.findElements(By.xpath("//div[@id='results-container']/ol/li/a"));

            for (WebElement element : allElements) {
                System.out.println(element.getAttribute("href"));
                outputStream.println();
                outputStream.print(element.getAttribute("href"));
            }
        }
    }

}
