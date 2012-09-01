package org.eel.kitchen.jsonschema.formats;

import org.eel.kitchen.jsonschema.format.FormatSpecifier;

/**
 * Format specifier for {@code sha512}
 *
 * @see HexStringFormatSpecifier
 */
public final class SHA512FormatSpecifier
    extends HexStringFormatSpecifier
{
    private static final FormatSpecifier instance = new SHA512FormatSpecifier();

    private SHA512FormatSpecifier()
    {
        super("SHA512 hash", 128);
    }

    public static FormatSpecifier getInstance()
    {
        return instance;
    }

}
