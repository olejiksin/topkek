package com.example.chet.config.tests;


import com.example.chet.config.tests.helpers.AuthHelp;
import com.example.chet.config.tests.helpers.ChangeHelp;
import com.example.chet.config.tests.helpers.NavHelp;
import lombok.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Getter
public class AppMan {
    WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    private AuthHelp authHelp;
    private ChangeHelp changeHelp;
    private NavHelp navHelp;
    private Setting setting;
    private static ThreadLocal<AppMan> app=new ThreadLocal<>();

    public static AppMan getInstance() throws IOException {
        if(app.get()==null){
            System.out.println("ALARM");
            AppMan newInst=new AppMan();
            app.set(newInst);
            newInst.navHelp.OpenMainPage();
            return app.get();
        }
        return  app.get();
    }
    public AppMan() throws IOException {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\oleji\\Downloads\\geckodriver.exe");
        setting=new Setting();
        setting.setData();
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        authHelp = new AuthHelp(this);
        changeHelp = new ChangeHelp(this);
        String baseUrl = setting.getUrl();
        navHelp = new NavHelp(this,baseUrl );
    }
}
