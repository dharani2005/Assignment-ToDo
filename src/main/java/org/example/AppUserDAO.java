package org.example;

import java.util.Collection;

public interface AppUserDAO {
    AppUser persist(AppUser appUser);
    AppUser findByUsername(String userName);
    Collection<AppUser> findAll();
    void remove(String userName);
}
