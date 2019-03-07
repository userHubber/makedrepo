package kng.driver;

import java.util.concurrent.TimeUnit;
import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import kng.Config;

public class DriverProperties extends Driver {

    private ChromeOptions options;

    protected WebDriver setUpChromDriver() {

        String downloadFilepath = Config.SAVED_DOCS_PATH;

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory", downloadFilepath);
        chromePrefs.put("profile.default_content_setting_values.popups", 2);
        options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--disable-notifications");
        options.addArguments("start-maximized");
        System.setProperty("webdriver.chrome.driver", Config.CHROM_DRIVER_PATH);
        wd = new ChromeDriver(options);
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
        return wd;
    }
}
