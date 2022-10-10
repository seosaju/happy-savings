package seosaju.happysavings.module.storage.application.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class StorageRequest {

    @Getter
    @Setter
    public static class Make {

        @NotBlank
        private String memberId;

        @NotBlank
        @Max(100)
        private String name;
    }

    @Getter
    @Setter
    public static class ChangeName {

        @NotNull
        private long storageId;

        @NotBlank
        @Max(100)
        private String name;
    }

    @Getter
    @Setter
    public static class Remove {

        @NotNull
        private long storageId;
    }
}
