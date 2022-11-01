package com.yicj.hello.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Optional;


@Slf4j
@Configuration
public class AppConfig {

    @Bean
    public GlobalFilter filter1(){
        return new CustomOrderFilter("filter1", -1) ;
    }

    @Bean
    public GlobalFilter filter2(){
        return new CustomOrderFilter("filter2", 0) ;
    }

    @Bean
    public GlobalFilter filter3(){
        return new CustomOrderFilter("filter3", 1) ;
    }


    @RequiredArgsConstructor
    class CustomOrderFilter implements GlobalFilter, Ordered {

        private final String filterName ;

        private final Integer order ;

        @Override
        public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
            log.info("{} pre ...", filterName);
            return chain.filter(exchange)
                    .then(Mono.fromRunnable(() -> log.info("{} post ..", filterName)));
        }

        @Override
        public int getOrder() {
            return Optional.ofNullable(order)
                    .orElse(0);
        }
    }

}