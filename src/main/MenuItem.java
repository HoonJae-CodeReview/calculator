package src.main;

public class MenuItem {
    String title;
    Operation operation;

    public MenuItem(String title, Operation operation) {
        this.title = title;
        this.operation = operation;
    }

    public String getTitle(){
        return this.title;
    }

    public Operation getOperation(){
        return this.operation;
    }
}