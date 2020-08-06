package com.example.chet.config.tests;

import org.junit.BeforeClass;

import java.io.IOException;

public class AuthBase extends TestBasClass {

    public static boolean isLogged=false;
    @BeforeClass
    public static void setUp() throws IOException {
        TestBasClass.appMan=AppMan.getInstance();
        Login();
    }

    public static void Login(){
        appMan.getAuthHelp().EnterLoginAndPassword(appMan.getSetting().getCorLog(),appMan.getSetting().getCorPass());
        appMan.getAuthHelp().SubmitData();
        isLogged=true;
    }
}
