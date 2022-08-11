import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import javax.swing.Timer;

public class Lab05_LEDWordClock {

    private JPanel ClockPanel;
    private JLabel IT_IS;
    private JLabel QUARTER;
    private JLabel MINUTE_FIVE;
    private JLabel PAST;
    private JLabel ONE;
    private JLabel SIX;
    private JLabel NINE;
    private JLabel TWELVE;
    private JLabel OCLOCK;
    private JLabel HOUR_TEN;
    private JLabel SEVEN;
    private JLabel FOUR;
    private JLabel TWO;
    private JLabel MINUTES;
    private JLabel HALF;
    private JLabel MINUTE_TEN;
    private JLabel TWENTY;
    private JLabel TO;
    private JLabel THREE;
    private JLabel HOUR_FIVE;
    private JLabel EIGHT;
    private JLabel ELEVEN;
    private JLabel MINUTE_ONE;
    private JLabel MINUTE_TWO;
    private JLabel MINUTE_THREE;
    private JLabel MINUTE_FOUR;

    //test stuff
    private static JMenu fileMenu;
    private static JMenuItem test;

    Color highlight = new Color(220,220,220);
    Color off = new Color(100, 100 ,100);

    Lab05_LEDWordClock(){
        Timer clock = new Timer(1000, evt -> clockActionPerformed());

        IT_IS.setForeground(highlight);
        OCLOCK.setForeground(highlight);

        clockActionPerformed();
        clock.start();
       }

    public void clockActionPerformed(){
        LocalTime time = LocalTime.now();
        int hour = time.getHour() % 12;
        int minute = time.getMinute();

        resetLabels();

        if (minute > 1 && minute <= 30) {
            minuteHandler(minute);
            PAST.setForeground(highlight);
        }
        else if (minute > 30){
            hour++;
            hour = hour % 12;
            minute = -1 * (minute - 60);
            minuteHandler(minute);
            TO.setForeground(highlight);
        }
        else {
            PAST.setForeground(off);
            TO.setForeground(off);
        }

        switch (hour) {
            case 0 -> TWELVE.setForeground(highlight);
            case 1 -> ONE.setForeground(highlight);
            case 2 -> TWO.setForeground(highlight);
            case 3 -> THREE.setForeground(highlight);
            case 4 -> FOUR.setForeground(highlight);
            case 5 -> HOUR_FIVE.setForeground(highlight);
            case 6 -> SIX.setForeground(highlight);
            case 7 -> SEVEN.setForeground(highlight);
            case 8 -> EIGHT.setForeground(highlight);
            case 9 -> NINE.setForeground(highlight);
            case 10 -> HOUR_TEN.setForeground(highlight);
            case 11 -> ELEVEN.setForeground(highlight);
            default -> {
            }
        }
    }

    public void resetLabels() {
        HALF.setForeground(off);
        MINUTE_TEN.setForeground(off);
        QUARTER.setForeground(off);
        TWENTY.setForeground(off);
        MINUTE_FIVE.setForeground(off);
        MINUTES.setForeground(off);
        TO.setForeground(off);
        PAST.setForeground(off);
        TWO.setForeground(off);
        THREE.setForeground(off);
        ONE.setForeground(off);
        FOUR.setForeground(off);
        HOUR_FIVE.setBackground(off);
        SIX.setForeground(off);
        SEVEN.setForeground(off);
        EIGHT.setForeground(off);
        NINE.setForeground(off);
        HOUR_TEN.setForeground(off);
        ELEVEN.setForeground(off);
        TWELVE.setForeground(off);
        MINUTE_ONE.setForeground(off);
        MINUTE_TWO.setForeground(off);
        MINUTE_THREE.setForeground(off);
        MINUTE_FOUR.setForeground(off);
        MINUTE_ONE.setBackground(off);
        MINUTE_TWO.setBackground(off);
        MINUTE_THREE.setBackground(off);
        MINUTE_FOUR.setBackground(off);
    }

    public void minuteHandler(int minute) {
        if (minute < 5) {
            MINUTES.setForeground(highlight);
            minutesRemainder(minute);
        }
        else if (minute < 10) {
            MINUTE_FIVE.setForeground(highlight);
            MINUTES.setForeground(highlight);
            int rMin = minute - 5;
            minutesRemainder(rMin);
        }
        else if (minute < 15) {
            MINUTE_TEN.setForeground(highlight);
            MINUTES.setForeground(highlight);
            int rMin = minute - 10;
            minutesRemainder(rMin);
        }
        else if (minute < 20) {
            QUARTER.setForeground(highlight);
            int rMin = minute - 15;
            minutesRemainder(rMin);
        }
        else if (minute < 25) {
            TWENTY.setForeground(highlight);
            MINUTES.setForeground(highlight);
            int rMin = minute - 20;
            minutesRemainder(rMin);
        }
        else if (minute < 30) {
            TWENTY.setForeground(highlight);
            MINUTE_FIVE.setForeground(highlight);
            int rMin = minute - 25;
            minutesRemainder(rMin);
        }
        else {
            HALF.setForeground(highlight);
        }
    }

    public void minutesRemainder(int minute) {
        if (minute >= 1){
            MINUTE_ONE.setForeground(highlight);
            MINUTE_ONE.setBackground(highlight);
        }
        if(minute >= 2){
            MINUTE_TWO.setForeground(highlight);
            MINUTE_TWO.setBackground(highlight);
        }
        if(minute >= 3){
            MINUTE_THREE.setForeground(highlight);
            MINUTE_THREE.setBackground(highlight);
        }
        if(minute == 4){
            MINUTE_FOUR.setForeground(highlight);
            MINUTE_FOUR.setBackground(highlight);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("LED Word Clock");

        JMenuBar menu = new JMenuBar();
        frame.setJMenuBar(menu);
        fileMenu = new JMenu("File");
        menu.add(fileMenu);


        frame.setContentPane(new Lab05_LEDWordClock().ClockPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
