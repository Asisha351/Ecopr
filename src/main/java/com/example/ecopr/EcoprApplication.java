package com.example.ecopr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.example.ecopr.repository.CategoriesRepository;

@SpringBootApplication(exclude = {
    org.springframework.boot.autoconfigure.batch.BatchAutoConfiguration.class,
    org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration.class
})
public class EcoprApplication {

	@Autowired
    private CategoriesRepository categoriesRepository;

    public static void main(String[] args) {
        SpringApplication.run(EcoprApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void testRepositories() {
        System.out.println("Categories count: " + categoriesRepository.count());
    }


}
