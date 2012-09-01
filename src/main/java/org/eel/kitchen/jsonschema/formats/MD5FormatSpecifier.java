package org.eel.kitchen.jsonschema.formats;

import org.eel.kitchen.jsonschema.format.FormatSpecifier;

/**
 * Format specifier for {@code md5}
 *
 * @see HexStringFormatSpecifier
 */
public final class MD5FormatSpecifier
    extends HexStringFormatSpecifier
{
    private static final FormatSpecifier instance = new MD5FormatSpecifier();

    private MD5FormatSpecifier()
    {
        super("MD5 hash", 32);
    }

    public static FormatSpecifier getInstance()
    {
        return instance;
    }

}
