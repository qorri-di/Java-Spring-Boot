package com.qodev.controller.qry;

import com.qodev.dto.GeneralResponse;
import com.qodev.dto.request.searchRequest;
import com.qodev.service.DataEnkripsiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/qodev/v1-api/cryptography")
public class aesQryController {

    @Autowired
    DataEnkripsiService dataEnkripsiService;

    @GetMapping("/aes-get")
    public GeneralResponse getController(@RequestBody searchRequest request) throws Exception {
        return dataEnkripsiService.read(request);
    }

}
