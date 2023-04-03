package com.example.microservice2.services;

import com.example.microservice2.kafka.models.Message;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class MessageService {
    @PersistenceContext
    private EntityManager em;

    public void createMessage(String message) {
        System.out.println("IN HERE");
        Message m = new Message();
        m.setMessage(message);
        em.persist(m);
    }

    public List<Message> getMessages() {
        return em.createQuery("select m from Message m").getResultList();
    }
}
