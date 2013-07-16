/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aironman.core.service;

import java.security.Security;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aironman.core.configuration.MailBean;
import com.aironman.core.configuration.MailPropertiesConfig;
import com.aironman.core.utils.Constantes;

/**
 * Implementacion super basica para poder enviar emails a los clientes de la
 * tienda. TODO implementar un dao que me de acceso al usuario y contraseña que
 * realiza el envio de emails por parte de la direccion de la tienda. ahora lo
 * tienes hardcodeado en el fichero constantes y no me gusta. Ya puestos porque
 * no tener todos esos valores ctes en una tabla de bbdd? ahora pasas el subject
 * y el content como un parametro al metodo enviarMail cuando lo suyo seria
 * pasar una cte que implicara un subject predefinido lo mismo para el content.
 * Ten en cuenta que son valores que van a viajar por la red y no es plan de
 * malgastar recursos. Que tal un motor de plantillas?
 * 
 * tienes que pensar tmb en un implmentacion jms punto a punto. Primero lo hare
 * para glashfish, ya que parece que tiene soporte nativo Un punto será el que
 * introduzca el mensaje con el payload necesario para crear el email y lo
 * introducira en la cola fifo que tiene de forma nativa el concepto jms. El
 * otro extremo, el consumidor, cogerá el mensaje y creara un email que sera
 * lanzado usando esta implementacion.
 * 
 * @author alonso
 */
@Service("servicioMail")
public class ServicioMailImpl implements ServicioMail {

	private final Log log = LogFactory.getLog(ServicioMailImpl.class);

	private static final String tipoEmail = "text/plain";

	private Session session;

	private Transport transport;

	private InternetAddress addressFrom;

	private MimeMessage message;

	private static final String subject = "Un posible nuevo cliente en Juridia";

	// tienes que pensar en un buen content. Como paso en el content la url
	// exacta del certificado generado? lo q esta claro es q esto no ser� ni
	// static ni final
	private static final String content = "Enhorabuena, acaba de llegar una peticion sobre un certificado generado. ";

	@Autowired
	private MailPropertiesConfig mailPropertiesConfig;

	public ServicioMailImpl() {
		if (log.isDebugEnabled()) {
			log.info("Constructor Sin tipo ServicioMailImpl...");
		}
	}

	@PostConstruct
	public void init() {
		// estas metiendo en un fichero properties el contenido del fichero
		// Constantes
		log.info("Initializing email system...");
		try {
			Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
			Properties props = new Properties();
			props.setProperty(Constantes.MAIL_TRANSPORT_PROTOCOL,
					Constantes.PROTOCOLO_SMTP);
			props.setProperty(Constantes.MAIL_HOST, Constantes.SMTP_GMAIL);
			props.put(Constantes.MAIL_SMTP_AUTH, Boolean.TRUE);
			props.put(Constantes.MAIL_SMTP_PORT, 465);
			// SUPONGO QUE ESTO LO DESHABILITARE CUANDO QUIERA RENDIMIENTO,
			// ahora me gusta ver lo que google me devuelve
			props.put("mail.debug", Boolean.TRUE);
			props.put(Constantes.MAIL_SMTP_SOCKETFACTORY_PORT, 465);
			props.put(Constantes.MAIL_SMTP_SOCKET_FACTORY,
					"javax.net.ssl.SSLSocketFactory");
			props.put(Constantes.MAIL_SMTP_SOCKET_FACTORY_FALLBACK,
					Boolean.FALSE);
			// hum, interesante, traer la instancia por defecto como se hago
			// aqui,
			// me puede dar esta excepcion: java.lang.SecurityException: Access
			// to default session denied
			// Session.getDefaultInstance(props, , new
			// javax.mail.Authenticator());
			MailBean mailBean = mailPropertiesConfig.getMailProperties();
			// log.info("mailBean: " + mailBean.toString());
			final String passMail = mailBean.getPassMail();
			final String userMail = mailBean.getUserMail();

			this.session = Session.getInstance(props,
					new javax.mail.Authenticator() {
						@Override
						protected PasswordAuthentication getPasswordAuthentication() {
							// el usuario de la empresa que va a enviar los
							// emails a los clientes que han confirmado el carro
							// de su compra
							// lo suyo seria que esto se pudiera cargar desde
							// algun fichero constantes.properties
							return new PasswordAuthentication(userMail,
									passMail);
						}
					}); // fin de la instanciacion de session
			this.transport = session.getTransport();
			this.addressFrom = new InternetAddress(userMail);
			this.message = new MimeMessage(session);
			message.setSender(addressFrom);
		} catch (MessagingException ex) {
			if (log.isDebugEnabled()) {
				log.info(
						"ATENCION!, ha ocurrido un problema al inicializar el motor de correos.",
						ex);
			}
		} finally {
			log.info("Email system initialized!.");
		}
	}

	/**
	 * metodo que permite enviar un email a un destinatario
	 * 
	 * @param emailTo
	 *            la direccion del destinatario
	 * @return true todo ha ido bien, false ha habido un problema
	 * @throws StoreException
	 *             en caso de problemas.
	 */
	@Override
	public final boolean sendMessage(String emailTo) {
		if (log.isDebugEnabled()) {
			StringBuffer sb = new StringBuffer(
					"Init ServicioMailImpl.enviarMail.");
			sb.append(" emailTo: ").append(emailTo);
			log.info(sb.toString());
		}

		boolean retorno = false;
		try {
			this.message.setSubject(subject);
			message.setContent(content, tipoEmail);
			String[] sendTo = { emailTo };

			if (sendTo != null) {
				InternetAddress[] addressTo = new InternetAddress[sendTo.length];
				for (int i = 0; i < sendTo.length; i++) {
					addressTo[i] = new InternetAddress(sendTo[i]);
				}
				message.setRecipients(Message.RecipientType.TO, addressTo);
			}
			transport.connect();
			Transport.send(message);
			transport.close();
			retorno = true;

		} catch (MessagingException ex) {
			if (log.isDebugEnabled()) {
				log.info(
						"ATENCION!! Ha ocurrido un problema al enviar el email.",
						ex);
			}
		} finally {
			if (log.isDebugEnabled()) {
				StringBuffer sbEnd = new StringBuffer(
						"End ServicioMailImpl.enviarMail.");
				sbEnd.append("subject: ").append(subject);
				sbEnd.append(" content: ").append(content);
				sbEnd.append(" emailTo: ").append(emailTo);
				sbEnd.append(" retorno: ").append(retorno);
				log.info(sbEnd.toString());
			}
		}
		return retorno;
	}
}