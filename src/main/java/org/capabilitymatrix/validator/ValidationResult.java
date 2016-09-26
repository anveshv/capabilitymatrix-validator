/*
 * ============================================================================
 * Copyright (c) 2016, AOL, Inc.
 * All rights reserved.
 * ============================================================================
 */

package org.capabilitymatrix.validator;

/**
 * This class provides validation result data.
 */
public class ValidationResult {

    private final boolean valid;
    
    private final String result;
    
    //private final String message;

    /**
     * Constructs an object containing JSON validation result data.
     * 
     * @param valid
     *            validity status from validation
     * @param result
     *            the result data from validation
     */
    ValidationResult(boolean valid, String result) {
        this.valid = valid;
        this.result = result;
    }

    /**
     * Returns the validity status from validation.
     * 
     * @return the validity status from validation
     */
    public boolean isValid() {
        return valid;
    }

    /**
     * Returns the result data from validation.
     * 
     * @return the result data from validation
     */
    public String getResult() {
        return result;
    }

    @Override
    public String toString() {
        return (new StringBuilder())
                .append("valid=").append(valid)
                .append("result=").append(result)
                .toString();
    }

}
