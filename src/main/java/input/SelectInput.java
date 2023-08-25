package input;

import validation.SelectValidation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SelectInput implements Input{

    int select;
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public Integer input() throws  IOException{
        System.out.println("1.조회");
        System.out.printf("2.계산 \n\n");
        System.out.print("선택: ");
        select = Integer.parseInt(bufferedReader.readLine());
        System.out.println();
        return select;
    }




}
