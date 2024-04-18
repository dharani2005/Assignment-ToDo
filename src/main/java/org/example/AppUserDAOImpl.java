package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static java.nio.file.Files.find;

public class AppUserDAOImpl implements AppUserDAO{
   private List<AppUser> storage= new ArrayList<>();
    public AppUserDAOImpl() {
        super();
    }

    @Override
    public AppUser persist(AppUser appUser) {
        if(appUser == null)throw new IllegalArgumentException("appuser should not be null");
        if(storage.contains(appUser)){
            throw new IllegalArgumentException("This Appuser is already created");
        }
        for(AppUser appUser1: storage)
        {
            if(appUser1.getUsername().equals(appUser.getUsername()))
            {
                    throw new IllegalArgumentException("This Appuser is already created");

            }

        }
        storage.add(appUser);
        return appUser;
    }

        /*Optional<AppUser> appUserOptional= find(appUser.getUsername());*/




    @Override
    public AppUser findByUsername(String userName) {
        for(AppUser appUser:storage)
        {
            if(appUser.getUsername() == userName){
                return appUser;
            }
        }

        throw new IllegalArgumentException("Appuser not found with this name");
    }

    @Override
    public Collection<AppUser> findAll() {
        return new ArrayList<>(storage);
    }

    @Override
    public void remove(String userName) {
        for(AppUser appUser:storage){
            if(appUser.getUsername()==userName){
                storage.remove(appUser);
            }
            throw new IllegalArgumentException("Appuser not found with this name to remove");
        }

    }
}
