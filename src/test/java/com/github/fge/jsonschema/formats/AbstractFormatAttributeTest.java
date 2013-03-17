/*
 * Copyright (c) 2012, Francis Galiegue <fgaliegue@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the Lesser GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * Lesser GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.github.fge.jsonschema.formats;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.fge.jsonschema.exceptions.ProcessingException;
import com.github.fge.jsonschema.format.FormatAttribute;
import com.github.fge.jsonschema.processors.data.FullData;
import com.github.fge.jsonschema.report.DevNullProcessingReport;
import com.github.fge.jsonschema.report.ProcessingReport;
import com.github.fge.jsonschema.tree.CanonicalSchemaTree;
import com.github.fge.jsonschema.tree.SchemaTree;
import com.github.fge.jsonschema.tree.SimpleJsonTree;
import com.github.fge.jsonschema.util.JacksonUtils;
import com.github.fge.jsonschema.util.JsonLoader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public abstract class AbstractFormatAttributeTest
{
    private final FormatAttribute specifier;

    private final JsonNode testData;

    AbstractFormatAttributeTest(final FormatAttribute attr,
        final String resource)
        throws IOException
    {
        this.specifier = attr;

        testData = JsonLoader.fromResource("/formats/" + resource + ".json");
    }

    @DataProvider
    protected final Iterator<Object[]> getData()
    {
        final Set<Object[]> set = new HashSet<Object[]>();

        for (final JsonNode node: testData)
            set.add(new Object[] {
                node.get("data"),
                node.get("valid").booleanValue()
            }
            );

        return set.iterator();
    }

    @Test(dataProvider = "getData", invocationCount = 10, threadPoolSize = 4)
    public final void testAttribute(final JsonNode instance,
        final boolean valid)
        throws ProcessingException
    {
        final ProcessingReport report = new DevNullProcessingReport();
        final ObjectNode schema = JacksonUtils.nodeFactory().objectNode();
        final SchemaTree tree = new CanonicalSchemaTree(schema);
        final FullData data = new FullData(tree, new SimpleJsonTree(instance));

        specifier.validate(report, data);

        assertEquals(report.isSuccess(), valid);
    }
}
