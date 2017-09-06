package kaan.springbootdata.phonebook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@RequestMapping("/")
	public String loadMain(Model model) {
		//TODO: Implement, take into consideration adding new instances. (model.addAttribute)
		List<Person> persons = personService.getAllPersons();
		Person newP = new Person();
		model.addAttribute("newperson", newP);
		model.addAttribute("persons", persons);
		return "index";
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String addNewPerson(@ModelAttribute(value="newperson") Person person, Model model) {
		personService.addPerson(person);
		
		return loadMain(model); //Or can be changed to the newly added person's page.
	}
	
	@RequestMapping(value="/{id}")
	public String getOnePerson(@PathVariable String id, Model model) {
		Person p = personService.getPersonById(id);
		model.addAttribute("person", p);
		
		return "oneperson";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public String updatePerson(@PathVariable String id, @ModelAttribute(value="newperson") Person person) {
		personService.replace(id, person);
		return "oneperson";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public String deletePerson(@PathVariable String id, Model model) {
		personService.deleteById(id);
		return loadMain(model); //OR you may consider calling loadMain()
	}
	
	
	
}
