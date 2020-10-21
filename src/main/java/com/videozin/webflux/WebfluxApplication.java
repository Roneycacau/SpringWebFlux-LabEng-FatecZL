package com.videozin.webflux;

import com.videozin.webflux.document.Videozin;
import com.videozin.webflux.repository.VideozinRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import reactor.core.publisher.Flux;

import java.util.UUID;

@SpringBootApplication
public class WebfluxApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebfluxApplication.class, args);
    }

//    @Bean
//    CommandLineRunner init (ReactiveMongoOperations operations,
//                            VideozinRepository repository) {
//        return args -> {
//            Flux<Videozin> videozinSeed = Flux.just(
//                    new Videozin(UUID.randomUUID().toString(), "Jeremias Muito Louco", "https://www.youtube.com/watch?v=MsdnufGPG1A"),
//                    new Videozin(UUID.randomUUID().toString(), "O Cara Tussiu", "https://www.youtube.com/watch?v=udaFtXNrryc"),
//                    new Videozin(UUID.randomUUID().toString(), "La Internet", "https://www.youtube.com/watch?v=LybAHotsvOg"),
//                    new Videozin(UUID.randomUUID().toString(), "Mamute pequenino", "https://www.youtube.com/watch?v=jmWfo_zE1pQ"),
//                    new Videozin(UUID.randomUUID().toString(), "Golimar", "https://www.youtube.com/watch?v=tUbgKEsNVO8"),
//                    new Videozin(UUID.randomUUID().toString(), "Te dou um Queijo Jiban", "https://www.youtube.com/watch?v=PfiTGZOJ_f8"),
//                    new Videozin(UUID.randomUUID().toString(), "Coma um Boi", "https://www.youtube.com/watch?v=QLrabsx4U40"),
//                    new Videozin(UUID.randomUUID().toString(), "Um Docin", "https://www.youtube.com/watch?v=vUiWE9rBUeE"))
//                    .flatMap(repository::save);
//
//            videozinSeed
//                    .thenMany(repository.findAll())
//                    .subscribe(System.out::println);
//        };
//    }

}
