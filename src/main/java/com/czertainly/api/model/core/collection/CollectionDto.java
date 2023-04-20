package com.czertainly.api.model.core.collection;

import com.czertainly.api.model.common.NameAndUuidDto;
import com.czertainly.api.model.common.attribute.v2.content.AttributeContentType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CollectionDto extends NameAndUuidDto {

    @Schema(
            requiredMode = Schema.RequiredMode.NOT_REQUIRED,
            description = "Collection description",
            example = "CertificateType"
    )
    private String description;

    @Schema(
            requiredMode = Schema.RequiredMode.REQUIRED,
            description = "Collection content type",
            example = "string"
    )
    private AttributeContentType contentType;

    @Schema(
            requiredMode = Schema.RequiredMode.REQUIRED,
            description = "Is system Collection"
    )
    private boolean systemCollection;
}
