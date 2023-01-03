package com.czertainly.api.model.connector.cryptography.key;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PublicKeyDataResponseDto extends KeyDataResponseDto {

    @Schema(
            description = "Data of the Public Key",
            required = true
    )
    private KeyData keyData;

}
