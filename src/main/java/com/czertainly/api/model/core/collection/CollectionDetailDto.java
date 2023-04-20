package com.czertainly.api.model.core.collection;

import com.czertainly.api.model.common.attribute.v2.content.AttributeContentType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class CollectionDetailDto extends CollectionDto {

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
    private CollectionSourceDto source;
    private List<CollectionItemDto> items;
}
