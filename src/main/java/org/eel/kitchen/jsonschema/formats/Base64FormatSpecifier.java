package org.eel.kitchen.jsonschema.formats;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.CharMatcher;
import org.eel.kitchen.jsonschema.format.FormatSpecifier;
import org.eel.kitchen.jsonschema.report.ValidationMessage;
import org.eel.kitchen.jsonschema.report.ValidationReport;
import org.eel.kitchen.jsonschema.util.NodeType;
import org.eel.kitchen.jsonschema.validator.ValidationContext;

import java.util.regex.Pattern;

/**
 * Format specifier for an hypothetical {@code base64} format attribute
 *
 * <p>This implements Base64 as defined in RFC 4648 with one difference: while
 * the RFC states that excess padding characters ({@code =}) MAY be ignored, it
 * is chosen here to require that there be at most two, as per Base64 encoding
 * rules.</p>
 */
public final class Base64FormatSpecifier
    extends FormatSpecifier
{
    // There may be up to two '=' characters at the end of the string
    private static final Pattern PATTERN = Pattern.compile("==?$");

    /*
     * Negation of the Base64 alphabet. We try and find one character, if any,
     * matching the negation, after having checked the length and removed the
     * one, or two, trailing '=' characters.
     *
     * FIXME: use .precomputed()?
     */
    private static final CharMatcher NOT_BASE64
        = CharMatcher.inRange('a', 'z').or(CharMatcher.inRange('A', 'Z'))
            .or(CharMatcher.inRange('0', '9')).or(CharMatcher.anyOf("+/"))
            .negate();
    private static final FormatSpecifier instance
        = new Base64FormatSpecifier();

    public static FormatSpecifier getInstance()
    {
        return instance;
    }

    private Base64FormatSpecifier()
    {
        super(NodeType.STRING);
    }

    @Override
    public void checkValue(final String fmt, final ValidationContext ctx,
        final ValidationReport report, final JsonNode value)
    {
        final String input = value.textValue();
        final ValidationMessage.Builder msg = newMsg(fmt)
            .addInfo("value", value);

        /*
         * The string length must be a multiple of 4. FIXME though: can it be 0?
         * Here, it is assumed that it can, even though that does not really
         * make sense.
         */
        if (input.length() % 4 != 0) {
            msg.setMessage("input has illegal length (not a multiple of 4)")
                .addInfo("found", input.length());
            report.addMessage(msg.build());
            return;
        }

        final int index
            = NOT_BASE64.indexIn(PATTERN.matcher(input).replaceFirst(""));

        if (index == -1)
            return;

        msg.setMessage("malformed input: character not in alphabet")
            .addInfo("index", index);
        report.addMessage(msg.build());
    }
}
