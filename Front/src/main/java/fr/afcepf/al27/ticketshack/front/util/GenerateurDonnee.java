package fr.afcepf.al27.ticketshack.front.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.afcepf.al27.ticketshack.apidao.apidao.IDaoEvenement;
import fr.afcepf.al27.ticketshack.entity.entity.Evenement;

public class GenerateurDonnee {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"spring/application-config.xml"});
		
		IDaoEvenement dao = (IDaoEvenement)context.getBean("implDaoEvenement");
		List<Evenement> list = new ArrayList<Evenement>();
		list = dao.findAll();
		// list = dao.findByCategorie(1);
		File lignesCmd = new File("LignesCommande.json");

		Writer writer;

		try {
			writer = new FileWriter(lignesCmd);
			BufferedWriter bw = new BufferedWriter(writer);

			int idIndex = 0;
			int idCommande = 1;
			
			for (Evenement e : list) {

				int i = (int) ((Math.random() * 10 + 1) * (Math.random() * 10 + 1));

				for (int x = 0; x < i; x++) {

					idCommande = (int) ((Math.random()*10 +1) * (Math.random()*10 +1) * (Math.random()*10 +1));
						String ligne = null;
						String index = null;
						int annee = (int) Math.round((Math.random() * (10))) + 2006;
						int mois = (int) Math.round(Math.random() * 11) + 1;
						String moisStr = "";
						
						if (mois < 10) {
							
							moisStr = "0" + String.valueOf(mois);
							
						} else {
							
							moisStr = String.valueOf(mois);
						}
						
						

						int jour = (int) Math.round(Math.random() * 27) + 1;
						
						String jourStr = "";
						
						if (jour < 10) {
							
							jourStr = "0" + String.valueOf(jour);
							
						} else {
							
							jourStr = String.valueOf(jour);
						}
						
						
						String createDate = annee +"-"+ moisStr+"-" + jourStr;
						
						int quantity = (int) Math.round(Math.random() * 10) + 1;

						index = "{\"index\":{\"_index\":\"ticketshack\",\"_type\":\"commande\",\"_id\":" + idIndex + "}}";
						bw.write(index);
						bw.write("\r\n");
						ligne = "{\"id\":" + x + "," + "\"idCommande\":" + idCommande + "," + "\"category\":" + "\""+ e.getCategorie().getLibelleCategorie() + "\""+ ","
								+ "\"theme\":"+ "\"" +  e.getThemes().get(0).getLibelleTheme()+ "\"" + "," + "\"product\":" + "\""+ e.getLibelleEvenement()+ "\""
								+ "," + "\"DateCommande\":" + "\"" +createDate +"\"" + "," + "\"price\":"
								+ e.getOccurences().get(0).getTarifs().get(0).getPrix() + "," + "\"quantity\":"
								+ quantity + "}";

						bw.write(ligne);
						bw.write("\r\n");
						idIndex++;
					}

				}


		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
