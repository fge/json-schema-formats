package com.github.fge.jsonschema.formats;

import org.eel.kitchen.jsonschema.format.FormatAttribute;

/**
 * Format specifier for {@code sha256}
 *
 * @see HexStringFormatAttribute
 */
public final class SHA256FormatAttribute
    extends HexStringFormatAttribute
{
    private static final FormatAttribute instance = new SHA256FormatAttribute();

    private SHA256FormatAttribute()
    {
        super("SHA256 hash", 64);
    }

    public static FormatAttribute getInstance()
    {
        return instance;
    }

}
