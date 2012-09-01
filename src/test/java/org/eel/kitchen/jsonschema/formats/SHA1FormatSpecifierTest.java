package org.eel.kitchen.jsonschema.formats;

import java.io.IOException;

public final class SHA1FormatSpecifierTest
    extends AbstractFormatSpecifierTest
{
    SHA1FormatSpecifierTest()
        throws IOException
    {
        super(SHA1FormatSpecifier.getInstance(), "sha1");
    }
}
