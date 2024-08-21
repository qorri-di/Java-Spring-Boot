package com.qodev.controller.cmd;

import com.qodev.dto.GeneralResponse;
import com.qodev.dto.request.EncryptRequest;
import com.qodev.service.DataEnkripsiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/qodev/v1-api/cryptography")
public class aesCmdController {

    @Autowired
    DataEnkripsiService dataEnkripsiService;

    @PostMapping("/aes-save")
    public GeneralResponse saveController(@RequestBody EncryptRequest request) throws Exception {
        return dataEnkripsiService.save(request);
    }

}
