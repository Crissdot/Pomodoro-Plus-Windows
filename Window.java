package pomodoroplus;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JButton;
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
        createButtons();
    }
    
    private void createCounterLabel() {
        JLabel counter = new JLabel("00:00", SwingConstants.CENTER);
        counter.setBounds(50, 50, 400, 125);
        counter.setForeground(Color.RED);
        
        Font font = new Font("arial", Font.BOLD, 150);
        counter.setFont(font);
        
        panel.add(counter);
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
    }
    
}
