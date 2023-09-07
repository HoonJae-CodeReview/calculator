package src.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args){
        new CalculatorDriver(new ConsoleView()).run();
    }
}