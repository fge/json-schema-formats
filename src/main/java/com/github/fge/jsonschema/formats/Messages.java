package com.github.fge.jsonschema.formats;

public enum Messages
{
    HEX_STRING_BAD_LENGTH("incorrect string length"),
    BASE64_BAD_LENGTH("string has illegal length (must be a multiple of 4)"),
    BASE64_BAD_CHAR("string has character not in Base64 alphabet"),
    MACADDR_INVALID("string is not a valid MAC address"),
    UUID_INVALID("string is not a valid UUID"),
    JSONPOINTER_INVALID("string is not a valid JSON Pointer"),
    URITEMPLATE_INVALID("string is not a valid URI template"),
    ;

    private final String message;

    Messages(final String message)
    {
        this.message = message;
    }

    @Override
    public String toString()
    {
        return message;
    }
}