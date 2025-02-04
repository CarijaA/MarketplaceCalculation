package com.example.MarketplaceCalculation.Controller;


import com.example.MarketplaceCalculation.Domain.Dto.CalculationDto;
import com.example.MarketplaceCalculation.Domain.Services.MarketplaceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/marketplaceCalculation")
public class MarketplaceController {

    @Autowired
    MarketplaceService marketplaceService;


    @PostMapping
    @CrossOrigin(origins = "http//localhost:5173")
    public ResponseEntity marketplaceCalculation(@RequestBody @Valid CalculationDto calculationDto) {

    var result = marketplaceService.calculationFee(calculationDto);
        return ResponseEntity.status    (HttpStatus.CREATED).body(result);

    }


    

    


}
