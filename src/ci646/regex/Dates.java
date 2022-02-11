package ci646.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Dates {

    // NB: backslashes are already "special" in java strings, so they need to be escaped twice in
    // regexes. Thus, the regex '\d' becomes '\\d' in Java. See
    // http://docs.oracle.com/javase/tutorial/essential/regex/ for details.
    private static final String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private static final String month = "([0-1][0-9])|(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)";
    private static final String day = "[0-3][0-9]";
    private static final String dateRegex = "^(((("+day+")-("+month+"))|(("+month+")-("+day+")))-(\\d{4}))$"; 
    private static final String prompt = "Enter a date or press return to end: ";

    public static void main(String[] args) {
        System.out.print(prompt);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String date;
        try {
            date = bufferedReader.readLine().trim();
            while(!date.equals("")) {
                if(date.matches(dateRegex)) {
                    String[] parts = date.split("-");
                    int year = Integer.parseInt(parts[2]);
                    if(year <= 2022){
                        try{
                            int start = Integer.parseInt(parts[0]);
                            int middle = Integer.parseInt(parts[1]);
                            if(start > 12){
                                System.out.printf("%s is a valid UK date.\n", date);
                            }else if(middle > 12){
                                System.out.printf("%s is a valid US date.\n", date);
                            }else{
                                System.out.printf("%s is a Valid date in the form xx/xx/xxxx.\n", date);
                            }
                        }catch(final NumberFormatException e){
                            for(String m : months){
                                if(parts[1].equals(m)){
                                    System.out.printf("%s is a valid UK date.\n", date);
                                }else if(parts[0].equals(m)){
                                    System.out.printf("%s is a valid US date.\n", date);
                                }
                            }
                        }
                    }else{
                        System.out.printf("%s is not a valid date.\n", date);
                    }
                } else { // add more cases here
                    System.out.printf("%s is not a valid date.\n", date);
                }
                System.out.print(prompt);
                date = bufferedReader.readLine().trim();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
