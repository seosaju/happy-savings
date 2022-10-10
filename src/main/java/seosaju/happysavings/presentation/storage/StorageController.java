package seosaju.happysavings.presentation.storage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import seosaju.happysavings.module.storage.application.StorageService;
import seosaju.happysavings.module.storage.application.dto.request.StorageRequest;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("storage")
public class StorageController {

    private final StorageService storageService;

    @PostMapping
    public ResponseEntity<Long> make(@RequestBody StorageRequest.Make request) {

        Long storageId = storageService.make(request.getMemberId(), request.getName());

        return ResponseEntity.ok(storageId);
    }
}
