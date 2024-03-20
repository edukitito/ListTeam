package com.springwithmongo.listteam.services.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(Object id, String name){
        super("Id Not Found: " + id + "for the " + name);
    }
}
