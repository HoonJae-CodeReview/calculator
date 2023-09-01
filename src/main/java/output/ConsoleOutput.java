package output;

import repository.Repository;

import java.util.List;

public class ConsoleOutput implements Output {

    @Override
    public void printOperationResult(){
        List<String> result = repository.getResult();
        result.forEach(System.out::println);
    }

    @Override
    public void print(String msg) {

    }


}
