package com.montebello.noivern.API.Controllers;

import com.montebello.noivern.API.RateLimit.RateLimiter;
import com.montebello.noivern.UseCases.BinarySearch.BinarySearchBus;
import com.montebello.noivern.UseCases.Sort.Bubble.BubbleSortBus;
import com.montebello.noivern.UseCases.Sort.Quick.QuickSortBus;
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

    @GetMapping("/api/algorithm/linearSearch")
    @RateLimiter(requests = 5, timeWindow = 60)
    public ResponseEntity<Algorithm> getLinearSearch() {
        var algorithm = useCasesBus.getUseCaseBus(new BinarySearchBus());
        return ResponseEntity.ok(algorithm);
    }

    @GetMapping("/api/algorithm/quickSort")
    @RateLimiter(requests = 5, timeWindow = 60)
    public ResponseEntity<Algorithm> getQuickSort() {
        var algorithm = useCasesBus.getUseCaseBus(new QuickSortBus());
        return ResponseEntity.ok(algorithm);
    }

    @GetMapping("/api/algorithm/bubbleSort")
    @RateLimiter(requests = 5, timeWindow = 60)
    public ResponseEntity<Algorithm> getBubbleSort() {
        var algorithm = useCasesBus.getUseCaseBus(new BubbleSortBus());
        return ResponseEntity.ok(algorithm);
    }
}
