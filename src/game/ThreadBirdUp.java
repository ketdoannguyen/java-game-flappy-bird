package game;

import java.awt.Rectangle;
import javax.swing.JLabel;

public class ThreadBirdUp extends Thread {

    private JLabel label;
    private int h;
    private JLabel labelOver;

    public ThreadBirdUp() {
    }

    public ThreadBirdUp(JLabel label, int h, JLabel labelOver) {
        this.label = label;
        this.h = h;
        this.labelOver = labelOver;
    }

    public void run() {
        Rectangle r = label.getBounds();
        while (r.y > h) {
            try {
                Thread.sleep(6);
            } catch (InterruptedException ex) {
            }
            r.y = r.y - 1;
            label.setBounds(r.x, r.y, r.width, r.height);
            if (r.y == -30) {
                labelOver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/game/Image/end.png")));
                labelOver.setText(".");
            }
        }
    }
}
