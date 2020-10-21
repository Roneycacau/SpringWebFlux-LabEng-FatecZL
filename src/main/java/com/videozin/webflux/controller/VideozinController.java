package com.videozin.webflux.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.videozin.webflux.document.Videozin;
import com.videozin.webflux.service.VideozinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/videozin")
public class VideozinController {

    @Autowired
    VideozinService service;

    @GetMapping
    public Flux<Videozin> getAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Videozin> getById(@PathVariable String id){
        return service.findById(id);
    }

    @PostMapping
    public Mono<Videozin> add(@RequestBody Videozin videozin){
        return service.save(videozin);
    }

    @GetMapping(value = "/event", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tuple2<Long, Videozin>> getVideozinEvent(){
        System.out.println("Começa agora a sessão Nostalgia" + LocalDateTime.now());
        Flux<Long> intervalo = Flux.interval(Duration.ofSeconds(5));
        Flux<Videozin> videozinFlux = service.findAll();

        return Flux.zip(intervalo, videozinFlux);
    }
}
