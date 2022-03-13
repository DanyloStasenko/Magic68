import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

/**
 * Analyzing every day: since 01-01-1900 to 30-11-2024 (~125 years)
 * Checking sum of numbers to detect how often we can see 68. (magic number)
 */
public class NumbersApp {

    private static final String DATE_PATTERN = "dd-MM-yyyy";
    private static final String START_DATE = "01-01-1900";
    private static final int YEARS_TO_ANALYZE = 125;
    
    public static void main(String[] args) throws ParseException {
        HashMap<Integer, Integer> sumToCountMap = new HashMap<>();
        List<String> list68 = new ArrayList<>();
        List<String> list32 = new ArrayList<>();
        List<String> listBoth68And32 = new ArrayList<>();
        
        String date = START_DATE;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_PATTERN);
        
        for (int i = 0; i < 365 * YEARS_TO_ANALYZE; i++){       // 365 * 125 = 45 625 days.
            String dayString = date.substring(0, 2);
            int day = Integer.parseInt(dayString);
//            System.out.println("dayString: [" + dayString + "] " + "day: " + day);

            String monthString = date.substring(3, 5);
            int month = Integer.parseInt(monthString);
//            System.out.println("monthString: [" + monthString + "] " + "month: " + month);

            String yearPart1String = date.substring(6, 8);
            int yearPart1 = Integer.parseInt(yearPart1String);
//            System.out.println("yearPart1: [" + yearPart1String + "] " + "yearPart1: " + yearPart1);

            String yearPart2String = date.substring(8, 10);
            int yearPart2 = Integer.parseInt(yearPart2String);
//            System.out.println("yearPart2: [" + yearPart2String + "] " + "yearPart2: " + yearPart2);

            int sum = day + month + yearPart1 + yearPart2;
            System.out.println("Date: " + date + " Sum: " + sum);
            
            
            // Algorithm #2: "one-by-one"
            // Example: 14-11-2024 = 1+4+1+1+2+0+2+4
            String day1String = date.substring(0, 1);
            int day1 = Integer.parseInt(day1String);
            System.out.println("day1String: [" + day1String + "] " + "day1: " + day1);

            String day2String = date.substring(1, 2);
            int day2 = Integer.parseInt(day2String);
            System.out.println("day2String: [" + day2String + "] " + "day2: " + day2);

            
            String mo1String = date.substring(3, 4);
            int mo1 = Integer.parseInt(mo1String);
            System.out.println("mo1String: [" + mo1String + "] " + "mo1: " + mo1);

            String mo2String = date.substring(4, 5);
            int mo2 = Integer.parseInt(mo2String);
            System.out.println("mo2String: [" + mo2String + "] " + "mo2: " + mo2);
            
            
            String year1String = date.substring(6, 7);
            int year1 = Integer.parseInt(year1String);
            System.out.println("year1String: [" + year1String + "] " + "year1: " + year1);

            String year2String = date.substring(7, 8);
            int year2 = Integer.parseInt(year2String);
            System.out.println("year2String: [" + year2String + "] " + "year2: " + year2);

            String year3String = date.substring(8, 9);
            int year3 = Integer.parseInt(year3String);
            System.out.println("year3String: [" + year3String + "] " + "year3: " + year3);

            String year4String = date.substring(9, 10);
            int year4 = Integer.parseInt(year4String);
            System.out.println("year4String: [" + year4String + "] " + "year4: " + year4);
            
            int sumOnyByOne = day1 + day2 + mo1 + mo2 + year1 + year2 + year3 + year4;
            System.out.println("sumOnyByOne: " + sumOnyByOne);
            
            if (sumToCountMap.containsKey(sum)){
                int count = sumToCountMap.get(sum);
                count++;
                sumToCountMap.put(sum, count);
            } else {
                sumToCountMap.put(sum, 1);
            }
            
            if (sum == 68){
                list68.add(date);
            }
            
            if (sumOnyByOne == 32){
                list32.add(date);
            }

            if (sum == 68 && sumOnyByOne == 32){
                listBoth68And32.add(date);
            }

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(simpleDateFormat.parse(date));
            calendar.add(Calendar.DATE, 1);  // number of days to add
            date = simpleDateFormat.format(calendar.getTime());  // date is now the new date
        }
        
        System.out.println("sumToCountMap size: " + sumToCountMap.size());
        System.out.println("sumToCountMap keySet: " + sumToCountMap.keySet());

        for (int key : sumToCountMap.keySet()) {
            int count = sumToCountMap.get(key);
            System.out.println("for sum: " + key + " count = " + count);
        }

        System.out.println("size of list68: " + list68.size() + " : " + list68);
        System.out.println("size of list32: " + list32.size() + " : " + list32);
        System.out.println("size of listBoth68And32: " + listBoth68And32.size() + " : " + listBoth68And32);
    }
}
