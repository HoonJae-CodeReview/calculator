import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import repository.Repository;

public class RepositoryTest {

  private Repository repository;


  @ParameterizedTest
  @CsvSource(value = {"2 + 3, 5 : 4 * 5, 20", "10 / 2 : 5"}, delimiter = ':')
  public void testStoreAndGetResult(String expression, String result) {
    repository = new Repository();
    repository.store(expression, result);
    List<String> actuallyResult = repository.getResult();

    Assertions.assertEquals(result, actuallyResult.get(0));
  }

}

