package com.Streamify;

import com.Streamify.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StreamifyApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamifyApplication.class, args);
    }
}
