package com.github.fge.jsonschema.formats;

import org.eel.kitchen.jsonschema.format.FormatAttribute;

/**
 * Format specifier for {@code md5}
 *
 * @see HexStringFormatAttribute
 */
public final class MD5FormatAttribute
    extends HexStringFormatAttribute
{
    private static final FormatAttribute instance = new MD5FormatAttribute();

    private MD5FormatAttribute()
    {
        super("MD5 hash", 32);
    }

    public static FormatAttribute getInstance()
    {
        return instance;
    }

}
