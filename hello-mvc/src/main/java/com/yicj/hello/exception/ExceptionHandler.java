package com.yicj.hello.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@Order(-99)
public class ExceptionHandler implements WebExceptionHandler {
    @Override
    public Mono<Void> handle(ServerWebExchange serverWebExchange, Throwable throwable) {
        log.info("========= global exception ... =========");
        ServerHttpResponse response = serverWebExchange.getResponse();
        response.setStatusCode(HttpStatus.BAD_REQUEST);
        response.getHeaders().setContentType(MediaType.TEXT_PLAIN);
        String errorMsg = toStr(throwable);
        DataBuffer db = response.bufferFactory().wrap(errorMsg.getBytes());
        return response.writeWith(Mono.just(db));
    }
 
    private String toStr(Throwable throwable) {
        //已知异常，自定义异常，这里懒得写了，就随便找一个代替
        if (throwable instanceof NumberFormatException){
            NumberFormatException e = (NumberFormatException) throwable;
            return e.getMessage();
        }
        //未知异常
        throwable.printStackTrace();
        return throwable.toString();
    }
}