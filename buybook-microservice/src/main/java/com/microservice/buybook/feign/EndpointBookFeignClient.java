package com.microservice.buybook.feign;

import com.microservice.buybook.buybookmicroservice.BookDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//"http://localhost:9096/books"
@FeignClient(name = "book-microservice", url = "http://localhost:9191/book-microservice/books")
public interface EndpointBookFeignClient {

    @GetMapping(value = "/id/{specificID}")
    BookDTO findSpecificID(@PathVariable String specificID);
}
