/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.util.ArrayList;


/**
 *
 * @author CES
 */
public class Vista {
    
    public static void mostrarMenu(){
        System.out.println("1. Insertar contacto");
        System.out.println("2. Borrar contacto");
        System.out.println("3. Modificar");
        System.out.println("4. Buscar");
        System.out.println("5. Listar contactos");
        System.out.println("0. Salir");
    }
    
    public static int leerOpcion(){
        int opc = Utils.readUnsignedInt();
        if(opc<0){
            System.out.println("Formato incorrecto");
        }else if (opc>5){
            System.out.println("Opción incorrecta");
        }
        return opc; 
    }
    
    public static Contacto leerContacto(){
        Contacto contacto = new Contacto();
        System.out.println("Introduce el nombre: ");
        contacto.setNombre(Utils.readString());
        System.out.println("Introduce el email");
        contacto.setEmail(Utils.readString());
        System.out.println("Introduce el telefono");
        contacto.setTelefono(Utils.readString());
        return contacto;
    }
    
    public static void showResult(boolean result){
        /*
        if (result){
            System.out.println("Operación realizada correctamente");
        }else{
            System.out.println("Ups! Algo no ha ido bien.");
        }*/
        
        System.out.println(result ? "Operación realizada correctamente" : "Ups! Algo no ha ido bien.");
    }
    
    public static void mostrarContacto(Contacto contacto){
        /*
        System.out.println("Nombre: "+contacto.getNombre());
        System.out.println("Teléfono: "+contacto.getTelefono());
        System.out.println("Email: "+contacto.getEmail());
*/
        if(contacto!=null){
            System.out.println(contacto);
        }else{
            showResult(false);
        }
    }
    
    public static void mostrarListado (ArrayList<Contacto> contactos){
        for (Contacto contacto : contactos) {
            mostrarContacto(contacto);
            System.out.println("**********");
        }
    }
    
    public static String leerTelefono(){
        System.out.println("Introduce el teléfono: ");
        String telefono = Utils.readString();
        return telefono;
    }
    
    public static void contactoNoEncontradoM(String telefono){
        System.out.println("No existe el contacto con teléfono: "+telefono);
    }
    
    public static void contactoNullM(){
        System.out.println("Objeto null");
    }
    
    public static void telefonoDuplicadoM(String telefono){
        System.out.println("Ya existe un contacto con teléfono "+telefono);
    }
    
}
