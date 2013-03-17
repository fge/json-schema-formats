package com.github.fge.jsonschema.formats;

import com.fasterxml.jackson.databind.JsonNode;
import org.eel.kitchen.jsonschema.format.FormatAttribute;
import org.eel.kitchen.jsonschema.report.Message;
import org.eel.kitchen.jsonschema.report.ValidationReport;
import org.eel.kitchen.jsonschema.util.NodeType;
import org.eel.kitchen.jsonschema.validator.ValidationContext;

import java.util.regex.Pattern;

/**
 * Hypothetical format attribute for {@code mac}
 *
 * <p>This specifier will check if a string instance is a valid MAC address.</p>
 */
public final class MacAddressFormatAttribute
    extends FormatAttribute
{
    private static final FormatAttribute instance
        = new MacAddressFormatAttribute();

    // Yep, a regex...
    private static final Pattern MACADDR
        = Pattern.compile("^[A-Za-z0-9]{2}(:[A-Za-z0-9]{2}){5}$");

    public static FormatAttribute getInstance()
    {
        return instance;
    }

    private MacAddressFormatAttribute()
    {
        super(NodeType.STRING);
    }

    @Override
    public void checkValue(String fmt, ValidationContext ctx,
        ValidationReport report, JsonNode value)
    {
        if (MACADDR.matcher(value.textValue()).find())
            return;

        final Message.Builder msg = newMsg(fmt)
            .setMessage("string is not a valid MAC address")
            .addInfo("value", value);

        report.addMessage(msg.build());
    }
}
