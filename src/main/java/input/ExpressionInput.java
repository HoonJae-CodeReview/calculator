package input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExpressionInput implements Input<String>{

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public String input() throws IOException {
        String expression = bufferedReader.readLine();
        return expression;

    }
}
