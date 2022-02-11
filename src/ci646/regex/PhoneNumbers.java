package ci646.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class PhoneNumbers {

    // NB: backslashes are already "special" in java strings, so they need to be escaped twice in
    // regexes. Thus, the regex '\d' becomes '\\d' in Java. See
    // http://docs.oracle.com/javase/tutorial/essential/regex/ for details.

    private static final String regex = "^(((\\(01\\d{3}\\))|01\\d{3}\\s)\\d{6})$"
                                        + "|^((\\+\\d[4,2])\\d{10})$"; 
                                        
    private static final String prompt = "Enter a phone number or press return to end: ";

    public static void main(String[] args) {
        System.out.print(prompt);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String phoneNumber;
        try {
            phoneNumber = bufferedReader.readLine().trim();
            while(!phoneNumber.equals("")) {
                if(phoneNumber.matches(regex)) {
                    System.out.printf("%s is a valid UK landline number.\n", phoneNumber);
                } else {
                    System.out.printf("%s is not a valid UK landline number.\n", phoneNumber);
                }
                System.out.print(prompt);
                phoneNumber = bufferedReader.readLine().trim();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
