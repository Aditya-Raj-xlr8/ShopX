package com.shopx.search_service.config;

import com.shopx.search_service.client.ProductClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class RestClientConfig {

    @Value("${product.service.url}")
    private String productServiceUrl;

    @Bean
    public ProductClient getProductClient() {
        RestClient restClient = RestClient.builder()
                .baseUrl(productServiceUrl) // Replace with your product service URL
                .build();
        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory
                .builderFor(RestClientAdapter.create(restClient))
                .build();
        return httpServiceProxyFactory.createClient(ProductClient.class);
    }
}
