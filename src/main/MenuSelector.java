package src.main;

import src.main.exception.BadMenuSelectException;

import java.util.regex.Pattern;

public class MenuSelector {

    MenuItem[] menuItems;
    Printer printer;

    public MenuSelector(MenuItem[] menuItems, Printer printer){
        this.menuItems = menuItems;
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

    public int inputMenuItemIndex(String inputString) throws BadMenuSelectException {
        if(!Pattern.matches("\\d+", inputString)){
            throw new BadMenuSelectException("숫자가 아닙니다");
        }

        int selectedMenuIndex = Integer.parseInt(inputString) - 1;
        if(selectedMenuIndex < 0 || selectedMenuIndex >= menuItems.length){
            throw new BadMenuSelectException("해당하는 항목이 없습니다");
        }

        return selectedMenuIndex;
    }
}
