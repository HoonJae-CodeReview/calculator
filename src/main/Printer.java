package src.main;

import src.main.exception.*;

public class Printer {

    public void print(StringBuilder stringBuilder){
        System.out.print(stringBuilder);
    }
    public void print(String string){
        System.out.print(string);
    }
    public void print(Long num){
        System.out.println(num);
    }
    public void print(NumberFormatException e){
        System.out.println("[!] 올바른 숫자를 입력해주세요");
    }
    public void print(BadMenuSelectException e){
        System.out.println("[!] 제시된 메뉴를 골라주세요");
    }
    }

}
