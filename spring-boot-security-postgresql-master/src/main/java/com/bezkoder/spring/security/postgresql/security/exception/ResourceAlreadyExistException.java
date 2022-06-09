package com.bezkoder.spring.security.postgresql.security.exception;

public class ResourceAlreadyExistException extends Exception {
public ResourceAlreadyExistException (String resource)
{super(resource + "already exists!");}
}
