package de.moviereviews.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.graphql.server.webmvc.GraphiQlHandler;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;


// https://docs.spring.io/spring-graphql/reference/graphiql.html
@Configuration
public class GraphiQlConfig {
    @Bean
    @Order(0)
    public RouterFunction<ServerResponse> graphiQlRouterFunction() {
        var builder = RouterFunctions.route();
        var graphiQlPage = new ClassPathResource("graphiql/index.html");
        var graphiQLHandler = new GraphiQlHandler("/graphql", "", graphiQlPage);
        builder = builder.GET("/graphiql", graphiQLHandler::handleRequest);
        return builder.build();
    }
}