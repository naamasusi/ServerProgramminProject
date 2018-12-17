package com.sportevent.main.domain.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sportevent.main.domain.CategoryRepository;
import com.sportevent.main.domain.Event;
import com.sportevent.main.domain.EventRepository;

@Controller
public class EventController {
	@Autowired
	private EventRepository erepository; 

	@Autowired
	private CategoryRepository crepository; 
	
	// LogIn
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }
    
    // SignUp
    //@RequestMapping(value = "/signup")
    //public String signUp(){
        //return "signup";
    //}
	
	// Show all EVENTS
    @RequestMapping(value="/eventlist")
    public String eventList(Model model) {	
        model.addAttribute("events", erepository.findAll());
        return "eventlist";
    }
  
	// RESTful service to get all events
    @RequestMapping(value="/events")
    public @ResponseBody List<Event> eventListRest() {	
        return (List<Event>) erepository.findAll();
    }    

	// RESTful service to get EVENT by id
    @RequestMapping(value="/event/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Event> findEventRest(@PathVariable("id") Long eventId) {	
    	return erepository.findById(eventId);
    }       
    
    // Add new EVENT
    @RequestMapping(value = "/add")
    public String addEvent(Model model){
    	model.addAttribute("event", new Event());
    	model.addAttribute("categories", crepository.findAll());
        return "addevent";
    }     
    
    // Save new EVENT
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Event event){
    	erepository.save(event);
        return "redirect:eventlist";
    }    

    // Delete EVENT
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteEvent(@PathVariable("id") Long eventId, Model model) {
    	erepository.deleteById(eventId);
        return "redirect:../eventlist";
    }     
}
