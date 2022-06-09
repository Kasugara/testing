package com.bezkoder.spring.security.postgresql.security.exception;

public class ResourceDoseNotExistException extends Exception {
    public ResourceDoseNotExistException(String resource) {
        super(resource + "does not exist!");

    }
}
