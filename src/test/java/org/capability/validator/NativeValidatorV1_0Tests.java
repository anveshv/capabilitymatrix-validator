/*
 * ============================================================================
 * Copyright (c) 2015, Millennial Media, Inc.
 * All rights reserved.
 * Provided under BSD License as follows:
 * 
 * Redistribution and use in source and binary forms, with or without 
 * modification, are permitted provided that the following conditions are met:
 * 
 * 1.  Redistributions of source code must retain the above copyright notice, 
 *     this list of conditions and the following disclaimer.
 * 2.  Redistributions in binary form must reproduce the above copyright 
 *     notice, this list of conditions and the following disclaimer in the 
 *     documentation and/or other materials provided with the distribution.
 * 3.  Neither the name of Millennial Media, Inc. nor the names of its
 *     contributors may be used to endorse or promote products derived from this
 *     software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" 
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE 
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE 
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE 
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR 
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF 
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS 
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN 
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * ============================================================================
 */

package org.capability.validator;

import static org.junit.Assert.*;

import java.io.IOException;

import org.capabilitymatrix.validator.CapabilityMatrixValidator;
import org.capabilitymatrix.validator.CapabilityMatrixValidatorFactory;
import org.capabilitymatrix.validator.CapabilityMatrixVersion;
import org.capabilitymatrix.validator.ValidationResult;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.fge.jackson.JsonLoader;

/**
 * Test examples taken from Native v1.0 specification document. 
 */
public class NativeValidatorV1_0Tests {

	private static final Logger logger = LoggerFactory.getLogger(NativeValidatorV1_0Tests.class);
	
    @Test
    public void testCapabilityMatrixV1_0_when_Json_Is_Valid_Expect_Pass() throws IOException {
		CapabilityMatrixValidator validator = CapabilityMatrixValidatorFactory.getValidator(CapabilityMatrixVersion.V1_0);

		String resource = "/v1_0/capability_matrix_v1_0.json";
        ValidationResult result = validator.validate(JsonLoader.fromResource(resource));

        logger.info("validation result: " + result);
        assertTrue(resource + " is valid", result.isValid());
    }
    
    @Test
    public void testCapabilityMatrixV1_0_when_Json_Version_Is_Missing_Expect_Fail() throws IOException {
		CapabilityMatrixValidator validator = CapabilityMatrixValidatorFactory.getValidator(CapabilityMatrixVersion.V1_0);

		String resource = "/v1_0/missing_capability_matrix_version.json";
        ValidationResult result = validator.validate(JsonLoader.fromResource(resource));

        logger.info("validation result: " + result);
        assertFalse(resource + " is not valid", result.isValid());
    }
}
