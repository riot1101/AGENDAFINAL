/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import agenda.exceptions.ContactNotFoundException;
import agenda.exceptions.ContactNullException;
import agenda.exceptions.PhoneDuplicatedException;
import java.util.ArrayList;

/**
 *
 * @author CES
 */
public class Controlador {

    public void run() {
        Agenda agenda = new Agenda();
        Contacto contacto = new Contacto();
        int opc = 0;
        do {
            Vista.mostrarMenu();
            opc = Vista.leerOpcion();
            try {
                switch (opc) {
                    case 1: //insertar un contacto
                        contacto = Vista.leerContacto();
                        boolean result = agenda.insertarContacto(contacto);
                        Vista.showResult(result);
                        break;
                    case 2:
                        String telf = Vista.leerTelefono();
                        contacto = agenda.borrarContacto(telf);
                        Vista.mostrarContacto(contacto);
                        break;
                    case 3:
                        String telefono = Vista.leerTelefono();
                        contacto = Vista.leerContacto();
                        Vista.showResult(agenda.modificarContacto(contacto, telefono));
                        break;
                    case 4:
                        Vista.mostrarContacto(agenda.buscarTelefono(Vista.leerTelefono()));
                        break;
                    case 5:
                        ArrayList<Contacto> contactos = agenda.getContactos();
                        Vista.mostrarListado(contactos);
                        break;
                    default:
                        break;
                }
            } catch (ContactNotFoundException ex) {
                Vista.contactoNoEncontradoM(ex.getMessage());
            } catch (ContactNullException ex) {
                Vista.contactoNullM();
            } catch (PhoneDuplicatedException ex) {
                Vista.telefonoDuplicadoM(ex.getMessage());
            }
        } while (opc != 0);
    }

}
