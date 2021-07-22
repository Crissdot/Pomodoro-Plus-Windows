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
        JButton btnStart = new JButton("<HTML><U>S</U>TART</HTML>");
        btnStart.setBounds(75, 215, 350, 50);
        btnStart.setFont(new Font("arial", Font.PLAIN, 32));
        btnStart.setMnemonic('s');
        panel.add(btnStart);
        
        JButton btnPause = new JButton("<HTML><U>P</U>AUSE</HTML>");
        btnPause.setBounds(75, 290, 350, 50);
        btnPause.setFont(new Font("arial", Font.PLAIN, 32));
        btnPause.setEnabled(false);
        btnPause.setMnemonic('p');
        panel.add(btnPause);
        
        JButton btnFinish = new JButton("<HTML><U>F</U>INISH</HTML>");
        btnFinish.setBounds(75, 365, 350, 50);
        btnFinish.setFont(new Font("arial", Font.PLAIN, 32));
        btnFinish.setEnabled(false);
        btnFinish.setMnemonic('f');
        panel.add(btnFinish);
        
        addButtonFunctionality(btnStart, btnPause, btnFinish);
    }
    
    private void addButtonFunctionality(JButton btnStart, JButton btnPause, JButton btnFinish) {
        Counter counter = new Counter(counterLabel);
        
        // Start
        ActionListener clickStart = (ActionEvent e) -> {
            btnStart.setEnabled(false);
            btnPause.setEnabled(true);
            btnFinish.setEnabled(true);
            
            counter.start();
        };
        btnStart.addActionListener(clickStart);
        
        // Pause
        ActionListener clickPause = (ActionEvent e) -> {
            btnStart.setEnabled(true);
            btnPause.setEnabled(false);
            btnFinish.setEnabled(true);
        };
        btnPause.addActionListener(clickPause);
        
        // Finish
        ActionListener clickFinish = (ActionEvent e) -> {
            btnStart.setEnabled(true);
            btnPause.setEnabled(false);
            btnFinish.setEnabled(false);
        };
        btnFinish.addActionListener(clickFinish);
    }
    
}
