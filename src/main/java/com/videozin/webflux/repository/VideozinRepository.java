package com.videozin.webflux.repository;

import com.videozin.webflux.document.Videozin;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

public interface VideozinRepository extends ReactiveMongoRepository<Videozin, String> {
}
