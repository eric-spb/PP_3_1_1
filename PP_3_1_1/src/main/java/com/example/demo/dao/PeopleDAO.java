package com.example.demo.dao;

import com.example.demo.model.*;
import jakarta.persistence.*;
import jakarta.transaction.*;
import org.springframework.stereotype.*;



import java.util.*;

@Repository
@Transactional
@Component
public class PeopleDAO {

    @PersistenceContext
    private EntityManager em;

    public List<User> getPeople() {
     return em.createQuery("select p from User p", User.class).getResultList();
    }


    public User look(int id) {
        return em.find(User.class, id);
    }


    public void save(User user) {
        em.persist(user);
    }

    public void delete(int id) {
        em.createQuery("delete from User p where p.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    public void update(int id, User updatedUser) {
        User toUpdate = look(id);

        toUpdate.setName(updatedUser.getName());
        toUpdate.setAge(updatedUser.getAge());
        toUpdate.setSurname(updatedUser.getSurname());

        em.merge(toUpdate);
    }
}
