package src.main;

import java.io.*;

public class Main{

    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    static Calculator calculator = new Calculator(bufferedReader);

    public static void main(String[] args) throws IOException {
        while(true){
            calculator.run();
        }
    }
}