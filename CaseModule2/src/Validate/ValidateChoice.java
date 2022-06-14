package Validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateChoice {

    private static String choice_regex="[1-2]";
    private static String choicestaff_regex="[1-5]";
    private static String choiceAdmin_regex="[1-7]";
    private static String choiceGuest_regex="[1-7]";
    private static String choiceGuestSort_regex="[1-2]";
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
    public static boolean validateChoiceAdmin(String regex){
    return validate(regex,choiceAdmin_regex);
    }
    public static boolean validateChoiceGuest(String regex){
        return validate(regex,choiceGuest_regex);
    }
    public static boolean validateChoiceGuestSort(String regex){return validate(regex,choiceGuestSort_regex);}
}
