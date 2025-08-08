package com.myproject.application;

import com.myproject.dominio.Pessoa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Programa {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
        Pessoa p2 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com");
        Pessoa p3 = new Pessoa(null, "Ana Maria", "ana@gmail.com");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();

        //inicia a transação
        em.getTransaction().begin();
        // persist -> salva no banco de dados
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        //confirma as alterações
        em.getTransaction().commit();
        System.out.println("Pronto!");

        // buscar o objeto por id no banco
        Pessoa p = em.find(Pessoa.class, 2);

        //deletar no bd
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();

    }
}
