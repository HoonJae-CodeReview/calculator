package src.main;

import java.util.StringTokenizer;

public final class ExpressionTrimmer {

    private ExpressionTrimmer() {}

    public static String trimExpression(String expression){
        StringTokenizer stringTokenizer = new StringTokenizer(expression);
        StringBuilder stringBuilder = new StringBuilder();
        while(true){
            stringBuilder.append(stringTokenizer.nextToken());
            if (!stringTokenizer.hasMoreTokens()){
                break;
            }
            stringBuilder.append(' ');
        }
        return stringBuilder.toString();
    }
}
