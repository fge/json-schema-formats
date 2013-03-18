package com.github.fge.jsonschema.formats;

import com.github.fge.jsonschema.exceptions.JsonReferenceException;
import com.github.fge.jsonschema.exceptions.ProcessingException;
import com.github.fge.jsonschema.format.AbstractFormatAttribute;
import com.github.fge.jsonschema.format.FormatAttribute;
import com.github.fge.jsonschema.jsonpointer.JsonPointer;
import com.github.fge.jsonschema.processors.data.FullData;
import com.github.fge.jsonschema.report.ProcessingReport;
import com.github.fge.jsonschema.util.NodeType;

public final class JsonPointerFormatAttribute
    extends AbstractFormatAttribute
{
    private static final FormatAttribute INSTANCE
        = new JsonPointerFormatAttribute();

    private JsonPointerFormatAttribute()
    {
        super("json-pointer", NodeType.STRING);
    }

    public static FormatAttribute getInstance()
    {
        return INSTANCE;
    }

    @Override
    public void validate(final ProcessingReport report, final FullData data)
        throws ProcessingException
    {
        final String value = data.getInstance().getNode().textValue();

        try {
            new JsonPointer(value);
        } catch (JsonReferenceException ignored) {
            report.error(newMsg(data, Messages.JSONPOINTER_INVALID)
                .put("value", value));
        }
    }
}
