package validation;

public class SelectValidation {

    private static  String REGEX  = "^[12]+$";
    public boolean checkSelectValue(String select){
        if(!select.matches(REGEX)){
            System.out.println("잘못된 입력값 입니다.");
            return false;
        }
        return true;
    }

}
