//package com.codestates.gym.basic;
//
//import com.codestates.gym.entity.Gym;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//
//@Configuration
//public class JpaBasicConfig {
//    private EntityManager em;
//
//    // (2)
//    @Bean
//    public CommandLineRunner testJpaBasicRunner(EntityManagerFactory emFactory) {
//        this.em = emFactory.createEntityManager();
//
//        return args -> {
//            example01();
//        };
//    }
//    public void example01() {
//        Gym gym =  new Gym(1L,"해리스짐","123","141","123",3333.3,3333.3);
//
//
//        em.persist(gym);
//
//        Gym resultGym = em.find(Gym.class,1L);
//        System.out.println("Id: " + resultGym.getGymId() + ", gymName: "+ resultGym.getGymId());
//
//    }
//}