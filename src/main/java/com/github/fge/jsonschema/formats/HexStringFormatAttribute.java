package com.github.fge.jsonschema.formats;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import org.eel.kitchen.jsonschema.format.FormatAttribute;
import org.eel.kitchen.jsonschema.report.Message;
import org.eel.kitchen.jsonschema.report.ValidationReport;
import org.eel.kitchen.jsonschema.util.NodeType;
import org.eel.kitchen.jsonschema.validator.ValidationContext;

/**
 * Base class for hexadecimal string-based representations
 *
 * <p>This class is particularly useful to validate hexadecimal-based string
 * data. The only two constructor arguments you have to specify are a short
 * description of the validated string and its expected length.</p>
 *
 * <p>In this package, it is used for validating MD5, SHA1, SHA256 and SHA512
 * checksums, which are very commonly represented in form of hexadecimal strings
 * of fixed length.</p>
 */
public abstract class HexStringFormatAttribute
    extends FormatAttribute
{
    // FIXME: maybe there is a better way to do that? CharMatcher does not seem
    // to have the following predefined...
    private static final CharMatcher HEX_CHARS
        = CharMatcher.anyOf("0123456789abcdefABCDEF");

    protected final String errmsg;
    protected final int length;

    protected HexStringFormatAttribute(final String desc, final int length)
    {
        super(NodeType.STRING);

        Preconditions.checkArgument(length > 0, "invalid length: must be " +
            "strictly positive");
        this.length = length;
        errmsg = "string is not a valid " + desc;
    }

    @Override
    public final void checkValue(final String fmt,
        final ValidationContext context, final ValidationReport report,
        final JsonNode value)
    {
        final String input = value.textValue();

        final Message.Builder msg = newMsg(fmt).addInfo("value", value);

        if (length != input.length()) {
            msg.addInfo("expected", length).addInfo("actual", input.length())
                .setMessage(errmsg + ": incorrect string length");
            report.addMessage(msg.build());
            return;
        }

        if (HEX_CHARS.matchesAllOf(input))
            return;

        report.addMessage(msg.setMessage(errmsg + ": invalid characters")
            .build());
    }
}
