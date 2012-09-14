package org.eel.kitchen.jsonschema.formats;

import java.io.IOException;

public final class UUIDFormatAttributeTest
    extends AbstractFormatAttributeTest
{
    // FIXME: tests are probably lacking
    UUIDFormatAttributeTest()
        throws IOException
    {
        super(UUIDFormatAttribute.getInstance(), "uuid");
    }
}
