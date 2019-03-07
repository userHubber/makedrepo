package kng.tests.mainPage;

import kng.navigation.URLs;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import kng.driver.DriverMethods;
import org.testng.annotations.BeforeTest;

public class Case_MainPage extends DriverMethods {

    private Steps_MainPage step;
    private Data_MainPage mainPage_info;
//================================================================  

    @BeforeTest
    public void preconditions() {
        System.out.println("ГЛАВНАЯ СТРАНИЦА");
        super.wd = super.setUpChromDriver();
        step = new Steps_MainPage(super.wd);
        mainPage_info = new Data_MainPage();
    }

    @Test
    public void case_FooterControl() {
        System.out.println("Наличие осн. разделов футера");
        super.driverGet(URLs.MAINPAGE);
        step.footerContentControl(mainPage_info.footerContent);
    }

    @AfterTest
    public void closeBrowser() {
        super.driverCloseQuit();
    }
}
