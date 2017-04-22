package src;

import inscriptions.Candidat;
import inscriptions.Competition;
import inscriptions.Equipe;
import inscriptions.Inscriptions;
import inscriptions.Personne;

import java.awt.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Month;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import com.mysql.jdbc.CallableStatement;
//
//CTRL + SHIFT + O pour générer les imports
public class Connect {
	
	private Connection conn;


	
   public static void main(String[]args){
       Connect c = new Connect();
       SortedSet<Competition> competitions = new TreeSet<Competition>() ;
//     LocalDate dateCloture = LocalDate.of(2017,Month.APRIL,10);
//     LocalDate newDate = LocalDate.of(2015,Month.APRIL,25);
//     //c.setDateComp(newDate,2);
//     //c.addComp("Tennis", dateCloture, false);
//     //c.addPersonne("NGUY", "Fabrice", "fabrice.nguy@gmail.com");
//     //c.addComp("basketball", dateCloture, true);
//     //c.addEquipe("Zea");
//     //System.out.println(c.getNameCandidat(3));
//     // c.addMembreEquipe(1, 3);
//     //c.addMembreEquipe(17, 18);
//     //System.out.println(c.getDateComp(1));
//     //LocalDate date = LocalDate.now();
//     //System.out.println(c.CompOuverte(1));
//     System.out.println(c.enEquipeComp(1));
      try {
		  int taille = c.getCompetitions().size();
		  System.out.println("taille "+taille);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       c.close();
//       for (Competition competition : competitions) {
//    	   System.out.println(competition.getNom());
//       }
    }
    
    public Connect() {
        
    	try {
			Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver O.K.");

        String url = "jdbc:mysql://localhost/inscription2017?useSSL=false";
        String login= "root";
        String passwd = "";

        conn = DriverManager.getConnection(url, login, passwd);
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    
    public void close()
    {
    	try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
 public  void requete(String requete) {
 
 Statement st =null;
 try {
      System.out.println("Requête executée !"); 
      st=conn.createStatement();
  
      st.executeUpdate(requete);
         
    } catch (Exception e) {
      e.printStackTrace();
    }

 }
 public static boolean requeteBoolean(String requete, String nomChamp) {

	  // Information d'accès à la base de données
	  Boolean Resultat = null;  
	  Connection cn = null;
	  Statement st = null;
	  ResultSet rs = null;
	  String url = "jdbc:mysql://localhost/inscription2017?useSSL=false";
	  String login= "root";
	  String passwd = "";
	  
	  try {

	   // Etape 1 : Chargement du driver
	   Class.forName("com.mysql.jdbc.Driver");

	   // Etape 2 : récupération de la connexion
	   cn = DriverManager.getConnection(url, login, passwd);

	   // Etape 3 : Création d'un statement
	   st = cn.createStatement();

	   String sql = requete;

	   // Etape 4 : exécution requête
	   rs = st.executeQuery(sql);

	   if(rs.first()){
	      Resultat = rs.getBoolean(nomChamp);
	      } 
	   return Resultat; 
	  
	  } catch (SQLException e) {
	   e.printStackTrace();
	  } catch (ClassNotFoundException e) {
	   e.printStackTrace();
	  } finally {
	   try {
	  
	    cn.close();
	    st.close();
	   } catch (SQLException e) {
	    e.printStackTrace();
	   }
	  }
	  return false;

	 }
 public static String readBDD(String requete, String nomChamp) {

  // Information d'accès à la base de données
  String Resultat = null;  
  Connection cn = null;
  Statement st = null;
  ResultSet rs = null;
  String url = "jdbc:mysql://localhost/inscription2017?useSSL=false";
  String login= "root";
  String passwd = "";
  
  try {

   // Etape 1 : Chargement du driver
   Class.forName("com.mysql.jdbc.Driver");

   // Etape 2 : récupération de la connexion
   cn = DriverManager.getConnection(url, login, passwd);

   // Etape 3 : Création d'un statement
   st = cn.createStatement();

   String sql = requete;

   // Etape 4 : exécution requête
   rs = st.executeQuery(sql);

   if(rs.first()){
      Resultat = rs.getString(nomChamp);
      } 
   return Resultat; 
  
  } catch (SQLException e) {
   e.printStackTrace();
  } catch (ClassNotFoundException e) {
   e.printStackTrace();
  } finally {
   try {
  
    cn.close();
    st.close();
   } catch (SQLException e) {
    e.printStackTrace();
   }
  }
  return null;

 }
 public ResultSet resultatRequete(String requete) {

	  // Information d'accès à la base de données

	  Connection cn = null;
	  Statement st = null;
	  ResultSet rs = null;
	  String url = "jdbc:mysql://localhost/inscription2017?useSSL=false";
	  String login= "root";
	  String passwd = "";
	  
	  try {

	   // Etape 1 : Chargement du driver
	   Class.forName("com.mysql.jdbc.Driver");

	   // Etape 2 : récupération de la connexion
	   cn = DriverManager.getConnection(url, login, passwd);

	   // Etape 3 : Création d'un statement
	   st = cn.createStatement();

	   String sql = requete;

	   // Etape 4 : exécution requête
	   rs = st.executeQuery(sql);


	   return rs; 
	  
	  } catch (SQLException e) {
	   e.printStackTrace();
	  } catch (ClassNotFoundException e) {
	   e.printStackTrace();
	  } 
	   
	  return null;

	 } 
 /*Candidat*/
// public List<Candidat>
 public void setNameCandidat(String prenom,int id){
   requete("call SET_NAME_CANDIDAT('"+prenom+"','"+id+"')");
 }
 public void delCandidat(int id){
   requete("call DEL_CANDIDAT('"+id+"')");
 }
 
 public SortedSet<Candidat> getCandidats() throws SQLException{
	 Inscriptions i;
	 i = Inscriptions.getInscriptions();
	 SortedSet<Candidat> candidats = new TreeSet<Candidat>();
	 ResultSet rs = resultatRequete("call GET_CANDIDATS()");
	 while(rs.next()){
		int num = rs.getInt("NumCandidat");
		String nom = rs.getString("NomCandidat");
		Boolean equipe = rs.getBoolean("Equipe");
		if(equipe){
			Equipe e = i.createEquipe(nom);
			candidats.add(e);
		}else {
			Personne p = i.createPersonne(nom, null, null);
			candidats.add(p);
		}
	 }
	 return candidats;
}
 
 /*competition*/
 public SortedSet<Competition> getCompetitions() throws SQLException {
	 Inscriptions i;
	 i = Inscriptions.getInscriptions();
	 SortedSet<Competition> competitions = new TreeSet<Competition>();
	 ResultSet rs = resultatRequete("call GET_COMP()");
	 while(rs.next()){
		int num = rs.getInt("NumComp");
		String nom = rs.getString("NomComp");
		LocalDate date =rs.getDate("DateCloture").toLocalDate();
		Boolean enEquipe = rs.getBoolean("EnEquipe");
		Competition competition = i.createCompetition(nom,date, enEquipe); 
		 competitions.add(competition);
	 }
	 return competitions;
 }
 
	 

 public void add(Competition competition){
   requete("call ADD_COMP('"+competition.getNom()+"','"+
		   competition.getDateCloture()+"',"+competition.estEnEquipe()+")");
   // TODO récupérer l'ID
  // ....
 //   competition.setId(/* */);
 }
 
 public void setDateComp(LocalDate newDate,int id){
   requete("call SET_DATE_CLOTURE('"+id+"','"+newDate+"')");
 }

 /*
public Boolean CompOuverte(int id){  
	    
	    Date today = Date.valueOf(LocalDate.now());
		Date dateCloture = getDateComp(id);
		
		Boolean resultat = dateCloture.after(today);
		return resultat;
}
*/
 public Date getDateComp(int id) {

    // Information d'accès à la base de données
    Date Resultat = null;  
    Connection cn = null;
    Statement st = null;
    ResultSet rs = null;
    String url = "jdbc:mysql://localhost/inscription2017?useSSL=false";
    String login= "root";
    String passwd = "";
    
    try {

     // Etape 1 : Chargement du driver
     Class.forName("com.mysql.jdbc.Driver");

     // Etape 2 : récupération de la connexion
     cn = DriverManager.getConnection(url, login, passwd);

     // Etape 3 : Création d'un statement
     st = cn.createStatement();

     String sql = ("call date_cloture('"+id+"')");

     // Etape 4 : exécution requête
     rs = st.executeQuery(sql);

     if(rs.first()){
        Resultat = rs.getDate("DateCloture");
        } 
     return Resultat; 
    
    } catch (SQLException e) {
     e.printStackTrace();
    } catch (ClassNotFoundException e) {
     e.printStackTrace();
    } finally {
     try {
    
      cn.close();
      st.close();
     } catch (SQLException e) {
      e.printStackTrace();
     }
    }
    return null;

   }
 public boolean enEquipeComp(int id){
	   return Connect.requeteBoolean("call EN_EQUIPE_COMP('"+id+"')","EnEquipe");
 }
 public void delComp(int id){
	   requete("call DEL_COMP('"+id+"')");
 }
 /*Personne*/
 public void add(Personne p){
   requete("call ADD_PERSONNE('"+p.getNom()+
		   "','"+p.getPrenom()+"','"+p.getMail()+"')");
 }
 public void setPrenomPersonne(int id,String prenom){
   requete("call SET_PRENOM_PERSONNE('"+id+"','"+prenom+"')");
 }
 public void setMailPersonne(int id,String mail){
   requete("call SET_MAIL_PERSONNE('"+id+"','"+mail+"')");
 }
 
 /*Equipe*/
 public void add(Equipe equipe){
   requete("call ADD_EQUIPE('"+equipe.getNom()+"')");
 }
 
 public void addMembreEquipe(int idEquipe,int idPersonne){
   requete("call ADD_MEMBRE('"+idEquipe+"','"+idPersonne+"')");
 }
 public void delMembreEquipe(int idEquipe,int idPersonne){
	   requete("call DEL_MEMBRE('"+idEquipe+"','"+idPersonne+"')");
 }
 /*Participation*/
/* public void addParticipation(int idCandidat, int idComp){
	   requete("call ADD_PARTICIPATION('"+idCandidat+"','"+idComp+"')");
 }
 public void delParticipation(int idCandidat, int idComp){
	   requete("call DEL_PARTICIPATION('"+idCandidat+"','"+idComp+"')");
} */
}