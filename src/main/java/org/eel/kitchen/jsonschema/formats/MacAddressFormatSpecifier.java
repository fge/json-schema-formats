package org.eel.kitchen.jsonschema.formats;

import com.fasterxml.jackson.databind.JsonNode;
import org.eel.kitchen.jsonschema.format.FormatSpecifier;
import org.eel.kitchen.jsonschema.report.ValidationMessage;
import org.eel.kitchen.jsonschema.report.ValidationReport;
import org.eel.kitchen.jsonschema.util.NodeType;
import org.eel.kitchen.jsonschema.validator.ValidationContext;

import java.util.regex.Pattern;

/**
 * Hypothetical format attribute for {@code mac}
 *
 * <p>This specifier will check if a string instance is a valid MAC address.</p>
 */
public final class MacAddressFormatSpecifier
    extends FormatSpecifier
{
    private static final FormatSpecifier instance
        = new MacAddressFormatSpecifier();

    // Yep, a regex...
    private static final Pattern MACADDR
        = Pattern.compile("^[A-Za-z0-9]{2}(:[A-Za-z0-9]{2}){5}$");

    public static FormatSpecifier getInstance()
    {
        return instance;
    }

    private MacAddressFormatSpecifier()
    {
        super(NodeType.STRING);
    }

    @Override
    public void checkValue(String fmt, ValidationContext ctx,
        ValidationReport report, JsonNode value)
    {
        if (MACADDR.matcher(value.textValue()).find())
            return;

        final ValidationMessage.Builder msg = newMsg(fmt)
            .setMessage("string is not a valid MAC address")
            .addInfo("value", value);

        report.addMessage(msg.build());
    }
}
