package org.eel.kitchen.jsonschema.formats;

import java.io.IOException;

public final class UUIDFormatSpecifierTest
    extends AbstractFormatSpecifierTest
{
    // FIXME: tests are probably lacking
    UUIDFormatSpecifierTest()
        throws IOException
    {
        super(UUIDFormatSpecifier.getInstance(), "uuid");
    }
}
