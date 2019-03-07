package kng.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import java.util.regex.Pattern;

public class Waitings {

    private WebDriver wd;
    private WebDriverWait webDriverWait;
//=========================================================================

    public Waitings() {
    }

    public Waitings(WebDriver driver) {
        wd = driver;
    }

    protected boolean urlContains(int sec, String fraction) {
        webDriverWait = new WebDriverWait(wd, sec);
        try {
            return webDriverWait.until(ExpectedConditions.urlContains(fraction));
        } catch (TimeoutException e) {
        }
        return false;
    }

    protected boolean urlToBe(int sec, String url) {
        webDriverWait = new WebDriverWait(wd, sec);
        try {
            return webDriverWait.until(ExpectedConditions.urlToBe(url));
        } catch (TimeoutException e) {
        }
        return false;
    }

    protected boolean urlMatches(int sec, String fraction) {
        webDriverWait = new WebDriverWait(wd, sec);
        try {
            return webDriverWait.until(ExpectedConditions.urlMatches(fraction));
        } catch (TimeoutException e) {
        }
        return false;
    }

    protected boolean visibility(int sec, By selector) {
        webDriverWait = new WebDriverWait(wd, sec);
        try {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(selector));
            return true;
        } catch (TimeoutException e) {
//            System.out.println("Element did not visibile - " + selector);

        }
        return false;
    }

    protected boolean invisibility(int sec, By selector) {
        webDriverWait = new WebDriverWait(wd, sec);
        try {
            webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(selector));
            return true;
        } catch (TimeoutException e) {
//            System.out.println("Element did not invisibile - " + selector);
        }
        return false;
    }

    protected boolean presence(int sec, By selector) {
        webDriverWait = new WebDriverWait(wd, sec);
        try {
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(selector));
            return true;
        } catch (TimeoutException e) {
            System.out.println("Element did not presence - " + selector);
        }
        return false;
    }

    protected boolean clickable(int sec, By selector) {
        webDriverWait = new WebDriverWait(wd, sec);
        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(selector));
            return true;
        } catch (TimeoutException e) {
            System.out.println("Element did not clickable - " + selector);
        }
        return false;
    }

    protected boolean textPresent(int sec, String text, By selector) {
        webDriverWait = new WebDriverWait(wd, sec);
        try {
            webDriverWait.until(ExpectedConditions.textToBePresentInElementValue(selector, text));
            return true;
        } catch (TimeoutException e) {
            System.out.println("Text did not present - " + text);
        }
        return false;
    }

    protected boolean attributeContains(int i, String attribute, String value, By selector) {
        webDriverWait = new WebDriverWait(wd, i);
        try {
            webDriverWait.until(ExpectedConditions.attributeContains(selector, attribute, value));
            return true;
        } catch (TimeoutException e) {
            System.out.println("This value of attribute did not present" + selector);
        }
        return false;
    }

    protected boolean attributeNotEmpty(int i, String attribute, WebElement element) {
        webDriverWait = new WebDriverWait(wd, i);
        try {
            webDriverWait.until(ExpectedConditions.attributeToBeNotEmpty(element, attribute));
            return true;
        } catch (TimeoutException e) {
            System.out.println("This attribute is empty" + element);
        }
        return false;
    }

    protected boolean textToBe(int sec, String text, By selector) {
        webDriverWait = new WebDriverWait(wd, sec);
        try {
            webDriverWait.until(ExpectedConditions.textToBe(selector, text));
            return true;
        } catch (TimeoutException e) {
            System.out.println("Text not to be - " + text);
        }
        return false;
    }

    protected boolean textMatches(int sec, String text, By selector) {
        webDriverWait = new WebDriverWait(wd, sec);
        try {
            webDriverWait.until(ExpectedConditions.textMatches(selector, Pattern.compile(text)));
            return true;
        } catch (TimeoutException e) {
            System.out.println("Text not matches - " + text);
        }
        return false;
    }

    protected boolean titleContains(int sec, String text) {
        webDriverWait = new WebDriverWait(wd, sec);
        try {
            webDriverWait.until(ExpectedConditions.titleContains(text));
            return true;
        } catch (TimeoutException e) {
            System.out.println("Title not contains - " + text);
        }
        return false;
    }

    protected boolean titleNotContains(int sec, String text) {
        webDriverWait = new WebDriverWait(wd, sec);
        try {
            webDriverWait.until(ExpectedConditions.not(ExpectedConditions.titleContains(text)));
            return true;
        } catch (TimeoutException e) {
            System.out.println("Title contains - " + text);
        }
        return false;
    }
}
