/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prati_sgcq.util;

import javax.swing.JOptionPane;
import prati_sgcq.view.dashboard;
import prati_sgcq.view.progress;

/**
 *
 * @author rafael
 */
public class AbreSistema {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                progress progress = new progress();
                dashboard dashboard = new dashboard();
                progress.setVisible(true);
                new Thread() {
                    @Override
                    public void run() {
                        Thread dashboardScreen = new Thread(dashboard);
                        dashboardScreen.start();

                        synchronized (dashboardScreen) {
                            try {
                                System.out.println("Aguardando o b completar...");
                                dashboardScreen.join();
                            } catch (InterruptedException e) {
                              JOptionPane.showMessageDialog(null, e.toString());  
                            }
                            System.out.println("ok");
                            progress.dispose();
                        }

                    }
                }.start();

            }
        });

    }
}
