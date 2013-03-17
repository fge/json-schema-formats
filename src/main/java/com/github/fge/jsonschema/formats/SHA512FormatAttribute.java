package com.github.fge.jsonschema.formats;

import com.github.fge.jsonschema.format.FormatAttribute;

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
        super("sha512", 128);
    }

    public static FormatAttribute getInstance()
    {
        return instance;
    }

}
