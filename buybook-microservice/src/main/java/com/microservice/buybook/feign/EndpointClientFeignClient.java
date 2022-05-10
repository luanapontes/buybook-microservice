package com.microservice.buybook.feign;

import com.microservice.buybook.buybookmicroservice.ClientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//"http://localhost:9098/clients"
@FeignClient(name = "client-microservice", url = "http://localhost:9191/client-microservice/clients")
public interface EndpointClientFeignClient {

    @GetMapping(value = "/id/{specificID}")
    ClientDTO findSpecificID(@PathVariable String specificID);

}
