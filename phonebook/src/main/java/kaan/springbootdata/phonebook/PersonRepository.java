package kaan.springbootdata.phonebook;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, String> {

	public Person findByPhone(String phone);
	
}
