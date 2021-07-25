package pomodoroplus;

import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;

public class Counter {
    private final JLabel counterLabel;
    private final Timer timer;
    private TimerTask timerTask;
    private short minutes;
    private byte seconds;
    private boolean isFocusTime;
    
    
    public Counter(JLabel counterLabel) {
        this.counterLabel = counterLabel;
        timer = new Timer();
        isFocusTime = true;
        setUpTime();
    }
    
    private void setUpTime() {
        minutes = 14;
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
    }
    
    public void pause() {
        timerTask.cancel();
        timer.purge();
    }
    
    public void finish() {
        pause(); 
        if(isFocusTime) {
            byte restTime[] = makeRestTime();
            minutes = restTime[0];
            seconds = restTime[1];
            
            String time = makeTimeToString();
            renderCounter(time);
            
            counterLabel.setForeground(Color.GREEN);
        } else {
            setUpTime();
            counterLabel.setForeground(Color.RED);
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
