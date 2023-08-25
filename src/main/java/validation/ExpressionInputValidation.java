package validation;

public class ExpressionInputValidation {

    private final String REGEX = "^\\d+(?: \\+ \\d+| - \\d+| \\* \\d+| \\/ \\d+)*$";

    public boolean checkExpressionValue(String expression){
        if(!REGEX.matches(expression)){
            System.out.println("잘못된 형식의 식입니다.");
            return  false;
        }
        return true;
    }

}
