package com.ipetrovic.master.messagingcalendar.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipetrovic.master.messagingcalendar.model.Predmet;
import com.ipetrovic.master.messagingcalendar.model.PredmetRok;
import com.ipetrovic.master.messagingcalendar.model.PredmetRokPK;
import com.ipetrovic.master.messagingcalendar.model.Rok;
import com.ipetrovic.master.messagingcalendar.model.User;
import com.ipetrovic.master.messagingcalendar.service.PredmetRokService;
import com.ipetrovic.master.messagingcalendar.service.PredmetService;
import com.ipetrovic.master.messagingcalendar.service.RokService;
import com.ipetrovic.master.messagingcalendar.service.UserService;

@RestController
@RequestMapping("rest")
public class AdminController {
	
	private int ispitRokCount; 
	
    @Autowired private UserService userService;
    @Autowired private RokService rokService; 
    @Autowired private PredmetService predmetService; 
    @Autowired private PredmetRokService predmetRokService; 
    
    @RequestMapping(value = "/userinfo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object dajPodatkeTrenutnogKorisnika(Principal principal) {
        User u = userService.findUserByEmail(principal.getName());
        
        List<Object> result = new ArrayList<>();
        
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("user_id", u.getUserId()); 
        userInfo.put("username", u.getUsername()); 
        userInfo.put("password", u.getPassword()); 
        userInfo.put("rola_id", u.getRole().getId()); 
        userInfo.put("rola", u.getRole().getRole()); 
        result.add(userInfo); 
        
        return result;
    }
    
    @RequestMapping(value = "/rok", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String kreirajRok(Principal principal, @RequestBody Map<String, Object> data) {
    	Rok r = new Rok(); 
    	String nazivRoka = (String) data.get("naziv"); 
    	Long godinaRoka = ((Integer) data.get("godina")).longValue(); 
    	r.setNaziv(nazivRoka);
    	r.setGodina(godinaRoka);
    	
    	try {
    		rokService.save(r);
    		
    		List<Predmet> listaSvihPredmeta = predmetService.findAll(); 
    		Set<PredmetRok> predmetRokSet = new HashSet<>(); 
    		for (Predmet predmet : listaSvihPredmeta) {
    			PredmetRokPK prPk = new PredmetRokPK(); 
    			prPk.setPredmetAkronim(predmet.getAkronim());
    			prPk.setRokId(r.getRokId());
    			
    			
    			PredmetRok pr = new PredmetRok(); 
    			pr.setId(prPk);
    			pr.setPredmet(predmet);
    			pr.setDatum(dajDatumIspita(nazivRoka, godinaRoka));
    			pr.setRok(r);
    			predmetRokSet.add(pr); 
    			predmetRokService.save(pr);
			}
    		return "rokId: " + r.getRokId(); 
    	} catch (Exception e) {
    		return "fail: " + e.getMessage(); 
		}
    }
    
    @RequestMapping(value = "/predmet", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String kreirajPredmet(Principal principal, @RequestBody Map<String, Object> data) {
    	Predmet p = new Predmet(); 
    	String akronimPredmeta = (String) data.get("akronim");
    	String godinaStudijaPredmeta = (String) data.get("godinaStudija");
    	String nazivPredmeta = (String) data.get("naziv");
    	String tipPredmeta = (String) data.get("tipPredmeta");
    	p.setAkronim(akronimPredmeta);
    	p.setGodinaStudija(godinaStudijaPredmeta);
    	p.setNaziv(nazivPredmeta);
    	p.setTipPredmeta(tipPredmeta);
    	
    	try {
    		predmetService.save(p);
    		
    		List<Rok> listaSvihRokova = rokService.findAll(); 
    		Set<PredmetRok> predmetRokSet = new HashSet<>(); 
    		
    		for (Rok rok : listaSvihRokova) {
    			PredmetRokPK prPk = new PredmetRokPK(); 
    			prPk.setPredmetAkronim(p.getAkronim());
    			prPk.setRokId(rok.getRokId());
    			
    			
    			PredmetRok pr = new PredmetRok(); 
    			pr.setId(prPk);
    			pr.setPredmet(p);
    			pr.setDatum(dajDatumIspita(rok.getNaziv(), rok.getGodina()));
    			pr.setRok(rok);
    			predmetRokSet.add(pr); 
    			predmetRokService.save(pr);
			}
    		return "predmetAkronim: " + p.getAkronim(); 
    	} catch (Exception e) {
    		return "fail: " + e.getMessage(); 
		}
    }

	private Date dajDatumIspita(String nazivRoka, Long godinaRoka) {
		Random rn = new Random(); 
		int sat = 8 + ((ispitRokCount + rn.nextInt(8) + 1) % 8); 
		int dan = 1; 
		int mesec = 1; 
		switch (nazivRoka) {
		case "Januar":
			dan = 15 + ((ispitRokCount + rn.nextInt(15) + 1) % 16); 
			mesec = 0; 
			break;
		case "Februar":
			dan = (ispitRokCount + rn.nextInt(15) + 1) % 28; 
			mesec = 1; 
			break;
		case "Jun":
			dan = (ispitRokCount + rn.nextInt(15) + 1) % 30; 
			mesec = 5; 
			break;
		case "Septembar":
			dan = (ispitRokCount + rn.nextInt(15) + 1) % 15; 
			mesec = 8; 
			break;
		case "Oktobar":
			dan = 15 + ((ispitRokCount + rn.nextInt(15) + 1) % 15); 
			mesec = 8; 
			break;
		default:
			dan = 1; 
			mesec = 9; 
			sat = 12; 
		}
		Calendar cal = Calendar.getInstance(); 
		cal.set(godinaRoka.intValue(), mesec, dan, sat, 0);
		return cal.getTime(); 
	}
    
}
