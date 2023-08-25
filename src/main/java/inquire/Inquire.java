package inquire;

import repository.Repository;

import java.util.List;

public class Inquire {

    Repository repository = new Repository();

    public void printResult(){
        List<String> result = repository.getResult();
        result.forEach(System.out::println);
    }

}
