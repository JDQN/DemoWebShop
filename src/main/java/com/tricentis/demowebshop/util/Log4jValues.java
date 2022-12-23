package com.tricentis.demowebshop.util;


public enum Log4jValues {

    LOG4J2_PROPERTIES_FILE_PATH("./src/main/resources/log4j2.properties");

    private final String value;
    Log4jValues(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
