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
        if(person == null)throw new IllegalArgumentException("person should not be null");
        int id=PersonIdSequencer.nextId();
        person.setId(id);
        for(Person person1:personList)
        {
            if(personList.contains(person1))
            {
                throw new IllegalArgumentException("This person is already created");
            }
              if(person1.getId()==person.getId())
              {
                  personList.add(person1);
                }
            return person1;
        }
        // Optional<Person> personOptional = findByEmail(person.getEmail());
        return null;
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
