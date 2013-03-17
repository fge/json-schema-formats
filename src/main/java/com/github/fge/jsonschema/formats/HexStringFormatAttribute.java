package com.github.fge.jsonschema.formats;

import com.github.fge.jsonschema.exceptions.ProcessingException;
import com.github.fge.jsonschema.format.AbstractFormatAttribute;
import com.github.fge.jsonschema.processors.data.FullData;
import com.github.fge.jsonschema.report.ProcessingReport;
import com.github.fge.jsonschema.util.NodeType;
import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;

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
    extends AbstractFormatAttribute
{
    // FIXME: maybe there is a better way to do that? CharMatcher does not seem
    // to have the following predefined...
    private static final CharMatcher HEX_CHARS
        = CharMatcher.anyOf("0123456789abcdefABCDEF").precomputed();

    protected final int length;

    protected HexStringFormatAttribute(final String fmt, final int length)
    {
        super(fmt, NodeType.STRING);

        Preconditions.checkArgument(length > 0, "invalid length: must be " +
            "strictly positive");
        this.length = length;
    }

    @Override
    public final void validate(final ProcessingReport report,
        final FullData data)
        throws ProcessingException
    {
        final String input = data.getInstance().getNode().textValue();

        if (length != input.length()) {
            report.error(newMsg(data, Messages.HEX_STRING_BAD_LENGTH)
                .put("expected", length).put("actual", input.length()));
            return;
        }

        if (HEX_CHARS.matchesAllOf(input))
            return;

        report.error(newMsg(data, "invalid characters"));
    }
}
