package com.example.chet.config.tests.tests;// Generated by Selenium IDE

import com.example.chet.config.tests.Setting;
import com.example.chet.config.tests.TestBasClass;
import com.example.chet.config.tests.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class LoginTest extends TestBasClass {

  @Test
  public void   withNOICEdata() throws IOException {
//    appMan.getNavHelp().OpenMainPage();
    appMan.getAuthHelp().EnterLoginAndPassword(appMan.getSetting().getCorLog(),appMan.getSetting().getCorPass());
//    User user=appMan.getAuthHelp().getCreatedUser();
    Assert.assertEquals("olejiksin",appMan.getSetting().getCorLog());
    Assert.assertEquals("QaZWsXEdC99", appMan.getSetting().getCorPass());
    appMan.getAuthHelp().SubmitData();
  }

  @Test
  public void withBADdata(){
    appMan.getAuthHelp().EnterLoginAndPassword(appMan.getSetting().getUnCorLog(),appMan.getSetting().getUnCorPass());
    Assert.assertEquals("olejiksin",appMan.getSetting().getUnCorLog());
    Assert.assertEquals("QaZWsXEdC99", appMan.getSetting().getUnCorPass());
    appMan.getAuthHelp().SubmitData();
  }


}