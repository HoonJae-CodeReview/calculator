import java.util.LinkedHashMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import repository.Repository;

public class RepositoryTest {
  private Repository repository;


  @ParameterizedTest
  @CsvSource({"2 + 3, 5", "4 * 5, 20", "10 / 2, 5"})
  public void testStoreAndGetResult(String expression, String result) {
    repository = new Repository();
    repository.store(expression, result);
    LinkedHashMap<String, String> resultMap = repository.getResult();

    Assertions.assertEquals(result, resultMap.get(expression));
  }

}

