package com.montebello.noivern.API.Controllers;

import com.montebello.noivern.API.RateLimit.RateLimiter;
import com.montebello.noivern.UseCases.BinarySearch.BinarySearchBus;
import com.montebello.noivern.UseCases.UseCasesBus;
import com.montebello.noivern.core.models.Algorithm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AlgorithmController {

    private UseCasesBus useCasesBus;
    @GetMapping("/api/algorithm")
    @RateLimiter(requests = 5, timeWindow = 60)
    public String getAlgorithm() {
        return "Algorithm";
    }

    @GetMapping("/api/algorithm/binarySearch")
    @RateLimiter(requests = 5, timeWindow = 60)
    public ResponseEntity<Algorithm> getBinarySearch() {
        var algorithm = useCasesBus.getUseCaseBus(new BinarySearchBus());
        return ResponseEntity.ok(algorithm);
    }
}
