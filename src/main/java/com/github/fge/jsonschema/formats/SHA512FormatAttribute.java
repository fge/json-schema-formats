package com.github.fge.jsonschema.formats;

import org.eel.kitchen.jsonschema.format.FormatAttribute;

/**
 * Format specifier for {@code sha512}
 *
 * @see HexStringFormatAttribute
 */
public final class SHA512FormatAttribute
    extends HexStringFormatAttribute
{
    private static final FormatAttribute instance = new SHA512FormatAttribute();

    private SHA512FormatAttribute()
    {
        super("SHA512 hash", 128);
    }

    public static FormatAttribute getInstance()
    {
        return instance;
    }

}
