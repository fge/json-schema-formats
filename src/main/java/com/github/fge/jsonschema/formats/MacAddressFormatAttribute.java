package com.github.fge.jsonschema.formats;

import com.github.fge.jsonschema.exceptions.ProcessingException;
import com.github.fge.jsonschema.format.AbstractFormatAttribute;
import com.github.fge.jsonschema.format.FormatAttribute;
import com.github.fge.jsonschema.processors.data.FullData;
import com.github.fge.jsonschema.report.ProcessingReport;
import com.github.fge.jsonschema.util.NodeType;

import java.util.regex.Pattern;

/**
 * Hypothetical format attribute for {@code mac}
 *
 * <p>This specifier will check if a string instance is a valid MAC address.</p>
 */
public final class MacAddressFormatAttribute
    extends AbstractFormatAttribute
{
    private static final FormatAttribute instance
        = new MacAddressFormatAttribute();

    // Yep, a regex...
    private static final Pattern MACADDR
        = Pattern.compile("[A-Za-z0-9]{2}(:[A-Za-z0-9]{2}){5}");

    public static FormatAttribute getInstance()
    {
        return instance;
    }

    private MacAddressFormatAttribute()
    {
        super("mac", NodeType.STRING);
    }

    @Override
    public void validate(final ProcessingReport report, final FullData data)
        throws ProcessingException
    {
        final String input = data.getInstance().getNode().textValue();

        if (!MACADDR.matcher(input).matches())
            report.error(newMsg(data, Messages.MACADDR_INVALID)
                .put("value", input));
    }
}
