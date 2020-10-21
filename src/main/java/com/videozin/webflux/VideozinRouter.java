package com.videozin.webflux;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

//@Configuration
public class VideozinRouter {

//    @Bean
    public RouterFunction<ServerResponse> route(VideozinHandler handler){
        return RouterFunctions
                .route(GET("/videozin").and(accept(MediaType.APPLICATION_JSON)), handler::findAll)
                .andRoute(GET("/videozin/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::findById)
                .andRoute(POST("/videozin").and(accept(MediaType.APPLICATION_JSON)), handler::save);
    }
}
