package src.main;

import src.main.exception.BadMenuSelectException;

import java.io.*;

public class Main{

    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    static Calculator calculator = new Calculator(bufferedReader);

    static Recorder recorder = new Recorder();

    public static void main(String[] args) throws IOException {
        while(true){
            try{
                calculator.displayMenu();

                Operation selectedOperation = calculator.MENU_ITEMS[calculator.inputMenuItemIndex()].getOperation();
                selectedOperation.run();
            }
            catch(BadMenuSelectException e){
                System.err.println(e);
            }
        }
    }
}