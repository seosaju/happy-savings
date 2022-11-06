package seosaju.happysavings.module.happy_memory.application;

import seosaju.happysavings.module.happy_memory.application.dto.request.HappyMemoryRequest;

public interface WriteHappyMemoryService {

    long write(HappyMemoryRequest.Write request);
}
