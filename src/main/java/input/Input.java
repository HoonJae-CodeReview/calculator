package input;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public String selectInput() throws IOException {
        String selectInput = bufferedReader.readLine();
        return selectInput;
    }

    public String expressionInput() throws  IOException {
        String expressionInput = bufferedReader.readLine();
        return expressionInput;
    }
}
