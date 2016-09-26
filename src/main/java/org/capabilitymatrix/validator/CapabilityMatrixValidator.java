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

/**
 * This interface provides JSON validation methods.
 */
public interface CapabilityMatrixValidator {

    /**
     * Validates JSON against a given specification
     * 
     * @param json
     *            the JSON as a string
     * @return true if JSON is valid
     */
    public boolean isValid(String json);

    /**
     * Validates JSON against a given specification
     * 
     * @param jsonNode
     *            the JSON object
     * @return true if JSON is valid
     */
    public boolean isValid(JsonNode jsonNode);

    /**
     * Validates JSON against a given specification
     * 
     * @param file
     *            the JSON file
     * @return true if JSON is valid
     */
    public boolean isValid(File file);

    /**
     * Validates JSON against a given specification
     * 
     * @param reader
     *            the JSON reader
     * @return true if JSON is valid
     */
    public boolean isValid(Reader reader);

    /**
     * Validates JSON against a given specification
     * 
     * @param json
     *            the JSON as a string
     * @return a validation result
     * @throws IOException
     *             an exception occurred while parsing or validating JSON
     */
    public ValidationReport validate(String json) throws IOException;

    /**
     * Validates JSON against a given specification
     * 
     * @param jsonNode
     *            the JSON object
     * @return a validation result
     * @throws IOException
     *             an exception occurred while parsing or validating JSON
     */
    public ValidationReport validate(JsonNode jsonNode) throws IOException;

    /**
     * Validates JSON against a given specification
     * 
     * @param file
     *            the JSON file
     * @return a validation result
     * @throws IOException
     *             an exception occurred while parsing or validating JSON
     */
    public ValidationReport validate(File file) throws IOException;

    /**
     * Validates JSON against a given specification
     * 
     * @param reader
     *            the JSON reader
     * @return a validation result
     * @throws IOException
     *             an exception occurred while parsing or validating JSON
     */
    public ValidationReport validate(Reader reader) throws IOException;
	
}
