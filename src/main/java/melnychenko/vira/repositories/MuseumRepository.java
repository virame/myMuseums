package melnychenko.vira.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import melnychenko.vira.entities.MuseumItems;



@Repository
public class MuseumRepository {
	
	  static final String DB_URL = "jdbc:mysql://localhost:3306/mymuseum";
	   static final String USER = "javacourse";
	   static final String PASS = "javacourse";
	
	@PersistenceContext
	EntityManager entityManager;
	
	//List of strings with all continents for main page
	public List<String> getContinentList() {
		Query query;
		query = entityManager.createQuery("SELECT DISTINCT mus.museumContinent FROM MuseumItems mus");
		
		List<String> results;
		results = query.getResultList();
		return results;
		
	}
	
	//List of objects (museums) for each continents 
	public List<MuseumItems> getMuseumListNorth() {
		Query query;
		query = entityManager.createQuery("SELECT mus.museumName, mus.museumPicture FROM MuseumItems mus WHERE mus.museumContinent = 'North America'");
		
		List<MuseumItems> results;
		results = query.getResultList();
		return results;
		
	}
	
	//List of objects (museums) for each continents 
	public List<MuseumItems> getMuseumListEurope() {
		Query query;
		query = entityManager.createQuery("SELECT mus.museumName, mus.museumPicture FROM MuseumItems mus WHERE mus.museumContinent = 'Europe'");
		
		List<MuseumItems> results;
		results = query.getResultList();
		return results;
		
	}
	//List of objects (museums) for each continents 
	public List<MuseumItems> getMuseumListAsia() {
		Query query;
		query = entityManager.createQuery("SELECT mus.museumName, mus.museumPicture FROM MuseumItems mus WHERE mus.museumContinent = 'Asia'");
		
		List<MuseumItems> results;
		results = query.getResultList();
		return results;
		
	}

	//List of objects (museums) for each continents 
	public List<MuseumItems> getMuseumListSA() {
		Query query;
		query = entityManager.createQuery("SELECT mus.museumName, mus.museumPicture FROM MuseumItems mus WHERE mus.museumContinent = 'South America'");
		
		List<MuseumItems> results;
		results = query.getResultList();
		return results;
		
	}
	//List of objects (museums) for each continents 
	public List<MuseumItems> getMuseumListAfrica() {
		Query query;
		query = entityManager.createQuery("SELECT mus.museumName, mus.museumPicture FROM MuseumItems mus WHERE mus.museumContinent = 'Africa'");
		
		List<MuseumItems> results;
		results = query.getResultList();
		return results;
		
	}
	//List of objects (museums) for each continents 
	public List<MuseumItems> getMuseumListOceania() {
		Query query;
		query = entityManager.createQuery("SELECT mus.museumName, mus.museumPicture FROM MuseumItems mus WHERE mus.museumContinent = 'Oceania'");
		
		List<MuseumItems> results;
		results = query.getResultList();
		return results;
		
	}
	

	//Common solution for all museums to fetch data for specified museum as an argument. I learned it myself as I didnt really want to create extra 18 methods
	public ArrayList<MuseumItems> executeMuseum(String museum) 
		    throws SQLException {
		
			Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
		
		    Statement stmt = null;
		    ArrayList<MuseumItems> ml = new ArrayList<MuseumItems>();
		    MuseumItems thisMuseum = new MuseumItems();
		    String query = "select museum_Name, museum_Picture, museum_Address, museum_Web, museum_Description from mymuseum.museum_items where museum_Name = " + museum;
		    try {
		        stmt = conn.createStatement();
		        ResultSet rs = stmt.executeQuery(query);
		        while (rs.next()) {
		        	thisMuseum.setMuseumName(rs.getString("MUSEUM_NAME"));
		        	thisMuseum.setMuseumPicture(rs.getString("MUSEUM_PICTURE"));
		        	thisMuseum.setMuseumAddress(rs.getString("MUSEUM_ADDRESS"));
		        	thisMuseum.setMuseumWeb(rs.getString("MUSEUM_WEB"));
		        	thisMuseum.setMuseumDescription(rs.getString("MUSEUM_DESCRIPTION"));
		            
		            ml.add(thisMuseum);
		            
		        }
		        
		    } 
		    		    
		    catch (SQLException e ) {
		    	e.printStackTrace();
		    } finally {
		        if (stmt != null) { stmt.close(); }
		    }
		    return ml;
	}
	
	
	
}