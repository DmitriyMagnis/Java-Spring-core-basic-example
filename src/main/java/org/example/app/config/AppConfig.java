package org.example.app.config;

import org.example.app.controller.EmployeeController;
import org.example.app.entity.Message;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// Spring сканує файли, які знаходяться в пакеті org.example.app
@ComponentScan("org.example.app")
public class AppConfig {

    // Конфігурація через створення об'єкту біна
    // та виклик його метоу
    @Bean
    public Message doMessage() {
        Message message = new Message();
        message.setMessage("This is super secret message.");
        return message;
    }
}
