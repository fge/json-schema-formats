package org.eel.kitchen.jsonschema.formats;

import com.fasterxml.jackson.databind.JsonNode;
import org.eel.kitchen.jsonschema.format.FormatSpecifier;
import org.eel.kitchen.jsonschema.report.ValidationMessage;
import org.eel.kitchen.jsonschema.report.ValidationReport;
import org.eel.kitchen.jsonschema.util.NodeType;
import org.eel.kitchen.jsonschema.validator.ValidationContext;

import java.util.UUID;

/**
 * Format specifier for a proposed {@code uuid} attribute
 *
 * @see UUID#fromString(String)
 */
public final class UUIDFormatSpecifier
    extends FormatSpecifier
{
    private static final FormatSpecifier instance = new UUIDFormatSpecifier();

    private UUIDFormatSpecifier()
    {
        super(NodeType.STRING);
    }

    public static FormatSpecifier getInstance()
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
            final ValidationMessage.Builder msg = newMsg(fmt)
                .addInfo("value", value)
                .setMessage("string is not a valid UUID");
            report.addMessage(msg.build());
        }
    }
}
