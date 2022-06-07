package io;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateChoice {

    private static String choice_regex="[1-2]";
    private static String choicestaff_regex="[1-4]";
    public static boolean validate(String regex, String regex1) {
        Pattern pattern = Pattern.compile(regex1);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    public static boolean validatechoice(String regex){
        return validate(regex,choice_regex);
    }
    public static boolean validateChoiceStaff(String regex){
        return validate(regex,choicestaff_regex);
    }
}
