package pomodoroplus;

import javax.swing.JFrame;

public class Window extends JFrame {
    
    public Window() {
        setWindow();
    }
    
    private void setWindow() {
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Pomodoro Plus");
    }
    
}
