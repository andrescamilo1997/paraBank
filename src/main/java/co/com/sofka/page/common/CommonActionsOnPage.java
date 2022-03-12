package co.com.sofka.page.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class CommonActionsOnPage {
    private static final Logger LOGGER = Logger.getLogger(CommonActionsOnPage.class);
    private static final String WEBDRIVER_NULL_MESSAGE = "\nWARNING!\n\rThe Webdriver is NULL, please check it.\n";
    private WebDriver driver;

    //Constructor
    public CommonActionsOnPage(WebDriver driver) {
        try{
            if(driver == null) {
                LOGGER.warn(WEBDRIVER_NULL_MESSAGE);
            }
            this.driver = driver;

        } catch (Exception e){
            LOGGER.warn(e.getMessage(), e);
        }
    }

    //Funcionalidades

    protected void clearOn(By locator){
        driver.findElement(locator).clear();
    }

    protected void clickOn(By locator){
        driver.findElement(locator).click();
    }

    protected void typeOn(By locator, CharSequence... keysToSend){
        driver.findElement(locator).sendKeys(keysToSend);
    }

    protected void scrollOn(By locator){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
    }

    protected void doSubmit(By locator){
        driver.findElement(locator).submit();
    }

    protected String getText(By locator){
        return driver.findElement(locator).getText();
    }

    protected Boolean isDisplayed(By locator){
        try{
            return driver.findElement(locator).isDisplayed();
        }catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }



}
