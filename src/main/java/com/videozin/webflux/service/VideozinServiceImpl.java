package com.videozin.webflux.service;

import com.videozin.webflux.document.Videozin;
import com.videozin.webflux.repository.VideozinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class VideozinServiceImpl implements VideozinService {

    @Autowired
    VideozinRepository repository;

    @Override
    public Flux<Videozin> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<Videozin> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Mono<Videozin> save(Videozin videozin) {
        return repository.save(videozin);
    }


}
