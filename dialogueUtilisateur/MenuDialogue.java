package dialogueUtilisateur;

import src.Connect;
import utilitaires.ligneDeCommande.Liste;
import utilitaires.ligneDeCommande.Option;
import utilitaires.ligneDeCommande.Menu;
import utilitaires.ligneDeCommande.Action;
import inscriptions.Inscriptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;

/*Dialogue Utilisateur*/
public class MenuDialogue {
	
	public static void main(String[]args){
		
		/*Cr�ation du menu principal*/
		Menu menuPrincipal = new Menu("Menu principal");
		
		/*Comp�titions*/
		Menu menuCompetition = new Menu("Menu Competition","b");
		/*menuCompetition.ajoute(new Option("Visualiser les comp�titions","a",new Action() {
			public void optionSelectionnee()
			{
				Connect.readBDD("call GET_COMP()","labelComp","NomComp");
			}
		}));*/
		menuCompetition.ajoute(new Option("Modifier le nom d'une comp�tition","b",new Action() {
			public void optionSelectionnee()
			{
				String label = utilitaires.EntreesSorties.getString("Saisir le label de la comp�tition : ");
				String newName = utilitaires.EntreesSorties.getString("Nouveau nom : ");
				Connect.requete("call SET_NAME_COMP('"+newName+"','"+label+"')");
			}
		}));
		menuCompetition.ajoute(new Option("Visualiser les candidats d'une comp�tition","c",new Action() {
			public void optionSelectionnee()
			{
				String label = utilitaires.EntreesSorties.getString("Saisir le label de la comp�tition : ");
				Connect.readBDD("call GET_CANDIDATS_FROM_COMP('"+label+"')","NumCandidat","NomCandidat");
			}
		}));
		menuCompetition.ajoute(new Option("Cr�er une comp�tition","d",new Action() {
			public void optionSelectionnee()
			{
				String label = utilitaires.EntreesSorties.getString("Label : ");
				String nom = utilitaires.EntreesSorties.getString("Nom : ");
				String dateClot = utilitaires.EntreesSorties.getString("Date de cl�ture (annee-mois-jour): ");
				int enEquipe = utilitaires.EntreesSorties.getInt("Comp�tition en �quipe? (1 oui 0 non): ");
				createCompetition(label,nom,dateClot,enEquipe);
				/*Connect.requete("call ADD_COMP('"+label+"','"+nom+"','"+dateClot+"',"+enEquipe+")");*/
			}
		}));
		menuCompetition.ajoute(new Option("Supprimer une comp�tition","e",new Action() {
			public void optionSelectionnee()
			{
				/*Supprime toutes les comp�titions au lieu de celle choisie*/
				String label = utilitaires.EntreesSorties.getString("Label : ");
				Connect.requete("call DEL_COMP('"+label+"')");
			}
		}));
	
		menuCompetition.ajoute(new Option("Inscrire une �quipe � une comp�tition","f",new Action() {
			public void optionSelectionnee()
			{
				/*Fonction Pas r�ussie*/
			}
		}));
		menuCompetition.ajoute(new Option("Inscrire une personne � une comp�tition","g",new Action() {
			public void optionSelectionnee()
			{
				/*Fonction Pas r�ussie*/
			}
		}));
		menuCompetition.ajoute(new Option("Supprimer un candidat d'une comp�tition","h",new Action() {
			public void optionSelectionnee()
			{
				int idCand = utilitaires.EntreesSorties.getInt("Saisir le num�ro du candidat ");
				String label = utilitaires.EntreesSorties.getString("Saisir le label de la comp�tition");
				Connect.requete("call DEL_PARTICIPATION("+idCand+",'"+label+"')");
			}
		}));
		menuCompetition.ajouteRevenir("r");
		menuPrincipal.ajoute(menuCompetition);
		
		/*Equipes*/
		final Menu menuEquipes = new Menu("Menu Equipe","c");
		menuPrincipal.ajoute(menuEquipes);
		menuEquipes.ajoute(new Option("Visualiser les �quipes","a",new Action() {
			public void optionSelectionnee()
			{
				Connect.readBDD("call GET_EQUIPE()","NumCandidat","NomCandidat");
			}
		}));
		menuEquipes.ajoute(new Option("Creer une �quipe","b",new Action() {
			public void optionSelectionnee()
			{
				int id = utilitaires.EntreesSorties.getInt("Num�ro: ");
				String nom = utilitaires.EntreesSorties.getString("Nom de l'�quipe: ");
				String email = utilitaires.EntreesSorties.getString("Email: ");
				Connect.requete("call ADD_EQUIPE("+id+",'"+nom+"','"+email+"')");
			}
		}));
		menuEquipes.ajoute(new Option("Visualiser les membres d'une equipe","c",new Action() {
			public void optionSelectionnee()
			{
				System.out.print("Saisir le num�ro de l'equipe � visualiser: ");
				InputStreamReader saisie = new InputStreamReader(System.in);
				try {
					int id =  (int) saisie.read();
					Connect.readBDD("call GET_MEMBRE_EQUIPE(id)","NumCandidat","NomCandidat");;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}));
		menuEquipes.ajoute(new Option("Ajouter un membre","g",new Action() {
			public void optionSelectionnee()
			{
				int idPers = utilitaires.EntreesSorties.getInt("Saisir le num�ro de la personne: ");
				int idEq = utilitaires.EntreesSorties.getInt("Saisir l'equipe: ");
				Connect.requete("call ADD_MEMBRE("+idPers+","+idEq+")");
			}
		}));
	
		menuEquipes.ajoute(new Option("Supprimer un membre d'une �quipe","d",new Action() {
			public void optionSelectionnee()
			{
				int idPers= utilitaires.EntreesSorties.getInt("Saisir le num�ro du la personne: ");
				int idEq = utilitaires.EntreesSorties.getInt("Saisir l'equipe: ");
				Connect.requete("call DEL_MEMBRE("+idEq+","+idPers+")");
			}
		}));
	
		/*Personnes*/
		Menu menuPersonne = new Menu("Menu Personne","e");
		menuPrincipal.ajoute(menuPersonne);
		menuPersonne.ajoute(new Option("Visualiser les personnes","v",new Action() {
			public void optionSelectionnee()
			{
				Connect.readBDD("call GET_PERSONNE()","NumCandidat","PrenomPersonne");
			}
		}));
		menuPersonne.ajoute(new Option("Modifier le pr�nom d'une personne","b",new Action() {
			public void optionSelectionnee()
			{
				int idCand = utilitaires.EntreesSorties.getInt("Saisir le num�ro du Candidat : ");
				String newFirstName = utilitaires.EntreesSorties.getString("Nouveau nom : ");
				Connect.requete("call SET_PRENOM_PERSONNE('"+newFirstName+"')");
			}
		}));
		menuPersonne.ajoute(new Option("Modifier l'email","c",new Action() {
			public void optionSelectionnee()
			{
				int idCand = utilitaires.EntreesSorties.getInt("Saisir le num�ro du Candidat : ");
				String newMail = utilitaires.EntreesSorties.getString("Nouveau nom : ");
				Connect.requete("call SET_MAIL_PERSONNE('"+newMail+"')");
			}
		}));
		menuPersonne.ajoute(new Option("Cr�er une personne","d",new Action() {
			public void optionSelectionnee()
			{
				int idCand = utilitaires.EntreesSorties.getInt("num�ro : ");
				String nom = utilitaires.EntreesSorties.getString("Nom : ");
				String prenom = utilitaires.EntreesSorties.getString("Pr�nom: ");
				String email = utilitaires.EntreesSorties.getString("Email: ");
				Connect.requete("call ADD_COMP("+idCand+",'"+nom+"','"+email+"',"+prenom+")");
			}
		}));
		menuPrincipal.ajouteQuitter("q");
		
		menuPrincipal.start();

	}
	
}
