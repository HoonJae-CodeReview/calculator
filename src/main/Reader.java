package src.main;

import java.io.*;

public class Reader {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public String input(){
        try{
            return bufferedReader.readLine();
        }
        catch(IOException e){
            System.err.println(e);
            return "";
        }
    }

}
