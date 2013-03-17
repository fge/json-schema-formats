package com.github.fge.jsonschema.formats;

import java.io.IOException;

public final class Base64FormatAttributeTest
    extends AbstractFormatAttributeTest
{
    Base64FormatAttributeTest()
        throws IOException
    {
        super(Base64FormatAttribute.getInstance(), "base64");
    }
}
