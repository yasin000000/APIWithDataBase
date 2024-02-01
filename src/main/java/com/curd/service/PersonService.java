package com.curd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curd.model.Person;
import com.curd.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Optional<Person> getPersonById(Long id) {
        return personRepository.findById(id);
    }

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
    
    public Person updatePerson(Long id, Person updatedPerson) {
        // Check if the person with the given id exists
        Optional<Person> existingPersonOptional = personRepository.findById(id);

        if (existingPersonOptional.isPresent()) {
            // Update the existing person with the new values
            Person existingPerson = existingPersonOptional.get();
            existingPerson.setName(updatedPerson.getName());
            existingPerson.setAge(updatedPerson.getAge());
            // Update other fields as needed

            // Save the updated person
            return personRepository.save(existingPerson);
        } else {
            // Person with the given id not found, you can handle it accordingly (throw exception, return null, etc.)
            // For simplicity, I'm returning null here
            return null;
        }
    }
    
    
    
}
