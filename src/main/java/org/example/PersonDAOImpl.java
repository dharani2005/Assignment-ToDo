package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class PersonDAOImpl implements PersonDAO{
    private List<Person> personList = new ArrayList<>();
    public PersonDAOImpl() {
        super();
    }

    @Override
    public Person persist(Person person) {
        if(person==null)throw new IllegalArgumentException("Todoitem cannot be null");
        for(Person persons:personList)
        {
            if(persons.getEmail().equals(person.getEmail())){
                throw new IllegalArgumentException("Todoitem cannot be same title");
            }
        }
        int id = PersonIdSequencer.nextId();
        person.setId(id);
        personList.add(person);
        return person;
    }

    @Override
    public Person findById(int id) {
        for(Person person:personList)
        {
            if(person.getId()==id)
            {
                return person;
            }
        }
        throw  new IllegalArgumentException("person with this id is not found");
    }

    @Override
    public Person findByEmail(String email) {
        for(Person person:personList){
            if(person.getEmail()==email){
                return person;
            }
        }
        throw new IllegalArgumentException("person with this email is not found");
    }

    @Override
    public Collection<Person> findAll() {
        return new ArrayList<>(personList);
    }

    @Override
    public void remove(int id) {
     for(Person person:personList){
         if(person.getId()==id){
             personList.remove(person);
         }
     }
     throw new IllegalArgumentException("person with this id is not found to remove");
    }
}
