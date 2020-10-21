package com.videozin.webflux;

import com.videozin.webflux.document.Videozin;
import com.videozin.webflux.service.VideozinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

//@Component
public class VideozinHandler {

    @Autowired
    VideozinService service;

    public Mono<ServerResponse> findAll(ServerRequest request){
        return ok().contentType(MediaType.APPLICATION_JSON)
                .body(service.findAll(), Videozin.class);
    }

    public Mono<ServerResponse> findById(ServerRequest request){
        return ok().contentType(MediaType.APPLICATION_JSON)
                .body(service.findById(request.pathVariable("id")), Videozin.class);
    }

    public Mono<ServerResponse> save(ServerRequest request){
        final Mono<Videozin> videozin = request.bodyToMono(Videozin.class);
        return ok().contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(videozin.flatMap(service::save), Videozin.class));
    }



}
