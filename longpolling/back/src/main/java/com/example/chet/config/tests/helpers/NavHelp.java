package com.example.chet.config.tests.helpers;

import com.example.chet.config.tests.AppMan;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavHelp extends BasHelp {
    private String baseUrl;
    public NavHelp(AppMan appMan, String Url){
        super(appMan);
        this.baseUrl=Url;
    }



    public void OpenMainPage() {
//        driver.get("https://hub.docker.com");
        driver.get(appMan.getSetting().getUrl());
    }
    public void OpenRepPage() {
        WebDriverWait webDriverWait=new WebDriverWait(driver,5);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".styles__repoRow___1vo4h:nth-child(1)> .dcard")));
        driver.findElement(By.cssSelector(".styles__repoRow___1vo4h:nth-child(1) > .dcard")).click();
    }
}
