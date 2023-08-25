package src.main;

import src.main.exception.BadMenuSelectException;

public class MenuSelector {

    MenuItem[] menuItems;
    Reader reader;
    Printer printer;

    public MenuSelector(MenuItem[] menuItems, Reader reader, Printer printer){
        this.menuItems = menuItems;
        this.reader = reader;
        this.printer = printer;
    }

    public void displayMenu(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('\n');

        int menuItemCnt = menuItems.length;
        for(int i=0; i<menuItemCnt; i++){
            String title = menuItems[i].getTitle();
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(title);
            stringBuilder.append('\n');
        }
        stringBuilder.append("\n선택 : ");

        printer.print(stringBuilder);
    }

    public void selectMenu() throws BadMenuSelectException, NumberFormatException {
        String inputString = reader.input();
        int selectedMenuItemIndex = getIntValue(inputString) - 1;

        if(selectedMenuItemIndex < 0 || selectedMenuItemIndex >= menuItems.length){
            throw new BadMenuSelectException();
        }

        this.runMenuItem(selectedMenuItemIndex);
    }

    private void runMenuItem(int menuItemIndex){
        MenuItem selectedMenuItem = menuItems[menuItemIndex];
        Operation selectedOperation = selectedMenuItem.getOperation();
        selectedOperation.run();
    }

    private int getIntValue(String string){
        try{
            return Integer.parseInt(string);
        }
        catch (NumberFormatException e){
            throw new BadMenuSelectException();
        }
    }

}
