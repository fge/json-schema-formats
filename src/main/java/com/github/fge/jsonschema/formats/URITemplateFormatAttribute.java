package com.github.fge.jsonschema.formats;

import com.github.fge.jsonschema.exceptions.ProcessingException;
import com.github.fge.jsonschema.format.AbstractFormatAttribute;
import com.github.fge.jsonschema.format.FormatAttribute;
import com.github.fge.jsonschema.processors.data.FullData;
import com.github.fge.jsonschema.report.ProcessingReport;
import com.github.fge.jsonschema.util.NodeType;
import com.github.fge.uritemplate.URITemplate;
import com.github.fge.uritemplate.URITemplateParseException;

public final class URITemplateFormatAttribute
    extends AbstractFormatAttribute
{
    private static final FormatAttribute INSTANCE
        = new URITemplateFormatAttribute();

    private URITemplateFormatAttribute()
    {
        super("uri-template", NodeType.STRING);
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
            new URITemplate(value);
        } catch (URITemplateParseException ignored) {
            report.error(newMsg(data, Messages.URITEMPLATE_INVALID)
                .put("value", value));
        }
    }
}
