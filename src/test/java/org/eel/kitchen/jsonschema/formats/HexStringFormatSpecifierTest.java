package org.eel.kitchen.jsonschema.formats;

import java.io.IOException;

public final class HexStringFormatSpecifierTest
    extends AbstractFormatSpecifierTest
{
    HexStringFormatSpecifierTest()
        throws IOException
    {
        super(new DummyFormatSpecifier(), "hexstring");
    }

    private static final class DummyFormatSpecifier
        extends HexStringFormatSpecifier
    {
        protected DummyFormatSpecifier()
        {
            // Unconsciouly so (?), I chose SHA1 as a base...
            super("foo", 40);
        }
    }
}
