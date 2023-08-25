package validation;

public class SelectValidation {

    public boolean checkSelectValue(int select){
        if(select != 1 && select != 2){
            System.out.println("잘못된 입력값 입니다.");
            return false;
        }
        return true;
    }

}
