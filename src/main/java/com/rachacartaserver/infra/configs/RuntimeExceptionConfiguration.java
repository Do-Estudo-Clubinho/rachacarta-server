package com.rachacartaserver.infra.configs;

public class RuntimeExceptionConfiguration extends RuntimeException {
    public RuntimeExceptionConfiguration () {
        super();
    }
    public RuntimeExceptionConfiguration (String message) {
        super(message);
    }
}
