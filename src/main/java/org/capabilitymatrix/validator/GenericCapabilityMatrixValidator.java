/*
 * ============================================================================
 * Copyright (c) 2016, AOL, Inc.
 * All rights reserved.
 * ============================================================================
 */

package org.capabilitymatrix.validator;

import java.io.File;
import java.io.IOException;
import java.io.Reader;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

/**
 * This class provides basic JSON validation against a schema.
 */
public class GenericCapabilityMatrixValidator implements CapabilityMatrixValidator {

	private final JsonSchema schema;
	
    /**
     * Constructs a JSON validator using the given schema read as a resource.
     * 
     * @param schemaResource
     *            the schema resource
     */
    GenericCapabilityMatrixValidator(String schemaResource) {
		try {
			JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
			JsonNode jsonNode = JsonLoader.fromResource(schemaResource);
			schema = factory.getJsonSchema(jsonNode);
		} catch (IOException | ProcessingException e) {
			throw new IllegalStateException("could not initialize validator due to previous exception", e);
		}
	}
	
	@Override
	public final boolean isValid(String json) {
	    try {
            return validate(json).isValid();
        } catch (IOException e) {
            return false;
        }
	}
	
	@Override
	public final boolean isValid(JsonNode jsonNode) {
        try {
            return validate(jsonNode).isValid();
        } catch (IOException e) {
            return false;
        }
	}
	
	@Override
	public final boolean isValid(File file) {
        try {
            return validate(file).isValid();
        } catch (IOException e) {
            return false;
        }
	}
	
	@Override
	public final boolean isValid(Reader reader) {
        try {
            return validate(reader).isValid();
        } catch (IOException e) {
            return false;
        }
	}

	@Override
	public final ValidationResult validate(String json) throws IOException {
		JsonNode jsonNode = JsonLoader.fromString(json);
		return getValidationResult(jsonNode);
	}
	
	@Override
	public final ValidationResult validate(JsonNode jsonNode) throws IOException {
        return getValidationResult(jsonNode);
	}

	@Override
	public final ValidationResult validate(File file) throws IOException {
		JsonNode jsonNode = JsonLoader.fromFile(file);
        return getValidationResult(jsonNode);
	}
	
	@Override
	public final ValidationResult validate(Reader reader) throws IOException {
		JsonNode jsonNode = JsonLoader.fromReader(reader);
        return getValidationResult(jsonNode);
	}
	
	private final ValidationResult getValidationResult(JsonNode jsonNode) throws IOException {
	    try {
            ProcessingReport processingReport = schema.validate(jsonNode);
            if (processingReport != null) {
                return new ValidationResult(processingReport.isSuccess(), processingReport.toString());
            } else {
                return new ValidationResult(false, null);
            }
        } catch (ProcessingException e) {
            throw new IOException(e.getMessage());
        }
	}

}
