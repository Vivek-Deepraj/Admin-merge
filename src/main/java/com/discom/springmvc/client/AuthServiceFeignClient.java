package com.discom.springmvc.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "auth-service")
public interface AuthServiceFeignClient {

    @PostMapping(value = "/AuthApp/hello")
    String getHello();

    @PostMapping(value = "/AuthApp/oauth/token_key")
    String getTokenKey();

    @PostMapping(value = "/AuthApp/oauth/user")
    String getUser();

}
