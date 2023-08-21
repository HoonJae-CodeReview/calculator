import java.util.*;

public class Calculator {
    public void showMenu(){
        System.out.print("1. 조회\n2. 계산\n\n선택 : ");
    }
    public long calculate(String string){
        StringTokenizer stringTokenizer = new StringTokenizer(string);

        long resultValue = 0;

        long currentValue = Long.parseLong(stringTokenizer.nextToken());
        String currentSymbol = "+";

        while(stringTokenizer.hasMoreTokens()){
            String nextSymbol = stringTokenizer.nextToken();
            long nextValue = Long.parseLong(stringTokenizer.nextToken());

//            System.out.printf("%s%d  |  %d %s %d %s %d\n",nextSymbol,nextValue,resultValue,currentSymbol,currentValue,nextSymbol,nextValue);

            switch(nextSymbol){
                case "+" :
                    switch(currentSymbol){
                        case "+" : resultValue += currentValue; break;
                        case "-" : resultValue -= currentValue; break;
                    }
                    currentValue = nextValue;
                    currentSymbol = "+";
                    break;
                case "-" :
                    switch(currentSymbol){
                        case "+" : resultValue += currentValue; break;
                        case "-" : resultValue -= currentValue; break;
                    }
                    currentValue = nextValue;
                    currentSymbol = "-";
                    break;
                case "*" :
                    currentValue *= nextValue;
                    break;
                case "/" :
                    currentValue /= nextValue;
                    break;
            }
        }

        switch(currentSymbol){
            case "+" : resultValue += currentValue; break;
            case "-" : resultValue -= currentValue; break;
        }

        return resultValue;
    }
}
