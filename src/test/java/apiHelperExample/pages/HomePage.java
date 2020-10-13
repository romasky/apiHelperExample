package apiHelperExample.pages;


import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


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

  @Step("Открыта страница {baseUrl}")
  public void open(String baseUrl) {
    driver.get(baseUrl);
  }

  @Step("Ищем репозитории по ключевому слову {value}")
  public RepositoriesPage searchForRepositories(String value) {
    waitForElement(searchField).sendKeys(value);
    waitForElement(searchField).sendKeys(Keys.ENTER);
    return new RepositoriesPage(driver);
  }
}
