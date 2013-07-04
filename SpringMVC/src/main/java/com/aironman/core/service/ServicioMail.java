/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aironman.core.service;

/**
 * 
 * Interfaz para enviar mails
 * 
 * @author alonso
 */
public interface ServicioMail {

	public boolean sendMessage(String emailTo);

}
