package validation;

public class ExpressionInputValidation {

    private final String REGEX = "^\\d+(?: \\+ \\d+| - \\d+| \\* \\d+| \\/ \\d+)*$";

    public boolean checkExpressionValue(String expression){
        if(!expression.matches(REGEX)){
            System.out.println("잘못된 형식의 식입니다.");
            return  false;
        }
        return true;
    }

}
