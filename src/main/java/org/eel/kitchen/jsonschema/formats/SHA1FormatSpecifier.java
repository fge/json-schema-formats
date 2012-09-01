package org.eel.kitchen.jsonschema.formats;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.CharMatcher;
import org.eel.kitchen.jsonschema.format.FormatSpecifier;
import org.eel.kitchen.jsonschema.report.ValidationMessage;
import org.eel.kitchen.jsonschema.report.ValidationReport;
import org.eel.kitchen.jsonschema.util.NodeType;
import org.eel.kitchen.jsonschema.validator.ValidationContext;

/**
 * Format specifier for a proposed {@code sha1} format attribute
 *
 * <p>Typically, the things used by git. A SHA1 is a 160-byte number, which
 * casual representation is as a hexadecimal string (therefore 40 characters
 * long).</p>
 *
 * <p>While git theoretically allows to refer to SHA1s with fewer characters as
 * long as there is no ambiguity, we choose not to allow that here.</p>
 */
public final class SHA1FormatSpecifier
    extends FormatSpecifier
{
    // FIXME: maybe there is a better way to do that? CharMatcher does not seem
    // to have the following predefined...
    private static final CharMatcher HEX_CHARS
        = CharMatcher.anyOf("0123456789abcdefABCDEF");

    private static final int SHA1_LENGTH = 40;
    private static final int SHA1_RADIX = 16;

    private static final FormatSpecifier instance = new SHA1FormatSpecifier();

    private SHA1FormatSpecifier()
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
        final ValidationMessage.Builder msg = newMsg(fmt)
            .addInfo("value", value).setMessage("string is not a valid SHA1");
        final String sha1 = value.textValue();

        if (sha1.length() != SHA1_LENGTH) {
            report.addMessage(msg.build());
            return;
        }

        if (!HEX_CHARS.matchesAllOf(value.textValue()))
            report.addMessage(msg.build());
    }
}
