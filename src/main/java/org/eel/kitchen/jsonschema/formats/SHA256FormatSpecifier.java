package org.eel.kitchen.jsonschema.formats;

import org.eel.kitchen.jsonschema.format.FormatSpecifier;

/**
 * Format specifier for {@code sha256}
 *
 * @see HexStringFormatSpecifier
 */
public final class SHA256FormatSpecifier
    extends HexStringFormatSpecifier
{
    private static final FormatSpecifier instance = new SHA256FormatSpecifier();

    private SHA256FormatSpecifier()
    {
        super("SHA256 hash", 64);
    }

    public static FormatSpecifier getInstance()
    {
        return instance;
    }

}
