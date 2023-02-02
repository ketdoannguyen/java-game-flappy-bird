package game;

import java.awt.Rectangle;
import java.util.Random;
import javax.swing.JLabel;

public class FlappyBird extends javax.swing.JFrame {

    private ThreadBirdDown threadDown;
    private ThreadBirdUp threadUp;
    private ThreadBirdGameOver threadEnd;
    public FlappyBird() {
        initComponents();
        threadUp = new ThreadBirdUp(jLabelBird, 0, jLabelGameOver);
        threadDown = new ThreadBirdDown(jLabelBird, jLabelGameOver);
        a();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelBird = new javax.swing.JLabel();
        jLabelGameOver = new javax.swing.JLabel();
        jLabelGoal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FlappyBird");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setLayout(null);

        jLabelBird.setIcon(new javax.swing.ImageIcon(getClass().getResource("/game/Image/birdd.png"))); // NOI18N
        jPanel1.add(jLabelBird);
        jLabelBird.setBounds(50, 40, 50, 60);

        jLabelGameOver.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(jLabelGameOver);
        jLabelGameOver.setBounds(0, 60, 680, 180);

        jLabelGoal.setFont(new java.awt.Font("VNI-Meli", 0, 24)); // NOI18N
        jLabelGoal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelGoal.setText("0");
        jPanel1.add(jLabelGoal);
        jLabelGoal.setBounds(510, 280, 160, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(694, 362));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        if (kiemtraEnd == 0) {
            threadUp.stop();
            threadDown.stop();
            if (evt.getKeyCode() == 32) {
                kiemtra = 1;
                Rectangle r = jLabelBird.getBounds();
                threadUp = new ThreadBirdUp(jLabelBird, r.y - 40, jLabelGameOver);
                threadUp.start();
                threadDown = new ThreadBirdDown(jLabelBird, jLabelGameOver);
                threadDown.start();
            }
        }
    }//GEN-LAST:event_formKeyReleased

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        threadDown = new ThreadBirdDown(jLabelBird, jLabelGameOver);
        threadDown.start();
        Thread thread1 = new Thread() {
            public void run() {
                while (true) {
                    int goal = Integer.parseInt(jLabelGoal.getText());
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException ex) {
                    }
                    jLabelGoal.setText(goal + 1 + "");
                    if (jLabelGameOver.getText().equals(".")) {
                        break;
                    }
                }
            }
        };
        thread1.start();
    }//GEN-LAST:event_formWindowOpened
    int kiemtra = 0;
    int kiemtraEnd = 0;
    public void a() {
        Thread thread = new Thread() {
            public void run() {
                while (true) {
                    if (jLabelGameOver.getText().equals(".") && kiemtraEnd <= 4) {
                        threadEnd = new ThreadBirdGameOver(jLabelBird);
                        threadEnd.start();
                        jLabelGameOver.setText("");
                        kiemtraEnd++;
                    }
                    Thread thread1 = new Thread() {
                        public void run() {
                            JLabel label1 = new javax.swing.JLabel();
                            JLabel label2 = new javax.swing.JLabel();
                            label1.setOpaque(true);
                            label2.setOpaque(true);
                            label1.setBackground(new java.awt.Color(153, 204, 255));
                            label2.setBackground(new java.awt.Color(153, 204, 255));
                            label1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
                            label1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/game/Image/vatcan.png")));
                            label1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
                            label2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                            label2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/game/Image/tru2.png")));
                            label2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
                            Random rd = new Random();
                            int random = 30 + rd.nextInt(170);
                            label1.setBounds(680, 325 - random, 45, random);
                            label2.setBounds(680, 0, 45, 225 - random);
                            jPanel1.add(label1);
                            jPanel1.add(label2);
                            Rectangle r1 = label1.getBounds();
                            Rectangle r2 = label2.getBounds();
                            int kiemtraa = 0;
                            while (r1.x > -50 && r2.x > -50) {
                                try {
                                    Thread.sleep(6);
                                } catch (InterruptedException ex) {
                                }
                                r1.x = r1.x - 1;
                                r2.x = r2.x - 1;
                                label1.setBounds(r1.x, r1.y, r1.width, r1.height);
                                label2.setBounds(r2.x, r2.y, r2.width, r2.height);
                                if (r1.x < 120 && kiemtraa == 0 && jLabelGameOver.getText().equals("")) {
                                    kiemtraa = 1;
                                    Thread threadd = new Thread() {
                                        public void run() {
                                            while (true) {
                                                try {
                                                    Thread.sleep(50);
                                                } catch (InterruptedException ex) {
                                                }
                                                Rectangle rd = label1.getBounds();
                                                Rectangle rx = label2.getBounds();
                                                Rectangle bird = jLabelBird.getBounds();
                                                Rectangle rtgbird = new Rectangle(bird.x + 5, bird.y + 25, bird.width - 10, 25);
                                                if (rd.intersects(rtgbird) || rx.intersects(rtgbird)) {
                                                    jLabelGameOver.setText(".");
                                                    jLabelGameOver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/game/Image/end.png")));
                                                    break;
                                                }
                                                if (r1.x < 0) {
                                                    break;
                                                }

                                            }
                                        }
                                    };
                                    threadd.start();
                                }
                            }
                            jPanel1.remove(label1);
                            jPanel1.remove(label2);                         
                        }
                    };
                    thread1.start();
                    try {
                        Thread.sleep(1400);
                    } catch (InterruptedException ex) {
                    }
                }
            }
        };
        thread.start();
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FlappyBird.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FlappyBird.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FlappyBird.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FlappyBird.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FlappyBird().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelBird;
    private javax.swing.JLabel jLabelGameOver;
    private javax.swing.JLabel jLabelGoal;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
