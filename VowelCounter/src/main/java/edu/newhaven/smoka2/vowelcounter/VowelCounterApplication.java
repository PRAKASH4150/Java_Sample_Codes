/**
 * VowelCounterApplication.java: This program will act as the
 * entry point for the program.
 *
 * @author Sai Surya Prakash Moka
 *
 * @date 10-12-2023
 */
package edu.newhaven.smoka2.vowelcounter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;


@SpringBootApplication(scanBasePackages={
        "edu.newhaven.smoka2.*"})
public class VowelCounterApplication {

    public static void main(String[] args) {

        SpringApplication.run(VowelCounterApplication.class, args);

    }
}
