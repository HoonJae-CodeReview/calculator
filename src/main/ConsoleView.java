package src.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleView extends View {

    private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public String input(){
        try{
            return this.bufferedReader.readLine();
        }
        catch(IOException e){
            System.err.println(e);
            return "";
        }
    }

    @Override
    public void print(StringBuilder stringBuilder){
        System.out.print(stringBuilder);
    }

    @Override
    public void print(String string){
        System.out.print(string);
    }

    @Override
    public void print(Long num){
        System.out.println(num);
    }

    @Override
    public void print(Exception e){
        System.out.println("[!] "+e.getMessage());
    }

}
