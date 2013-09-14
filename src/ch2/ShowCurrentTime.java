package ch2;

/**
 * Created with IntelliJ IDEA.
 * User: seanh
 * Date: 9/12/13
 * Time: 10:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class ShowCurrentTime {
    public static void main(String[] args) {
        // Obtain the total milliseconds since midnight, 1970-01-01
        long totalMilliseconds = System.currentTimeMillis();

        // Obtain total seconds and calculate current second
        long totalSeconds = totalMilliseconds / 1000;
        int currentSecond = (int) (totalSeconds % 60);
        //long currentSecond = totalSeconds % 60;

        // Obtain total minutes and calculate current minute
        long totalMinutes = totalSeconds / 60;
        int currentMinute = (int) (totalMinutes % 60);
        //long currentMinute = totalMinutes % 60;

        // Obtain total hours and calculate current hour
        long totalHours = totalMinutes / 60;
        int currentHour = (int) (totalHours % 24);
        //long currentHour = totalHours % 24;

        // Display the results
        System.out.println("Current time is: " + currentHour + ":"
            + currentMinute + ":" + currentSecond + " GMT");


    }
}
