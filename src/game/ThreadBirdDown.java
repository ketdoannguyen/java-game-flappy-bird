package game;

import java.awt.Rectangle;
import javax.swing.JLabel;

public class ThreadBirdDown extends Thread {

    private JLabel label;
    private JLabel labelOver;

    public ThreadBirdDown() {}

    public ThreadBirdDown(JLabel label, JLabel labelOver) {
        this.label = label;
        this.labelOver = labelOver;
    }

    public void run() {
        try {
            Thread.sleep(380);
        } catch (InterruptedException ex) {}
        Rectangle r = label.getBounds();
        while (r.y < 275) {
            try {
                Thread.sleep(8);
            } catch (InterruptedException ex) {}
            r.y = r.y + 1;
            label.setBounds(r.x, r.y, r.width, r.height);
        }
        if (r.y == 275) {
            labelOver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/game/Image/end.png")));
            labelOver.setText(".");
        }
    }
}
