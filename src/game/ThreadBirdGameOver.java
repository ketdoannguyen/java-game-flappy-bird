package game;

import java.awt.Rectangle;
import javax.swing.JLabel;

public class ThreadBirdGameOver extends Thread {

    private JLabel label;
    public ThreadBirdGameOver() {}

    public ThreadBirdGameOver(JLabel label) {
        this.label = label;
    }

    public void run() {
        Rectangle r = label.getBounds();
        while (true) {
            if (r.y == 150) {
                while (true) {
                    try {
                        Thread.sleep(6);
                    } catch (InterruptedException ex) {}
                    r.y = r.y + 1;
                    label.setBounds(r.x, r.y, r.width, r.height);
                    if(r.y>=275){
                        break;
                    }
                }
            }
            if (r.y >= 275) {
                while (true) {
                    try {
                        Thread.sleep(6);
                    } catch (InterruptedException ex) {}
                    r.y = r.y - 1;
                    label.setBounds(r.x, r.y, r.width, r.height);
                    if(r.y==150){
                        break;
                    }
                }
            }
        }
    }
}
