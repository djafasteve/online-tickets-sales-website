package fr.afcepf.al27.ticketshack.front.util;

import java.util.Properties;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import fr.afcepf.al27.ticketshack.entity.entity.Commande;

@ManagedBean(name = "mBeanMail")
@SessionScoped
public class MbMail {
	
	
	private static final long serialVersionUID = 1L;
	
	
	
	public void sendFacture(Commande commande) {

		final String username = "ticketshacks@gmail.com";
		final String password = "adminadmin";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("ticketshacks@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(commande.getUtilisateur().getMail()));
			message.setSubject("Votre facture TicketsHack n°" + commande.getReference());
			message.setText(
					"Bonjour " + commande.getUtilisateur().getCivilite().getLibelleCivilite() + " " + commande.getUtilisateur().getNom()
							+ ", " + "\n\n Vous avez récemment effectué un achat sur notre site Internet TicketsHack.fr"
							+ "\n\n et nous vous remercions de votre confiance."
							+ "\n\n Nous avons le plaisir de vous adresser ci-joint la facture de votre commande: n°"
							+ commande.getReference() + " : "
							+"\r\n"
							+ "\n\n En espérant avoir le plaisir de vous retrouver bientôt sur www.TicketsHack.fr"
							+ "\n\n Avec tous nos remerciements." + "\n\n L'équipe TicketsHack");
			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
