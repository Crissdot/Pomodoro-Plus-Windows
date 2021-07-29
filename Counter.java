package pomodoroplus;

import java.awt.Color;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class Counter {
    private static Counter counter = null;
    private final Buttons buttons;
    
    private final JLabel counterLabel;
    private final Timer timer;
    private TimerTask timerTask;
    private short minutes;
    private byte seconds;
    private boolean isFocusTime;
    
    public static Counter getInstance() {
        if(counter == null)
            counter = new Counter();
        
        return counter;
    }
    
    private Counter() {
        counterLabel = createCounterLabel();
        buttons = Buttons.getInstance();
        timer = new Timer();
        isFocusTime = true;
        setUpTime();
    }
    
    private JLabel createCounterLabel() {
        JLabel label = new JLabel("00:00", SwingConstants.CENTER);
        label.setBounds(50, 50, 400, 125);
        label.setForeground(Color.RED);
        label.setFont(new Font("arial", Font.BOLD, 150));
        
        return label;
    }

    public JLabel getCounterLabel() {
        return counterLabel;
    }
    
    private void setUpTime() {
        minutes = 0;
        seconds = 0;
        renderCounter("00:00");
    }
    
    private void makeTimerUp() {
        if(++seconds == 60) {
            minutes++;
            seconds = 0;
        }
    }
    
    private void makeTimerDown() {
        if(--seconds == -1) {
            minutes--;
            seconds = 59;
        }
        if(minutes == 0 && seconds == 0) finish();
    }
    
    private String makeTimeToString(){
        String min = String.valueOf(minutes);
        if(min.length() == 1) 
            min = "0" + min;
        String sec = String.valueOf(seconds);
        if(sec.length() == 1) 
            sec = "0" + sec;
        
        return min + ":" + sec;
    }
    
    private void renderCounter(String time) {
        this.counterLabel.setText(time);
    }
    
    public void start() {
        timerTask = new TimerTask() {
            @Override
            public void run() {
                if(isFocusTime) makeTimerUp();
                else makeTimerDown();
                String time = makeTimeToString();
                renderCounter(time);
            }
        };
        timer.scheduleAtFixedRate(timerTask, 1000, 1000);
        buttons.startToggle();
    }
    
    public void pause() {
        timerTask.cancel();
        timer.purge();
    }
    
    public void finish() {
        pause();
        if(isFocusTime) {
            if(minutes < 5) {
                JOptionPane.showMessageDialog(null, "At least 5 minutes to get rest time");
                setUpTime();
                buttons.finishToggle();
                return;
            }
            JOptionPane.showMessageDialog(null, "Time to rest");
            
            byte restTime[] = makeRestTime();
            minutes = restTime[0];
            seconds = restTime[1];
            
            String time = makeTimeToString();
            renderCounter(time);
            
            counterLabel.setForeground(Color.GREEN);
            
            start();
        } else {
            renderCounter("00:00");
            if(minutes == 0 && seconds == 0) {
                MediaPlayer.playSound("finishTime.wav");
                JOptionPane.showMessageDialog(null, "Time is up");
            }
            
            setUpTime();
            counterLabel.setForeground(Color.RED);
            
            buttons.finishToggle();
        }
        isFocusTime = !isFocusTime;
    }
    
    private byte[] makeRestTime() {
        byte restMinutes = (byte) (minutes / 5);
        byte restSeconds = (byte) (minutes % 5);
        restSeconds *= 10;
        
        byte restTime[] = new byte[2];
        restTime[0] = restMinutes;
        restTime[1] = restSeconds;
        
        return restTime;
    }
    
}
