/**
 * Copyright 2009-2018 PrimeTek.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.primefaces.validate.bean;

import java.util.HashMap;
import java.util.Map;
import javax.validation.constraints.DecimalMin;
import javax.validation.metadata.ConstraintDescriptor;
import org.primefaces.util.HTML;

public class DecimalMinClientValidationConstraint implements ClientValidationConstraint {

    private static final String MESSAGE_METADATA = "data-p-decimalmin-msg";
    private static final String MESSAGE_ID = "{javax.validation.constraints.DecimalMin.message}";

    public Map<String, Object> getMetadata(ConstraintDescriptor constraintDescriptor) {
        Map<String, Object> metadata = new HashMap<String, Object>();
        Map attrs = constraintDescriptor.getAttributes();
        Object message = attrs.get(ATTR_MESSAGE);

        metadata.put(HTML.VALIDATION_METADATA.MIN_VALUE, attrs.get("value"));

        if (!message.equals(MESSAGE_ID)) {
            metadata.put(MESSAGE_METADATA, message);
        }

        return metadata;
    }

    public String getValidatorId() {
        return DecimalMin.class.getSimpleName();
    }
}
