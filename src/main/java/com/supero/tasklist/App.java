package com.supero.tasklist;

/**
 * Created by christian.tusset on 12/03/2018.
 */

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.supero.tasklist.entidade.Tasklist;
import com.supero.tasklist.persistencia.ITasklist;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {
	
	private static final Logger log = LoggerFactory.getLogger(App.class);
    
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(App.class, args);

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }
    
	@Bean
	public CommandLineRunner demo(ITasklist persist) {
		return (args) -> {
			persist.save(new Tasklist("Criar um Projeto", "Configurar e criar um novo projeto"));
			persist.save(new Tasklist("Configurar Maven", "Realizar configuração do Maven"));
			persist.save(new Tasklist("Controller Angular", "Configurar Controller do Angular"));
		};
	}
}
