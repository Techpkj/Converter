package com.example.converter.controller;

import com.example.converter.dto.ConversionRequest;
import com.example.converter.dto.ConversionResponse;
import com.example.converter.service.ConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")  // Allow frontend to call API from any origin
public class ConversionController {

    private final ConversionService conversionService;

    @Autowired
    public ConversionController(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @PostMapping("/convert")
    public ConversionResponse convert(@RequestBody ConversionRequest request) {
        return conversionService.convert(request);
    }
}
