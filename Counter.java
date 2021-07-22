package pomodoroplus;

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;

public class Counter {
    private final JLabel counterLabel;
    private final Timer timer;
    private TimerTask timerTask;
    private short minutes;
    private byte seconds;
    
    
    public Counter(JLabel counterLabel) {
        this.counterLabel = counterLabel;
        minutes = 0;
        seconds = 0;
        timer = new Timer();
    }
    
    private String makeTimer() {
        if(++seconds == 60) {
            minutes++;
            seconds = 0;
        }
        
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
                String time = makeTimer();
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
        minutes = 0;
        seconds = 0;
        renderCounter("00:00");
    }
    
}
