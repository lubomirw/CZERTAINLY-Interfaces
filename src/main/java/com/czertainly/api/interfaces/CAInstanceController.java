package com.czertainly.api.interfaces;

import com.czertainly.api.exception.AlreadyExistException;
import com.czertainly.api.exception.NotFoundException;
import com.czertainly.api.exception.ValidationException;
import com.czertainly.api.model.AttributeDefinition;
import com.czertainly.api.model.ca.CAInstanceDto;
import com.czertainly.api.model.ca.ConnectorCAInstanceDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/authorityProvider/authorities")
@Tag(name = "Certification Authority API", description = "Certification Authority API")
public interface CAInstanceController {

    @Operation(
            summary = "List Authority instances"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Authority instances retrieved"
                    )
            })
    @RequestMapping(method = RequestMethod.GET)
    List<ConnectorCAInstanceDto> listCAInstances();

    @Operation(
            summary = "Get an Authority instance"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Authority instance retrieved"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Not found",
                            content = @Content
                    )
            })
    @RequestMapping(path = "/{uuid}", method = RequestMethod.GET)
    ConnectorCAInstanceDto getCAInstance(@PathVariable String uuid) throws NotFoundException;

    @Operation(
            summary = "Create a new Authority instance"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Authority instance created"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad Request",
                            content = @Content
                    )
            })
    @RequestMapping(method = RequestMethod.POST)
    ConnectorCAInstanceDto createCAInstance(@RequestBody CAInstanceDto request) throws AlreadyExistException;

    @Operation(
            summary = "Update an Authority instance"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Authority instance updated"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad Request",
                            content = @Content
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Not found",
                            content = @Content
                    )
            })
    @RequestMapping(path = "/{uuid}", method = RequestMethod.POST)
    ConnectorCAInstanceDto updateCAInstance(@PathVariable String uuid, @RequestBody CAInstanceDto request) throws NotFoundException;

    @Operation(
            summary = "Remove an Authority instance"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Authority instance removed"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Not found",
                            content = @Content
                    )
            })
    @RequestMapping(path = "/{uuid}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void removeCAInstance(@PathVariable String uuid) throws NotFoundException;

    @RequestMapping(path = "/{uuid}/connect", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void getConnection(@PathVariable String uuid) throws NotFoundException;

    @Operation(
            summary = "List RA Profile Attributes"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Authority instance updated"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Not found",
                            content = @Content
                    )
            })
    @RequestMapping(path = "/{uuid}/raProfiles/attributes", method = RequestMethod.GET)
    List<AttributeDefinition> listRAProfileAttributes(
            @PathVariable String uuid) throws NotFoundException;

    @Operation(
            summary = "Validate RA Profile attributes"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Authority instance updated"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad Request",
                            content = @Content
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Not found",
                            content = @Content
                    )
            })
    @RequestMapping(path = "/{uuid}/raProfiles/attributes/validate", method = RequestMethod.POST)
    boolean validateRAProfileAttributes(
            @PathVariable String uuid,
            @RequestBody List<AttributeDefinition> attributes) throws ValidationException, NotFoundException;
}