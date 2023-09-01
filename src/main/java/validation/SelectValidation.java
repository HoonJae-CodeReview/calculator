package validation;

import output.ConsoleOutput;
import output.Output;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SelectValidation {

    private final Output output = new ConsoleOutput();
    private final Pattern REGEX  = Pattern.compile("^[12]+$");
    public boolean checkSelectValue(String select){
        Matcher matcher = REGEX.matcher(select);
        if (!matcher.matches()){
            output.print("잘못된 입력값 입니다.");
            return false;
        }
        return true;
    }

}
