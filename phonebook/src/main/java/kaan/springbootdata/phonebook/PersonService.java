package kaan.springbootdata.phonebook;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	public List<Person> getAllPersons() {
		List<Person> returnList = new ArrayList<>();
		personRepository.findAll().forEach(returnList::add);
		return returnList;
	}

	public void addPerson(Person person) {
		personRepository.save(person);
	}

	public Person getPersonById(String id) {
		return personRepository.findOne(id);
	}

	public void replace(String id, Person person) {
		personRepository.save(person);
	}

	public void deleteById(String id) {
		personRepository.delete(id);
	}
	
	
	
	
	
}
