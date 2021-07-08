package pomodoroplus;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {
    
    public Window() {
        setWindow();
        startComponents();
    }
    
    private void setWindow() {
        setSize(500, 500);
        setLocationRelativeTo(null);
        setTitle("Pomodoro Plus");
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private void startComponents() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.GREEN);
        
        this.getContentPane().add(panel);
    }
    
}
