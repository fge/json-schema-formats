package com.github.fge.jsonschema.formats;

import com.fasterxml.jackson.databind.JsonNode;
import org.eel.kitchen.jsonschema.format.FormatAttribute;
import org.eel.kitchen.jsonschema.report.Message;
import org.eel.kitchen.jsonschema.report.ValidationReport;
import org.eel.kitchen.jsonschema.util.NodeType;
import org.eel.kitchen.jsonschema.validator.ValidationContext;

import java.util.UUID;

/**
 * Format specifier for a proposed {@code uuid} attribute
 *
 * @see UUID#fromString(String)
 */
public final class UUIDFormatAttribute
    extends FormatAttribute
{
    private static final FormatAttribute instance = new UUIDFormatAttribute();

    private UUIDFormatAttribute()
    {
        super(NodeType.STRING);
    }

    public static FormatAttribute getInstance()
    {
        return instance;
    }

    @Override
    public void checkValue(final String fmt, final ValidationContext context,
        final ValidationReport report, final JsonNode value)
    {
        try {
            UUID.fromString(value.textValue());
        } catch (IllegalArgumentException ignored) {
            final Message.Builder msg = newMsg(fmt).addInfo("value", value)
                .setMessage("string is not a valid UUID");
            report.addMessage(msg.build());
        }
    }
}
