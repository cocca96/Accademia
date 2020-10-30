package bit.accademia;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

import bit.accademia.model.Area;

public class Main {

	public static void main(String[] args) {
	      try(
	    	  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/scoula", "root","root");
	    	  Statement s=con.createStatement(); 
	    	  ResultSet rs=s.executeQuery("SELECT * FROM area");) {
			System.out.println("connessione stabilita");
			//usiamo di nuovo un metodo factory per nascondere la classe reale (come prima con drivermanager)
			//Statement s=con.createStatement(); //ritorneà uno statement di tipo mysql (per la libreria che abbiamo inserito)
			//ora possiamo lanciare la query e la inseriamo in un puntatore result se
			//dove resultset è un'interfaccia
			//ResultSet rs=s.executeQuery("SELECT * FROM area");
			//next() guarda se ci sia una prossima riga(true se c'è false se no) ma fa anche hasnext quindi si sposta anche sulla 
			//prossima riga di risultato. Anche per vedere la prima riga devo fare ra.next()
			//perchè il result set punta subito alla prima riga che potrebbe essere vuota
			while(rs.next()) {
				String id=rs.getString("idArea");
				String nome=rs.getNString("nome");
				String descrizione=rs.getNString("descrizione");
				//printf permette di stampare più stringhe senza interpolarle (senza mettere i +); %m dice di andare a capo
				System.out.printf("id:%s nome:%s descrizione:%s%m", id,nome,descrizione);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	      findAreaLike("GRA").forEach(System.out::println);
	      betterFindAreaLike("GRA").forEach(System.out::println);
	      
	}
	public static Collection<Area> findAreaLike(String partialName) {
		Collection<Area> col=new ArrayList<Area>();
		 try(
		    	  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/scoula", "root","root");
		    	  Statement s=con.createStatement(); 
		    	  ResultSet rs=s.executeQuery("SELECT * FROM area WHERE nome LIKE'%"+partialName+"%' ");){
			
				while(rs.next()) {
					int i=rs.getInt("idArea");
					String nome=rs.getNString("nome");
					String descrizione=rs.getNString("descrizione");
					Area a=new Area(i," nome"," descrizione");
					
					col.add(a);
					
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 
		
		return col;
		
	}
	public static Collection<Area> betterFindAreaLike(String partialName) {
		Collection<Area> col=new ArrayList<Area>();
		 try(
		    	  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/scoula", "root","root");
		    	  PreparedStatement pst=con.prepareStatement("SELECT *FROM AREA WHERE NOME LIKE ?"); 
		    	  //ResultSet rs=pst.executeQuery("SELECT * FROM area WHERE nome LIKE'%"+partialName+"%' ");
				 
			){
			 //l'indice indica la posizione del parametro, perchè potrei avere più parametri, e value indica il nome
			 pst.setNString(1," %"+partialName+"%");
			 try(ResultSet rs=pst.executeQuery()){
			
				while(rs.next()) {
					int i=rs.getInt("idArea");
					String nome=rs.getNString("nome");
					String descrizione=rs.getNString("descrizione");
					Area a=new Area(i," nome"," descrizione");
					
					col.add(a);
					
					
					}
			 }
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 
		
		return col;
		
	}


}
