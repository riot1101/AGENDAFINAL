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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CES
 */
public class Agenda {

    private ArrayList<Contacto> contactos = new ArrayList();

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }

    public boolean insertarContacto(Contacto contacto) throws PhoneDuplicatedException,
            ContactNullException {
        if (contacto != null) {
            try {
                this.buscarTelefono(contacto.getTelefono());
                throw new PhoneDuplicatedException(contacto.getTelefono());
            } catch (ContactNotFoundException ex) {
                this.contactos.add(contacto);
                return true;
            }
        }
        throw new ContactNullException();
    }

    public Contacto buscarTelefono(String telefono) throws ContactNotFoundException {
        /*
        for (int i = 0; i < contactos.size(); i++) {
            Contacto contacto = contactos.get(i);
        } */
        for (Contacto contacto : contactos) {
            if (contacto.getTelefono().equals(telefono)) {
                return contacto;
            }
        }
        //return null;
        throw new ContactNotFoundException(telefono);
    }

    public boolean modificarContacto(Contacto contacto,
            String telefono) throws ContactNotFoundException, ContactNullException {
        if (contacto != null && telefono != null) {
            Contacto aux = this.buscarTelefono(telefono);
            aux.setEmail(contacto.getEmail());
            aux.setNombre(contacto.getNombre());
            //nuevo teléfono es distinto
            if (!telefono.equals(contacto.getTelefono())) {
                try {
                    //buscar teléfono nuevo
                    buscarTelefono(contacto.getTelefono());
                } catch (ContactNotFoundException ex) {
                    aux.setTelefono(contacto.getTelefono());
                }
            }
            return true;
        }
        throw new ContactNullException();
    }

    public Contacto borrarContacto(String telefono) throws 
            ContactNotFoundException, ContactNullException {
        if (telefono != null) {
            Contacto aux = this.buscarTelefono(telefono);
            this.contactos.remove(aux);
            return aux;
        }
        throw new ContactNullException();
    }
}
