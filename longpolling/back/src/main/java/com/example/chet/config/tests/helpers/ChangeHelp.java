package com.example.chet.config.tests.helpers;

import com.example.chet.config.tests.AppMan;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChangeHelp extends BasHelp {
    private NavHelp navHelp;


    public ChangeHelp(AppMan appMan) {
        super(appMan);
    }

    public void ChangeDescr() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".styles__repoRow___1vo4h:nth-child(1) > .dcard")));
        driver.findElement(By.cssSelector(".styles__repoRow___1vo4h:nth-child(1) > .dcard")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".dbutton:nth-child(2) > .dicon")));
        driver.findElement(By.cssSelector(".dbutton:nth-child(2) > .dicon")).click();
        driver.findElement(By.xpath("//div[@id=\'module-repository-detail\']/div[3]/div/div/div/div/div/div[2]/div/form/div/div/div/textarea[2]")).click();
        driver.findElement(By.xpath("//div[@id=\'module-repository-detail\']/div[3]/div/div/div/div/div/div[2]/div/form/div/div/div/textarea[2]")).click();
        {
            WebElement element = driver.findElement(By.xpath("//div[@id=\'module-repository-detail\']/div[3]/div/div/div/div/div/div[2]/div/form/div/div/div/textarea[2]"));
            Actions builder = new Actions(driver);
            builder.doubleClick(element).perform();
        }
        driver.findElement(By.xpath("//div[@id=\'module-repository-detail\']/div[3]/div/div/div/div/div/div[2]/div/form/div/div/div/textarea[2]")).sendKeys("fghdfghdfg");
        driver.findElement(By.cssSelector(".styles__submitRow___2Y3KP > .styles__primary-consolidated___3wafe")).click();
    }

    public String getChangeDescr() {
        String newDesc = driver.findElement(By.xpath("//div[@id=\'module-repository-detail\']/div[3]/div/div/div/div/div/div[2]/div/form/div/div/div/textarea[2]")).getText();
        newDesc = "fghdfghdfg";
        return newDesc;
    }

    public void DeleteRep() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".styles__repoRow___1vo4h:nth-child(1) > .dcard")));
        driver.findElement(By.cssSelector(".styles__repoRow___1vo4h:nth-child(1) > .dcard")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable((By.cssSelector(".styles__tab___ztJkZ:nth-child(7)"))));
        driver.findElement(By.cssSelector(".styles__tab___ztJkZ:nth-child(7)")).click();
        driver.findElement(By.cssSelector(".styles__deleteButton___Iq2fu")).click();
        driver.findElement(By.xpath("//input[@id=\'imageNameField\']")).click();
        driver.findElement(By.xpath("//input[@id=\'imageNameField\']")).sendKeys("dfgd");
        driver.findElement(By.cssSelector(".styles__deleteButtons___20oE0 > .styles__panic___ofWYo")).click();

    }

    public void SetNewRepNameAndCreate() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".dbutton > span")));
        driver.findElement(By.cssSelector(".dbutton > span")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id=\'mainContainer\']/div/div[2]/div/div/form/div/div[2]/div/div[2]/div/input")));
        driver.findElement(By.xpath("//div[@id=\'mainContainer\']/div/div[2]/div/div/form/div/div[2]/div/div[2]/div/input")).click();
        driver.findElement(By.xpath("//div[@id=\'mainContainer\']/div/div[2]/div/div/form/div/div[2]/div/div[2]/div/input")).sendKeys("dfgd");
        driver.findElement(By.name("submit")).click();
    }

    public String getNewRep(){
        String nameRep=driver.findElement(By.xpath("//div[@id=\'mainContainer\']/div/div[2]/div/div/form/div/div[2]/div/div[2]/div/input")).getText();
        nameRep="dfgd";
        return nameRep;
    }



}
