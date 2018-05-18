/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;

/**
 *
 * @author bea y bequi
 */
public class VentanaBuscaminas extends javax.swing.JFrame {
      
    int filas = 15; 
    int columnas = 20; 
    
    
   Boton [][] arrayBotones = new Boton[filas][columnas]; 
     
    
    
    
    
    
    
    
    
    /**
     * Creates new form VentanaBuscaminas
     */
    public VentanaBuscaminas() {
        initComponents(); 
        setSize(800, 600);
        getContentPane().setLayout(new GridLayout(filas,columnas)); 
        for(int i=0; i<filas; i++){
        for(int j=0; j<columnas; j++){ 
            Boton boton = new Boton(i,j); 
           getContentPane().add(boton);  
           arrayBotones [i][j]= boton; 
           boton.addMouseListener(new MouseAdapter(){ 
               @Override
               public void mousePressed(MouseEvent evt){
                   botonPulsado(evt);
           }
        });
        }
    }  
        ponMinas(30); 
        cuentaMinas();
    } 
    private void botonPulsado(MouseEvent e){ 
        Boton miBoton = (Boton) e.getComponent(); 
         if (e.getButton() == MouseEvent.BUTTON3){ 
             miBoton.setText("?"); 
          } else { 
                   ArrayList<Boton> Mirar = new ArrayList();
          
            Mirar.add(miBoton);
            while (Mirar.size() > 0) {
                Boton b = Mirar.get(0);
                for (int i= -1; i< 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        if ((b.i + i >= 0 )&& (b.j + j >= 0) && (b.i + i< filas) && (b.j + j< columnas)) {
                           
                            if (arrayBotones[b.i + i][b.j + j].isEnabled()) {
                                if (arrayBotones[b.i + i][b.j + j].numeroMinasAlrededor == 0) {
                                    arrayBotones[b.i + i][b.j + j].setEnabled(false);
                                  Mirar.add(arrayBotones[b.i + i][b.j + j]);
                                }
                            }
                        }
                    } 
                } 
               Mirar.remove(b); 
            } 
         if (miBoton.mina == 1) {

                for (int i = 0; i < filas; i++) {
                    for (int j = 0; j < columnas; j++) {
                        arrayBotones[i][j].setEnabled(false);
                        arrayBotones[i][j].setText(String.valueOf(arrayBotones[i][j].numeroMinasAlrededor));
                        if(arrayBotones[i][j].mina==1){
                            arrayBotones[i][j].setText("m");
                        }
                        if(arrayBotones[i][j].numeroMinasAlrededor==0){
                            arrayBotones[i][j].setText("");
                        }
                    }
                }
                

            }
            if (miBoton.numeroMinasAlrededor > 0) {

                for (int i = 0; i < filas; i++) {
                    for (int j = 0; j < columnas; j++) {
                        if (miBoton.mina!= 1) {
                            miBoton.setText(String.valueOf(miBoton.numeroMinasAlrededor));
                        }
                        
                            
                        
                    }
                }
            } else {
                miBoton.setText("");
            }
            
        }
        

    
    
                
         
    } 
    public void recursiva (Boton boton){ 
                if (boton.getNumeroMinasAlrededor() == 0) {
            boton.setEnabled(false);
            for (int k = -1; k < 2; k++) {
                for (int m = -1; m < 2; m++) {
                    if ((boton.getI() + k >= 0) && (boton.getJ() + m >= 0) && (boton.getI() + k < filas) && (boton.getJ() + m < columnas)) {
                        if (arrayBotones[boton.getI() + k][boton.getJ() + m].isEnabled()) {
                            if (arrayBotones[boton.getI() + k][boton.getJ() + m].getNumeroMinasAlrededor() == 0) {
                                arrayBotones[boton.getI() + k][boton.getJ() + m].setEnabled(false);
                                recursiva(arrayBotones[boton.getI() + k][boton.getJ() + m]);
                            } 
                          
                        }
                    }
                }
            }
        }

    
    }
    private void ponMinas (int numeroMinas){ 
         Random r = new Random(); 
        for (int i=0; i<numeroMinas; i++){ 
            int f = r.nextInt(filas); 
            int c = r.nextInt(columnas); 
             
            arrayBotones[f][c].setMina(1);
            arrayBotones[f][c].setText("m"); 
            
            
        }
    }  
    //private void recursiva (Boton boton){ 
        
    //}
    //cuentaminas es un metodo que para cada botón calcula el número de minas 
    //que tiene alrededor
    private void cuentaMinas(){  
        //TODO falta por hacer que calcule las minas en el 
        int minas = 0; 
        
        for (int i = 0; i < filas; i++) {
     for (int j = 0; j < columnas; j++) {
                //uso un bucle anidado para recorrer
                //las 8 casillas que hay alrededor
                for (int k = -1; k < 2; k++) {
                    for (int m = -1; m < 2; m++) {
                        if ((i + k >= 0) && (j + m >= 0) && (i + k < filas) && (j + m < columnas)) {
                            minas = minas + arrayBotones[i + k][j + m].mina;
                        }
                    }
                }
                arrayBotones[i][j].numeroMinasAlrededor = minas;
                minas = 0;
//                
            }
        }
      
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(VentanaBuscaminas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaBuscaminas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaBuscaminas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaBuscaminas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaBuscaminas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
