package apiHelperExample.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Sample page
 */
public class HomePage extends Page {

  @FindBy(css = ".header-search-input")
  @CacheLookup
  public WebElement searchField;

  public HomePage(WebDriver webDriver) {
    super(webDriver);
  }

  public RepositoriesPage searchForRepositories(String value) {
    waitForElement(searchField).sendKeys(value);
    waitForElement(searchField).sendKeys(Keys.ENTER);
    return new RepositoriesPage(driver);
  }
}
