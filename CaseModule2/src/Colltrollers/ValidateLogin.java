package Colltrollers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateLogin {
    private static final String account_regex="[a-zA-Z0-9]{4,}";
    private static final String password_regex="[a-zA-Z0-9]{6,}";
    private static final String name_regex="[a-zA-z]+";
    private static final String phoneNumber_regex="^0[1-9][0-9]{8}";

    public static boolean validate(String regex, String regex1) {
        Pattern pattern = Pattern.compile(regex1);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    public static boolean valiDateAccount(String regex){
        return validate(regex,account_regex);
    }
    public static boolean valiDatePassword(String regex){
        return validate(regex,password_regex);
    }
    public static boolean valiDateName(String regex){
        return validate(regex,name_regex);
    }
    public static boolean valiDatePhoneNumber(String regex){
        return validate(regex,phoneNumber_regex);
    }
}
