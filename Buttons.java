package pomodoroplus;

import java.awt.Font;
import javax.swing.JButton;

public class Buttons {
    private static Buttons buttons = null;
    
    private final byte left = 75;
    private final short width = 350;
    private final byte height = 50;
    
    private final JButton btnStart;
    private final JButton btnPause;
    private final JButton btnFinish;
    
    public static Buttons getInstance() {
        if(buttons == null)
            buttons = new Buttons();
        
        return buttons;
    }
    
    private Buttons() {
        btnStart = createButtons("<HTML><U>S</U>TART</HTML>", (short) 215, true, 's');
        btnPause = createButtons("<HTML><U>P</U>AUSE</HTML>", (short) 290, false, 'p');
        btnFinish = createButtons("<HTML><U>F</U>INISH</HTML>", (short) 365, false, 'f');
    }
    
    private JButton createButtons(String text, short top, boolean active, char mnenomic) {
        JButton button = new JButton(text);
        button.setBounds(left, top, width, height);
        button.setEnabled(active);
        button.setFont(new Font("arial", Font.PLAIN, 32));
        button.setMnemonic(mnenomic);
        
        return button;
    }

    public JButton getBtnStart() {
        return btnStart;
    }

    public JButton getBtnPause() {
        return btnPause;
    }

    public JButton getBtnFinish() {
        return btnFinish;
    }
    
    public void startToggle() {
        btnStart.setEnabled(false);
        btnPause.setEnabled(true);
        btnFinish.setEnabled(true);
    }
    
    public void pauseToggle() {
        btnStart.setEnabled(true);
        btnPause.setEnabled(false);
        btnFinish.setEnabled(true);
    }
    
    public void finishToggle() {
        btnStart.setEnabled(true);
        btnPause.setEnabled(false);
        btnFinish.setEnabled(false);
    }
    
}
