package io;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateComputer {
    private static String amount_regex="[0-9]+";
    private static String price_regex="[0-9]+";
    public static boolean validate(String regex, String regex1) {
        Pattern pattern = Pattern.compile(regex1);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    public static boolean validateAmount(String regex){
        return validate(regex,amount_regex);
    }
    public static boolean validatePrice(String regex){
        return validate(regex,price_regex);
    }
}
