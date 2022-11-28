package com.czertainly.api.model.common.attribute.v2;

import com.czertainly.api.model.common.attribute.v2.content.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * This class contains set of properties to represent
 * an Attribute definition including its value for the Attributes
 * of type Info.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Info attribute contains content that is for information purpose or represents additional information for object (metadata). Its content can not be edited and is not send in requests to store.")
public class InfoAttribute extends BaseAttribute<List<BaseAttributeContent>> {

    /**
     * Content of the Attribute
     **/
    @Schema(
        description = "Content of the Attribute",
        type = "object",
        required = true,
        discriminatorProperty = "contentType",
        oneOf = {
            BooleanAttributeContent.class,
            CredentialAttributeContent.class,
            DateAttributeContent.class,
            DateTimeAttributeContent.class,
            FileAttributeContent.class,
            FloatAttributeContent.class,
            IntegerAttributeContent.class,
            ObjectAttributeContent.class,
            SecretAttributeContent.class,
            StringAttributeContent.class,
            TextAttributeContent.class,
            TimeAttributeContent.class
        }
    )
    private List<BaseAttributeContent> content;

    /**
     * Type of the Attribute content
     */
    @Schema(
            description = "Type of the Content",
            required = true
    )
    private AttributeContentType contentType;


    /**
     * Properties of the Attributes
     */
    @Schema(
            description = "Properties of the Attributes",
            required = true
    )
    private InfoAttributeProperties properties;

    public InfoAttribute() {
        super();
    }

    public InfoAttribute(AttributeType type) {
        super(type);
    }

    public InfoAttribute(String type) {
        super(AttributeType.fromCode(type));
    }

    public List<BaseAttributeContent> getContent() {
        return content;
    }

    public void setContent(List<BaseAttributeContent> content) {
        this.content = content;
    }

    public AttributeContentType getContentType() {
        return contentType;
    }

    public void setContentType(AttributeContentType contentType) {
        this.contentType = contentType;
    }

    public InfoAttributeProperties getProperties() {
        return properties;
    }

    public void setProperties(InfoAttributeProperties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("content", content)
                .append("contentType", contentType)
                .append("properties", properties).toString();
    }
}