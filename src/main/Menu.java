package src.main;

import java.util.Arrays;

public enum Menu {
    DISPLAY_HISTORY(1,"조회"),
    CALCULATE(2,"계산"),
    STOP(3,"종료");

    private final int value;
    private final String title;

    Menu(int value, String title) {
        this.value = value;
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }

    public static Menu findByValue(int value){
        return Arrays.stream(Menu.values())
                .filter(menu ->
                    menu.value == value
                )
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 메뉴입니다"));
    }

    public static Menu findByValue(String value){
        try{
            return findByValue(Integer.parseInt(value));
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }
}
