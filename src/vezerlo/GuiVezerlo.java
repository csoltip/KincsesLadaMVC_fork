package vezerlo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import modell.JatekModell;
import nezet.GuiNezet;

public class GuiVezerlo {

    private JatekModell modell;
    private GuiNezet nezet;

    public GuiVezerlo(JatekModell modell, GuiNezet nezet) {
        this.modell = modell;
        this.nezet = nezet;
        guiBeallitas();
        start();
        valasztas();
    }

    private void start() {
        nezet.megjelenit(modell.kezdes());

    }

    private void valasztas() {
        JButton gombb = nezet.getjButton1();
        gombb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int v = nezet.bekeres();
                modell.setValasztas(v);
                String s = "Kérlek válassz ládát!";
                s = v > -1 ? modell.ellenorzes() : s;
                nezet.visszajelzes(s);
            }
        });

//        modell.setValasztas(nezet.bekeres());
//        if(nezet.bekeres() == -1){
//            nezet.visszajelzes("Kérlek válassz ládát!");
//        }else{
//            modell.setValasztas(nezet.bekeres());
//            nezet.visszajelzes(modell.ellenorzes());
//        }
    }

    private void guiBeallitas() {
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
            java.util.logging.Logger.getLogger(GuiNezet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuiNezet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuiNezet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuiNezet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                nezet.setVisible(true);
            }
        });
    }

}