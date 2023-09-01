package src.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static Reader bufferedReader = new Reader(){
        private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        public String input(){
            try{
                return this.bufferedReader.readLine();
            }
            catch(IOException e){
                System.err.println(e);
                return "";
            }
        }
    };

    static Printer standardPrinter = new Printer(){
        public void print(StringBuilder stringBuilder){
            System.out.print(stringBuilder);
        }
        public void print(String string){
            System.out.print(string);
        }
        public void print(Long num){
            System.out.println(num);
        }
        public void print(Exception e){
            System.out.println("[!] "+e.getMessage());
        }
    };

    public static void main(String[] args){
        new CalculatorDriver(bufferedReader, standardPrinter).run();
    }
}