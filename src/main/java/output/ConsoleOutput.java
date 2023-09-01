package output;

import repository.Repository;

import java.util.List;

public class ConsoleOutput implements Output {


    public void printOperationResult(){
        List<String> result = repository.getResult();
        result.forEach(System.out::println);
    }



}
