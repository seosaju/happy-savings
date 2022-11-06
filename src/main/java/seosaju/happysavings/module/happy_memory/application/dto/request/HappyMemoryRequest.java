package seosaju.happysavings.module.happy_memory.application.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class HappyMemoryRequest {

    @Getter
    @Setter
    public static class Write {

        @NotBlank
        private String memberId;

        @NotNull
        private Long storageId;

        @NotBlank
        private String content;
    }
}
