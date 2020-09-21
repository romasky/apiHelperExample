package apiHelperExample;

import apiHelperExample.pages.HomePage;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SampleJUnitTest extends JUnitTestBase {

    private HomePage homepage;

    @Test
    public void testRepositoriesListSearch() {
        String searchQuery = "healenium";
        homepage = new HomePage(driver);
        driver.get(baseUrl);
        List<String> actualRepositoriesList = homepage.searchForRepositories(searchQuery)
                .getRepoListNamesFromPage();
        assertTrue(actualRepositoriesList.stream().allMatch(item -> item.contains(searchQuery)),
                String.format("List Elements: [%s] does not contains text [%s] ", actualRepositoriesList, searchQuery));
    }
}
