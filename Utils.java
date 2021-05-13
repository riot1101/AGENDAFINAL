/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CES
 */
public class Utils {

    public static String readString() {
        try {
            InputStreamReader is = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(is);
            return br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public static int readUnsignedInt() { 
        /*
        int - Integer
        float - Float
        double - Double
        char - String
        boolean - Boolean */
        int dato = 0;
        try {
            dato = Integer.parseInt(readString());
            dato = Math.abs(dato);
        } catch (Exception ex) {
            dato = -1;
        }
        return dato;
    }
}
