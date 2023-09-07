package src.main;

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
    public void print(Exception e){
        System.out.println("[!] "+e.getMessage());
    }

}
