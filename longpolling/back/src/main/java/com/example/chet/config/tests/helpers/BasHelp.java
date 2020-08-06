package com.example.chet.config.tests.helpers;

import com.example.chet.config.tests.AppMan;
import org.openqa.selenium.WebDriver;

public class BasHelp {
    WebDriver driver ;
    protected AppMan appMan;
    public BasHelp(AppMan appMan1){
        this.appMan=appMan1;
        this.driver=appMan1.getDriver();
    }
}
