package src.main;

interface Printer {

    void print(StringBuilder stringBuilder);
    void print(String string);
    void print(Long num);
    void print(Exception e);

    default void displayMenu(){
        StringBuilder stringBuilder = new StringBuilder().append('\n');

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
