package input;

import validation.SelectValidation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

    public static int select;

    public static String expression = "";
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    static SelectValidation selectValidation = new SelectValidation();


    public void select() throws IOException {
        System.out.println("1.조회");
        System.out.println("2.계산");
        select = Integer.parseInt(bufferedReader.readLine());
        System.out.println("선택 " + select);

    }

    public void expression() throws  IOException{
        expression = bufferedReader.readLine();
    }


}
