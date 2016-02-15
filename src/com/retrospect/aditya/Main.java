package com.retrospect.aditya;


import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.*;
import java.util.*;

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

        Scanner s = new Scanner(new File("stuff.txt"));
        ArrayList<String> profiles = new ArrayList<String>();
        while (s.hasNextLine()) {
            profiles.add(s.next());
        }
        s.close();

        PrintWriter outputStream = null;
        try {
            outputStream = new PrintWriter(new FileOutputStream("links.txt", true));
        } catch (FileNotFoundException e) {
            System.out.println("Error opening the file stuff.txt.");
            System.exit(0);
        }

        Random random = new Random();
        for (int i = 0; i < profiles.size(); i++) {
            System.out.println("Profile List Index: " + i);
            try {
                int randNum = random.nextInt(5000) + 3000;
                Thread.sleep(randNum);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            driver.get(profiles.get(i));
            WebElement element = driver.findElement(By.className("view-public-profile"));
            System.out.println(element.getAttribute("href"));
            outputStream.println();
            outputStream.print(element.getAttribute("href"));

        }





        /*String fullName = get(driver, By.className("full-name"));
        String title = get(driver, By.className("title"));
        String locality = get(driver, By.className("locality"));
        String industry = get(driver, By.className("industry"));
        String connections = get(driver, By.xpath("//div[@class='member-connections']/strong"));
        String profileLink = get(driver, By.className("view-public-profile"));

        *//*String current = driver.findElement(By.cssSelector(".editable-item.section-item.current-position")).getText();
        String lines[] = current.split("\\r?\\n");
        String currentJobTitle = lines[0];
        String currentCompany = lines[1];
        String currentJobDuration = lines[2];
        String currentJobDescription = lines[3];*//*

        List<WebElement> allElements = driver.findElements(By.cssSelector(".editable-item.section-item.past-position"));
        for (WebElement element : allElements) {
            String past = element.getText();
            String pastSplit[] = past.split("\\r?\\n");
            for(String s: pastSplit) {
                System.out.println(s);
            }
            System.out.println();
            *//*String pastJobTitle = pastSplit[0];
            String pastCompany = pastSplit[1];
            String pastJobDuration = pastSplit[2];
            //String pastJobDescription = pastSplit[3];*//*
        }

        List<WebElement> topSkillsElements = driver.findElements(By.xpath("//ul[@class='skills-section']/li/span"));
        for (WebElement element : topSkillsElements) {
            String skills = element.getText();
            String pastSplit[] = skills.split("\\r?\\n");
            String skillName = pastSplit[1];
            String endorseCount = pastSplit[0];
        }

        List<WebElement> skillsElements = driver.findElements(By.xpath("//ul[@class='skills-section compact-view']/li/div/span"));
        for (WebElement element : skillsElements) {
            String skills = element.getText();
            String pastSplit[] = skills.split("\\r?\\n");
            String skillName = pastSplit[1];
            String endorseCount = pastSplit[0];
        }

        List<WebElement> languagesElements = driver.findElements(By.xpath("//div[@id='languages-view']/ol/li/h4/span"));
        for (WebElement element : languagesElements) {
            String language = element.getText();
        }*/


        //initSelenium();
        //getCompanyProfiles(driver);
        //getRecommenedProfiles(driver);
        //jsoupInit();
    }


    public static String get(WebDriver driver, By by) {
        if (isElementPresent(by, driver)) {
            return driver.findElement(by).getText();
        } else {
            return "Null";
        }
    }

    public static boolean isElementPresent(By by, WebDriver driver) {
        boolean present;
        try {
            driver.findElement(by);
            present = true;
        } catch (NoSuchElementException e) {
            present = false;
        }
        return present;
    }


    private static void initSelenium() {
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
    }

    private static void getRecommenedProfiles(WebDriver driver) throws FileNotFoundException {
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
        for (int i = 935; i < profiles.size(); i++) {
            System.out.println("Profile List Index: " + i);
            try {
                int randNum = random.nextInt(5000) + 3000;
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


    private static void jsoupInit() {
        try {

            String url = "https://www.linkedin.com/uas/login?goback=&trk=hb_signin";
            Connection.Response response = Jsoup
                    .connect(url)
                    .method(Connection.Method.GET)
                    .execute();

            Document responseDocument = response.parse();
            Element loginCsrfParam = responseDocument
                    .select("input[name=loginCsrfParam]")
                    .first();

            response = Jsoup.connect("https://www.linkedin.com/uas/login-submit")
                    .data("loginCsrfParam", loginCsrfParam.attr("value"))
                    .data("session_key", "dreruslejo@thrma.com")
                    .data("session_password", "Asdfvcxz")
                    .method(Connection.Method.POST)
                    .followRedirects(true)
                    .execute();

            Map<String, String> cookies = response.cookies();

            Document document = Jsoup.connect("https://www.linkedin.com/in/yatish27").cookies(cookies).get();


            String name = document.select("div.profile-overview-content").select("h1").text();
            String title = document.select("div.profile-overview-content").select("p").text();
            String dl = document.select("div.profile-overview-content").select("dl").text();

            System.out.println(document);

            System.out.println(dl);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
