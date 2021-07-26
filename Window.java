package pomodoroplus;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Window extends JFrame {
    private JPanel panel;
    private JLabel counterLabel;
    private Buttons buttons;
    
    public Window() {
        setWindow();
        startComponents();
    }
    
    private void setWindow() {
        setSize(500, 500);
        setResizable(false);
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
        createButtons();
    }
    
    private void createCounterLabel() {
        counterLabel = new JLabel("00:00", SwingConstants.CENTER);
        counterLabel.setBounds(50, 50, 400, 125);
        counterLabel.setForeground(Color.RED);
        
        Font font = new Font("arial", Font.BOLD, 150);
        counterLabel.setFont(font);
        
        panel.add(counterLabel);
    }
    
    private void createButtons() {
        buttons = new Buttons();
        
        JButton btnStart = buttons.getBtnStart();
        JButton btnPause = buttons.getBtnPause();
        JButton btnFinish = buttons.getBtnFinish();
        
        panel.add(btnStart);
        panel.add(btnPause);
        panel.add(btnFinish);
        
        addButtonFunctionality(btnStart, btnPause, btnFinish);
    }
    
    private void addButtonFunctionality(JButton btnStart, JButton btnPause, JButton btnFinish) {
        Counter counter = new Counter(counterLabel);
        
        // Start
        ActionListener clickStart = (ActionEvent e) -> {
            buttons.startToggle();
            counter.start();
        };
        btnStart.addActionListener(clickStart);
        
        // Pause
        ActionListener clickPause = (ActionEvent e) -> {
            buttons.pauseToggle();
            counter.pause();
        };
        btnPause.addActionListener(clickPause);
        
        // Finish
        ActionListener clickFinish = (ActionEvent e) -> {
            buttons.finishToggle();
            counter.finish();
        };
        btnFinish.addActionListener(clickFinish);
    }
    
}
