package apiHelperExample.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RepositoriesPage extends Page {
    @FindAll(@FindBy(xpath = "//a[@href]/span[contains(@class, 'search')]/em"))
    public List<WebElement> repoNames;

    public RepositoriesPage(WebDriver webDriver) {
        super(webDriver);
    }

    public LinkedList<String> getRepoListNamesFromPage() {
        LinkedList<String> repoNamesList = new LinkedList<>();

        for (WebElement repoElement : repoNames) {
            try {
                // Повторно найдите элемент перед его использованием
                WebElement refreshedElement = waitForElement(repoElement);
                repoNamesList.add(refreshedElement.getText().trim().toLowerCase());
            } catch (StaleElementReferenceException e) {
                // Обработка исключения, если необходимо
                // Можете повторно попробовать выполнить поиск элемента или выполнить другие действия
            }
        }

        return repoNamesList;
    }



}
