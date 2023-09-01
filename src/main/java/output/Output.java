package output;

import repository.Repository;

import java.util.List;

public class Output {

    private Repository repository = new Repository();

    public void printResult(){
        List<String> result = repository.getResult();
        result.forEach(System.out::println);
    }

}
