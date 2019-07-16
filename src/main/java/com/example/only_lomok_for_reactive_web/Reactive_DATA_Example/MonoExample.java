package com.example.only_lomok_for_reactive_web.Reactive_DATA_Example;



import com.example.only_lomok_for_reactive_web.Entity.Table_ToDo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;
import reactor.core.publisher.MonoProcessor;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;


@Configuration
public class MonoExample{
    static private Logger LOG =
            LoggerFactory.getLogger(MonoExample.class);


    @Bean
    public CommandLineRunner   runMonoExample() {
        return args -> {
            MonoProcessor <Table_ToDo>  promise = MonoProcessor.create();
            Mono<Table_ToDo> result = promise
                    .doOnSuccess( p->LOG.info( "MONO >> TODO : {]" , p.getDescription() ) )
                    .doOnTerminate( () -> LOG.info( "MONO >> Done " ) )
                    .doOnError( t -> LOG.error( t.getMessage() , t )  )
                    .subscribeOn( Schedulers . single());

            promise.onNext( new Table_ToDo("Buy my ticket from SPring platform 2019") );

            result.block( Duration.ofMillis( 1000 ) );

        };
    }
}
