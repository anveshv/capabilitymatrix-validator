/*
 * ============================================================================
 * Copyright (c) 2016, AOL, Inc.
 * All rights reserved.
 * ============================================================================
 */

package org.capabilitymatrix.validator;

/**
 * This factory class provides access to Native validators for version 1.0.
 */
public final class CapabilityMatrixValidatorFactory {

	/**
	 * A Capability Matrix v1.0 validator.
	 * 
	 */
	private static final CapabilityMatrixValidator Validator_V1_0 = new GenericCapabilityMatrixValidator("/schema/display_manager_capability_schema_v1_0.json");


	/**
	 * Returns a Capability Matrix validator of a specific type and version.
	 *  
	 * @param version
	 *            the version
	 * @return a specific Capability Matrix  validator or null if either type or version are null
	 */
	public static CapabilityMatrixValidator getValidator(CapabilityMatrixVersion version) {
		CapabilityMatrixValidator validator = null;

		if (version != null) {
			switch (version) {
			case V1_0:
				validator = Validator_V1_0;
				break;
			}
		}
		return validator;
	}
}
