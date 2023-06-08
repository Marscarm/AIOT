package com.example.aiot.conf;

import java.util.Arrays;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

/**
 * 基础配置
 *
 * @author ju.wang@sophgo.com
 */
@Configuration
@Slf4j
public class BaseConfig {

    /**
     * 用于远程调用
     *
     * @return {@link RestTemplate}对象
     */
    @Bean(name = "remoteRestTemplate")
    RestTemplate remoteRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler());
        // 增加类型支持
        MappingJackson2HttpMessageConverter msgConverter = new MappingJackson2HttpMessageConverter();
        msgConverter.setSupportedMediaTypes(Arrays.asList(
                MediaType.TEXT_HTML,
                MediaType.TEXT_PLAIN,
                MediaType.APPLICATION_OCTET_STREAM
        ));
        restTemplate.getMessageConverters().add(msgConverter);
        // 设置请求拦截器
        return restTemplate;
    }

    /**
     * 用于远程长时间调用
     *
     * @return {@link RestTemplate}对象
     */
    @Bean(name = "remoteLongRestTemplate")
    RestTemplate remoteLongRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler());
        // 设置请求拦截器
        return restTemplate;
    }

    /**
     * 用于服务间调用
     *
     * @return {@link RestTemplate}对象
     */
    @Bean(name = "balanceRestTemplate")
    @LoadBalanced
    RestTemplate balanceRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler());
        // 设置请求拦截器
        return restTemplate;
    }
}
