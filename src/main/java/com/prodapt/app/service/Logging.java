/** Copyright 2015-2016 by West Corporation.,
 *
 * 1601 Dry Creek Drive, Longmont, Colorado, 80503, U.S.A.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of West Corporation. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you
 * entered into with West.
 */
package com.prodapt.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class Logging to generate genric logs.
 *
 * @author mmekala
 * @version 1.0
 * @since 1.0
 */
public class Logging {

    private Logging() {

    }

    /**
     * For info level logging.
     *
     * @param className
     *            the class name
     * @param methodName
     *            the method name
     * @param description
     *            the description
     */
    public static void infoLog(Class<?> className, String id, Object methodName,
            Object description) {
        Logger log = LoggerFactory.getLogger(className);
        log.info(Logging.logDetails(id, methodName, description));
    }

    /**
     * For debug level logging.
     *
     * @param className
     *            the class name
     * @param methodName
     *            the method name
     * @param description
     *            the description
     */
    public static void debugLog(Class<?> className, String id,
            Object methodName, Object description) {
        Logger log = LoggerFactory.getLogger(className);
        if (log.isDebugEnabled()) {
            log.debug(Logging.logDetails(id, methodName, description));
        }
    }

    /**
     * For error level logging.
     *
     * @param className
     *            the class name
     * @param methodName
     *            the method name
     * @param description
     *            the description
     * @param exception
     *            the exception
     */
    public static void errorLog(Class<?> className, String id,
            Object methodName, Object description, Throwable exception) {
        Logger log = LoggerFactory.getLogger(className);
        log.error(Logging.logDetails(id, methodName, description), exception);
    }

    /**
     * For warn level logging.
     *
     * @param className
     *            the class name
     * @param methodName
     *            the method name
     * @param description
     *            the description
     */
    public static void warnLog(Class<?> className, String id, Object methodName,
            Object description) {
        Logger log = LoggerFactory.getLogger(className);
        log.warn(Logging.logDetails(id, methodName, description));
    }

    /**
     * For warn level logging.
     *
     * @param className
     *            the class name
     * @param methodName
     *            the method name
     * @param description
     *            the description
     * @param t
     *            the t
     */
    public static void warnLog(Class<?> className, String id, Object methodName,
            Object description, Throwable t) {
        Logger log = LoggerFactory.getLogger(className);
        log.warn(Logging.logDetails(id, methodName, description), t);
    }

    /**
     * To construct the log description.
     *
     * @param methodName
     *            the method name
     * @param description
     *            the description
     * @return the string
     */
    private static String logDetails(String id, Object methodName,
            Object description) {
        StringBuilder builder = new StringBuilder();
        builder.append(id);
        builder.append(" ");
        builder.append(methodName);
        builder.append(":");
        builder.append(description);
        return builder.toString();
    }

}
