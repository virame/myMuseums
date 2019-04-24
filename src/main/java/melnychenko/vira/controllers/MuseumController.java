package melnychenko.vira.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import melnychenko.vira.entities.MuseumItems;
import melnychenko.vira.repositories.MuseumRepository;

@Controller
public class MuseumController {
	private Object request;
	
	@Autowired
	MuseumRepository repository;
	
	//Method for the main page to load array of string
	@RequestMapping(value = "/")
	public ModelAndView getMainPage() {
		
		List<String> allContinents = repository.getContinentList();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("continents", allContinents);
		mav.setViewName("index.html");
		return mav;
	}
	
	//Method for the login page
	@RequestMapping(value = "/login")
	public ModelAndView getloginPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login.html");
		return mav;
	}
	
	//Method for North AMerica list of museums page
	@RequestMapping(value = "/North America")
	public ModelAndView getNorthPage() {
		List<MuseumItems> allNorth;
		allNorth = repository.getMuseumListNorth();	
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("countryName", "North America");
		mav.addObject("path", "./images/maps/North_America.png");
		mav.addObject("museumList", allNorth);
		mav.setViewName("region");
		return mav;
	}
	


	//Method for Europe list of museums page
	@RequestMapping(value = "/Europe")
	public ModelAndView getEuropePage() {
		List<MuseumItems> allEurope;
		allEurope = repository.getMuseumListEurope();	
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("countryName", "Europe");
		mav.addObject("path", "./images/maps/europe.png");
		mav.addObject("museumList", allEurope);
		mav.setViewName("region");
		return mav;
	}
	//Method for the south america list of museums page
	@RequestMapping(value = "/South America")
	public ModelAndView getSouthAmericaPage() {
		List<MuseumItems> allSA;
		allSA = repository.getMuseumListSA();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("countryName", "South America");
		mav.addObject("museumList", allSA);
		mav.addObject("path", "./images/maps/sa.png");
		mav.setViewName("region.html");
		return mav;
	}
	
	//Method for Africa list of museums page
	@RequestMapping(value = "/Africa")
	public ModelAndView getAfricaPage() {
		List<MuseumItems> allAfrica;
		allAfrica = repository.getMuseumListAfrica();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("countryName", "Africa");
		mav.addObject("museumList", allAfrica);
		mav.addObject("path", "./images/maps/africa.png");
		mav.setViewName("region.html");
		return mav;
	}
	
	//Method for Asia list of museums page
	@RequestMapping(value = "/Asia")
	public ModelAndView getAsiaPage() {
		List<MuseumItems> allAsia;
		allAsia = repository.getMuseumListAsia();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("countryName", "Asia");
		mav.addObject("museumList", allAsia);
		mav.addObject("path", "./images/maps/asia.png");
		mav.setViewName("region.html");
		return mav;
	}
	
	//Method for Oceania list of museums page
	@RequestMapping(value = "/Oceania")
	public ModelAndView getOceaniaPage() {
		List<MuseumItems> allOceania;
		allOceania = repository.getMuseumListOceania();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("countryName", "Oceania");
		mav.addObject("museumList", allOceania);
		mav.addObject("path", "./images/maps/oceania.png");
		mav.setViewName("region.html");
		return mav;
	}
	
	
	//From now and till the end methods for each museum
	@RequestMapping(value = "/Europe/Louvre")
	public ModelAndView getLouvrePage() throws SQLException {
		ArrayList<MuseumItems> museum;
		museum = repository.executeMuseum("'Louvre'");
		ModelAndView mav = new ModelAndView();
		mav.addObject("museumInfo", museum);
		mav.addObject("countryName", "Oceania");
		mav.setViewName("museum");
		return mav;
	}
	
	@RequestMapping(value = "/Europe/Prado")
	public ModelAndView getPradoPage() throws SQLException {
		ArrayList<MuseumItems> museum;
		museum = repository.executeMuseum("'Prado'");
		ModelAndView mav = new ModelAndView();
		mav.addObject("museumInfo", museum);
		mav.setViewName("museum.html");
		return mav;
	}
	
	@RequestMapping(value = "/Europe/Die Pinakotheken")
	public ModelAndView getPinakothekenPage() throws SQLException {
		ArrayList<MuseumItems> museum;
		museum = repository.executeMuseum("'Die Pinakotheken'");
		ModelAndView mav = new ModelAndView();
		mav.addObject("museumInfo", museum);
		mav.setViewName("museum.html");
		return mav;
	}
	
	@RequestMapping(value = "/North America/Royal Ontario Museum")
	public ModelAndView getRoyalOntarioPage() throws SQLException {
		ArrayList<MuseumItems> museum;
		museum = repository.executeMuseum("'Royal Ontario Museum'");
		ModelAndView mav = new ModelAndView();
		mav.addObject("museumInfo", museum);
		mav.setViewName("museum.html");
		return mav;
	}
	
	@RequestMapping(value = "/North America/Metropolitan")
	public ModelAndView getMetropolitanPage() throws SQLException {
		ArrayList<MuseumItems> museum;
		museum = repository.executeMuseum("'Metropolitan'");
		ModelAndView mav = new ModelAndView();
		mav.addObject("museumInfo", museum);
		mav.setViewName("museum.html");
		return mav;
	}
	
	@RequestMapping(value = "/North America/Museo Maya de Cancun")
	public ModelAndView getMMdCPage() throws SQLException {
		ArrayList<MuseumItems> museum;
		museum = repository.executeMuseum("'Museo Maya de Cancun'");
		ModelAndView mav = new ModelAndView();
		mav.addObject("museumInfo", museum);
		mav.setViewName("museum.html");
		return mav;
	}
	
	@RequestMapping(value = "/South America/Imperial Museum")
	public ModelAndView getImperialMuseumPage() throws SQLException {
		ArrayList<MuseumItems> museum;
		museum = repository.executeMuseum("'Imperial Museum'");
		ModelAndView mav = new ModelAndView();
		mav.addObject("museumInfo", museum);
		mav.setViewName("museum.html");
		return mav;
	}
	
	@RequestMapping(value = "/South America/National Museum of Fine Arts")
	public ModelAndView getFineArtsPage() throws SQLException {
		ArrayList<MuseumItems> museum;
		museum = repository.executeMuseum("'National Museum of Fine Arts'");
		ModelAndView mav = new ModelAndView();
		mav.addObject("museumInfo", museum);
		mav.setViewName("museum.html");
		return mav;
	}
	
	@RequestMapping(value = "/South America/Museum of Italian Art")
	public ModelAndView getItalianArtPage() throws SQLException {
		ArrayList<MuseumItems> museum;
		museum = repository.executeMuseum("'Museum of Italian Art'");
		ModelAndView mav = new ModelAndView();
		mav.addObject("museumInfo", museum);
		mav.setViewName("museum.html");
		return mav;
	}
	
	@RequestMapping(value = "/Africa/Melrose House")
	public ModelAndView getMelrosePage() throws SQLException {
		ArrayList<MuseumItems> museum;
		museum = repository.executeMuseum("'Melrose House'");
		ModelAndView mav = new ModelAndView();
		mav.addObject("museumInfo", museum);
		mav.setViewName("museum.html");
		return mav;
	}
	
	@RequestMapping(value = "/Africa/Museum of Marrakech")
	public ModelAndView getMarrakechPage() throws SQLException {
		ArrayList<MuseumItems> museum;
		museum = repository.executeMuseum("'Museum of Marrakech'");
		ModelAndView mav = new ModelAndView();
		mav.addObject("museumInfo", museum);
		mav.setViewName("museum.html");
		return mav;
	}
	
	@RequestMapping(value = "/Africa/House of Slaves")
	public ModelAndView getHouseSlavesPage()  throws SQLException {
		ArrayList<MuseumItems> museum;
		museum = repository.executeMuseum("'House of Slaves'");
		ModelAndView mav = new ModelAndView();
		mav.addObject("museumInfo", museum);
		mav.setViewName("museum.html");
		return mav;
	}
	
	@RequestMapping(value = "/Asia/Islamic Arts Museum")
	public ModelAndView getIslamicArtPage()  throws SQLException {
		ArrayList<MuseumItems> museum;
		museum = repository.executeMuseum("'Islamic Arts Museum'");
		ModelAndView mav = new ModelAndView();
		mav.addObject("museumInfo", museum);
		mav.setViewName("museum.html");
		return mav;
	}
	
	@RequestMapping(value = "/Asia/Ullen Sentalu Museum")
	public ModelAndView getUllenPage()  throws SQLException {
		ArrayList<MuseumItems> museum;
		museum = repository.executeMuseum("'Ullen Sentalu Museum'");
		ModelAndView mav = new ModelAndView();
		mav.addObject("museumInfo", museum);
		mav.setViewName("museum.html");
		return mav;
	}
	
	@RequestMapping(value = "/Asia/The Palace Museum")
	public ModelAndView getPalacePage()  throws SQLException {
		ArrayList<MuseumItems> museum;
		museum = repository.executeMuseum("'The Palace Museum'");
		ModelAndView mav = new ModelAndView();
		mav.addObject("museumInfo", museum);
		mav.setViewName("museum.html");
		return mav;
	}
	
	@RequestMapping(value = "/Oceania/Australian War Memorial")
	public ModelAndView getWarPage() throws SQLException {
		ArrayList<MuseumItems> museum;
		museum = repository.executeMuseum("'Australian War Memorial'");
		ModelAndView mav = new ModelAndView();
		mav.addObject("museumInfo", museum);
		mav.setViewName("museum.html");
		return mav;
	}
	
	@RequestMapping(value = "/Oceania/Museum of Old and New Art")
	public ModelAndView getOldNewPage() throws SQLException {
		ArrayList<MuseumItems> museum;
		museum = repository.executeMuseum("'Museum of Old and New Art'");
		ModelAndView mav = new ModelAndView();
		mav.addObject("museumInfo", museum);
		mav.setViewName("museum.html");
		return mav;
	}
	
	@RequestMapping(value = "/Oceania/Museum of New Zealand")
	public ModelAndView getNewZPage() throws SQLException {
		ArrayList<MuseumItems> museum;
		museum = repository.executeMuseum("'Museum of New Zealand'");
		ModelAndView mav = new ModelAndView();
		mav.addObject("museumInfo", museum);
		mav.setViewName("museum.html");
		return mav;
	}
	

}