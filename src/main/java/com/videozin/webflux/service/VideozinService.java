package com.videozin.webflux.service;

import com.videozin.webflux.document.Videozin;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface VideozinService {

    public Flux<Videozin> findAll();

    public Mono<Videozin> findById(String id);

    public Mono<Videozin> save(Videozin videozin);
}
