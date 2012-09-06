package org.eel.kitchen.jsonschema.formats;

import java.io.IOException;

public final class Base64FormatSpecifierTest
    extends AbstractFormatSpecifierTest
{
    Base64FormatSpecifierTest()
        throws IOException
    {
        super(Base64FormatSpecifier.getInstance(), "base64");
    }
}
