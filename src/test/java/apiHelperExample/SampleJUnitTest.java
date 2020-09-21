package apiHelperExample;

import apiHelperExample.pages.HomePage;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
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

        Repos repos = given().log().everything()
                .contentType(ContentType.JSON)
                .queryParam("q", searchQuery)
                .when().get()
                .then().log().everything()
                .extract().as(Repos.class);

        LinkedList<String> repoNames = repos.getItems()
                .stream()
                .map(RepoItem::getFullName)
                .collect(Collectors.toCollection(LinkedList::new));

        assertThat(actualRepositoriesList.toArray(), arrayContainingInAnyOrder(repoNames.toArray()));
    }
}
