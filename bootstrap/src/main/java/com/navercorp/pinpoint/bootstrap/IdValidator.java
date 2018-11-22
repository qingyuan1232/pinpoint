/*
 * Copyright 2016 NAVER Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.navercorp.pinpoint.bootstrap;

import com.navercorp.pinpoint.common.util.IdValidateUtils;
import com.navercorp.pinpoint.common.util.NetUtils;

import java.util.Properties;

/**
 * @author Woonduk Kang(emeroad)
 */
public class IdValidator {

    /**
     * default max length is 24 ,we may need more length
     */
    private static final int MAX_ID_LENGTH = 60;
    private final BootLogger logger = BootLogger.getLogger(IdValidator.class.getName());
    private final Properties property;

    public IdValidator() {
        this(System.getProperties());
    }

    public IdValidator(Properties property) {
        if (property == null) {
            throw new NullPointerException("property must not be null");
        }
        this.property = property;
    }

    private String getValidId(String propertyName, int maxSize) {
        logger.info("check -D" + propertyName);
        String value = property.getProperty(propertyName);
        if (value == null) {
            logger.warn("-D" + propertyName + " is null. value:null");
            return null;
        }
        // blanks not permitted around value
        value = value.trim();
        if (value.isEmpty()) {
            logger.warn("-D" + propertyName + " is empty. value:''");
            return null;
        }

        if (!IdValidateUtils.validateId(value, maxSize)) {
            logger.warn("invalid Id. " + propertyName + " can only contain [a-zA-Z0-9], '.', '-', '_'. maxLength:" + maxSize + " value:" + value);
            return null;
        }

        if (logger.isInfoEnabled()) {
            logger.info("check success. -D" + propertyName + ":" + value + " length:" + IdValidateUtils.getLength(value));
        }
        return value;
    }


    public String getApplicationName() {
        return this.getValidId("pinpoint.applicationName", MAX_ID_LENGTH);
    }

    /**
     * getAgentId
     * return if set system property else return automatic generation
     *
     * @return
     * @date 2018/11/22 16:45
     */
    public String getAgentId() {
        String agentId = this.getValidId("pinpoint.agentId", MAX_ID_LENGTH);
        if (agentId != null) {
            return agentId;
        }
        //create agentId by pinpoint.application and local host

        return getApplicationName() + ":" + NetUtils.getLocalV4Ip();
    }
}
