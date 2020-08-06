package com.example.chet.config.tests.helpers;


import com.example.chet.config.tests.AppMan;
import com.example.chet.config.tests.User;
import org.openqa.selenium.By;

public class AuthHelp extends BasHelp {

    private boolean isLogged;
    public AuthHelp(AppMan appMan) {
        super(appMan);
    }

    public void EnterLoginAndPassword(String login, String pass) {
        User user = new User("olejiksin", "QaZWsXEdC99");
        driver.findElement(By.id("log_in")).click();
        driver.findElement(By.id("nw_username")).sendKeys(login);
        driver.findElement(By.id("nw_password")).click();
        driver.findElement(By.id("nw_password")).sendKeys(pass);
//        SubmitData();
    }

    public User getCreatedUser() {
        String name = driver.findElement(By.id("nw_username")).getText();
        String password = driver.findElement(By.id("nw_password")).getText();
        return User.builder()
                .login("olejiksin")
                .password("QaZWsXEdC99")
                .build();
    }

    public void SubmitData() {
        driver.findElement(By.id("nw_submit")).click();
    }
}
