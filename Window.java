package pomodoroplus;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Window extends JFrame {
    private JPanel panel;
    
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
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.BLACK);
        this.getContentPane().add(panel);
        
        createCounterLabel();
    }
    
    private void createCounterLabel() {
        JLabel counter = new JLabel("00:00", SwingConstants.CENTER);
        counter.setBounds(75, 75, 350, 125);
        counter.setForeground(Color.RED);
        
        Font font = new Font("arial", Font.BOLD, 128);
        counter.setFont(font);
        
        panel.add(counter);
    }
    
}
