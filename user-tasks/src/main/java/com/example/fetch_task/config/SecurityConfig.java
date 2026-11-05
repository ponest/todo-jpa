package com.example.fetch_task.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.web.servlet.function.RequestPredicates.path;
import static org.springframework.cloud.gateway.server.mvc.filter.FilterFunctions.stripPrefix;
import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;
import static org.springframework.web.servlet.function.RequestPredicates.path;
import static org.springframework.cloud.gateway.server.mvc.filter.BeforeFilterFunctions.uri;



import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;

@Configuration
public class SecurityConfig {

    private static final Logger log = LoggerFactory.getLogger(SecurityConfig.class);

//    //    KUPITISHA STATIC BEARER TOKEN
//    @Bean
//    public RouterFunction<ServerResponse> taskRoute() {
//        return route("fetch-task")
//                .route(path("/fetch-task/user/**"), http())
//                .before(uri("http://localhost:9011"))
//
//                // Add Bearer Token
//                .before(request -> ServerRequest.from(request)
//                        .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJnb2RsaXN0ZW5AdGVzdC5jb20iLCJpYXQiOjE3OTMzNjMxNDYsImV4cCI6MTc5MzM2Njc0Nn0.0x7yoai3NcKEEFBhGXZi6l7LKhFCZZXXVX9zf8ELLuQ")
//                        .build())
//
//                // Logging Filter
//                .filter((request, next) -> {
//
//                    long startTime = System.currentTimeMillis();
//
//                    log.info("=========================================");
//                    log.info("Incoming Request: {} {}",
//                            request.method(),
//                            request.uri().getPath());
//                    log.info("=========================================");
//
//                    ServerResponse response = next.handle(request);
//
//                    long duration = System.currentTimeMillis() - startTime;
//
//                    log.info("=========================================");
//                    log.info("Outgoing Response for: {}",
//                            request.uri().getPath());
//                    log.info("HTTP Status: {}", response.statusCode());
//                    log.info("Execution Time: {} ms", duration);
//                    log.info("=========================================");
//
//                    return response;
//                })
//                .build();
//    }


    //    MODIFY BEARER TOKEN

//    @Bean
//    public RouterFunction<ServerResponse> taskRoute() {
//        return route("task-route")
//                .route(path("/**"), http())
//                .before(uri("http://localhost:8086"))
//
//                // Modify incoming Bearer Token
//                .before(request -> {
//
//                    String authorization = request.headers()
//                            .firstHeader("Authorization");
//
//                    if (authorization != null &&
//                            authorization.startsWith("Bearer ")) {
//
//                        // Extract incoming token
//                        String originalToken = authorization.substring(7);
//
//                        // Modify token dynamically
//                        String modifiedToken = originalToken + "-modified";
//
//                        log.info("modified Token {}",modifiedToken);
//
//                        // Replace Authorization header
//                        return ServerRequest.from(request)
//                                .headers(headers ->
//                                        headers.setBearerAuth(modifiedToken))
//                                .build();
//                    }
//
//                    return request;
//                })
//
//                // Logging
//                .filter((request, next) -> {
//
//                    long startTime = System.currentTimeMillis();
//                    log.info("Incoming Request: {} {}",
//                            request.method(),
//                            request.uri().getPath());
//
//                    ServerResponse response = next.handle(request);
//
//                    log.info("HTTP Status: {}", response.statusCode());
//
//                    log.info("Execution Time: {} ms",
//                            System.currentTimeMillis() - startTime);
//
//                    return response;
//                })
//                .build();
//    }
}
