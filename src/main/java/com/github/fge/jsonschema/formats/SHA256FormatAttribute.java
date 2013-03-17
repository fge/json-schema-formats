package com.github.fge.jsonschema.formats;

import com.github.fge.jsonschema.format.FormatAttribute;

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
        super("sha256", 64);
    }

    public static FormatAttribute getInstance()
    {
        return instance;
    }

}
