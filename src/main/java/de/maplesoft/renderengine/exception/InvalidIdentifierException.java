package de.maplesoft.renderengine.exception;

public class InvalidIdentifierException extends RuntimeException {
    public InvalidIdentifierException(String id) {
        super(STR."Identifier \{id} already used");
    }
}
