package src.main;

import java.io.*;
import java.util.StringTokenizer;

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

    public String trimExpression(String expression){
        StringTokenizer stringTokenizer = new StringTokenizer(expression);
        StringBuilder stringBuilder = new StringBuilder();
        while(true){
            stringBuilder.append(stringTokenizer.nextToken());
            if (!stringTokenizer.hasMoreTokens()){
                break;
            }
            stringBuilder.append(' ');
        }
        return stringBuilder.toString();
    }

}
