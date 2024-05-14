
package DNS_Nexus_Management_System;

import javax.swing.*;
import java.awt.*;

public class Main_Window extends JFrame implements Runnable {
    
    Thread t;
    Main_Window () {
        super("DNS Nexus:DNS Management System - Version 1.00");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/splash.png"));
        Image i2 = i1.getImage().getScaledInstance(1000, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        
        
        
        t = new Thread(this);
        t.start();
        
        setVisible(true);
        
        int x = 1;
        
           for (int i = 2; i <= 550; i += 4, x += 1) {
           setLocation(550 - ((i + x) / 2), 320 - (i / 2));
           setSize(i + 3 * x - 10, i + x / 2 - 5); // Adjust the subtraction values as needed

            
            try {
                Thread.sleep(10);
            } catch (Exception e) {}
        }        
    }
    
    public void run() {
        try {
            Thread.sleep(6000);
            setVisible(false);
            
            // Next Frame
            new Login().setVisible(true);
        } catch (Exception e) {
            
        }
    }
    
    public static void main(String[] args) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
              /*  if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break; */
              
              UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
                
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        new Main_Window();
    }
}

