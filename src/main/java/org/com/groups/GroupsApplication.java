package org.com.groups;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
public class   GroupsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GroupsApplication.class, args);
    }

}
