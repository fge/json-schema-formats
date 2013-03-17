package com.github.fge.jsonschema.formats;

import java.io.IOException;

public final class HexStringFormatAttributeTest
    extends AbstractFormatAttributeTest
{
    HexStringFormatAttributeTest()
        throws IOException
    {
        super(new DummyFormatAttribute(), "hexstring");
    }

    private static final class DummyFormatAttribute
        extends HexStringFormatAttribute
    {
        DummyFormatAttribute()
        {
            // Unconsciouly so (?), I chose SHA1 as a base...
            super("foo", 40);
        }
    }
}
