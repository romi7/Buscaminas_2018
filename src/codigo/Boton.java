/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import javax.swing.JButton;

/**
 *
 * @author Carlos Román
 */
public class Boton extends JButton{ 
    
    int mina = 0;
     int i = 0; 
    int  j = 0;  
    int numeroMinasAlrededor = 0;

    public int getMina() {
        return mina;
    }

    public void setMina(int mina) {
        this.mina = mina;
    }

    public int getNumeroMinasAlrededor() {
        return numeroMinasAlrededor;
    }

    public void setNumeroMinasAlrededor(int numeroMinasAlrededor) {
        this.numeroMinasAlrededor = numeroMinasAlrededor;
    } 
    
    public Boton(int _i, int _j){ 
         i= _i; 
        j = _j; 
        this.setBorder(null); 
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
     
    
    
}
