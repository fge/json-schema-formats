package com.github.fge.jsonschema.formats;

public enum Messages
{
    HEX_STRING_BAD_LENGTH("incorrect string length"),
    BASE64_BAD_LENGTH("input has illegal length (must be a multiple of 4)"),
    BASE64_BAD_CHAR("input has character not in Base64 alphabet"),
    MACADDR_INVALID("input is not a valid MAC address"),
    UUID_INVALID("input is not a valid UUID"),
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