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

    public void displayMenu(){
        StringBuilder stringBuilder = new StringBuilder();

        Menu[] menus = Menu.values();

        int index = 1;
        for(Menu menu : menus){
            stringBuilder.append(index++);
            stringBuilder.append(". ");
            stringBuilder.append(menu.getTitle());
            stringBuilder.append('\n');
        }
        stringBuilder.append("\n선택 : ");
        print(stringBuilder);
    }

}
