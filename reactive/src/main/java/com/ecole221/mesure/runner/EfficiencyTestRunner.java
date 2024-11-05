package com.ecole221.mesure.runner;

import com.ecole221.mesure.repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
@ConditionalOnProperty(value = "efficiency.test", havingValue = "true")
public class EfficiencyTestRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(EfficiencyTestRunner.class);

    @Autowired
    private ClientRepository repository;

    @Override
    public void run(String... args) {
        var atomicInteger = new AtomicInteger(0);
        log.info("{démarrage}");
        repository.findAll()
        .doOnNext(c -> {
            // for every customer, increment
            // print for every million
            var count = atomicInteger.incrementAndGet();
            if (count % 1_000_000 == 0) {
                log.info("{}", count);
            }
        }).then().block();
        log.info("terminé");
    }

}