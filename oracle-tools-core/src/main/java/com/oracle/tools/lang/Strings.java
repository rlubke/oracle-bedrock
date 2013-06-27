/*
 * File: Strings.java
 *
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * The contents of this file are subject to the terms and conditions of 
 * the Common Development and Distribution License 1.0 (the "License").
 *
 * You may not use this file except in compliance with the License.
 *
 * You can obtain a copy of the License by consulting the LICENSE.txt file
 * distributed with this file, or by consulting https://oss.oracle.com/licenses/CDDL
 *
 * See the License for the specific language governing permissions
 * and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file LICENSE.txt.
 *
 * MODIFICATIONS:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 */

package com.oracle.tools.lang;

/**
 * Helper methods for {@link String}s.
 * <p>
 * Copyright (c) 2013. All Rights Reserved. Oracle Corporation.<br>
 * Oracle is a registered trademark of Oracle Corporation and/or its affiliates.
 *
 * @author Brian Oliver
 */
public final class Strings
{
    /**
     * Remove quotes from the specified {@link String}, including
     * single (') and double (") quotes.
     *
     * @param string the {@link String} to unquote
     *
     * @return the unquoted {@link String}
     */
    public static String unquote(String string)
    {
        // remove leading and trailing whitespace
        string = string != null ? string.trim() : string;

        // remove quotes
        return (string != null
                && ((string.startsWith("\"") && string.endsWith("\""))
                    || (string.startsWith("'")
                        && string.endsWith("'")))) ? string = string.substring(1, string.length() - 1) : string;

    }


    /**
     * Remove all quote characters from a specified {@link String},
     * including single (') and double (") quotes.
     *
     * @param string the {@link String} to unquote
     *
     * @return the unquoted {@link String}
     */
    public static String dequote(String string)
    {
        if (string == null)
        {
            return null;
        }
        else
        {
            // remove leading and trailing spaces
            string = string.trim();

            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < string.length(); i++)
            {
                char c = string.charAt(i);

                if (c != '\"' && c != '\'' && c != '`')
                {
                    builder.append(c);
                }
            }

            return builder.toString();
        }
    }


    /**
     * Returns a double-quoted {@link String} if the said {@link String}
     * contains white-space.
     *
     * @param string the {@link String} to be double-quoted
     *
     * @return the double-quoted {@link String} (if required)
     */
    public static String doubleQuoteIfNecessary(String string)
    {
        return string != null && string.contains(" ") &&!string.startsWith("\"") &&!string.endsWith("\"")
               ? "\"" + string + "\"" : string;
    }
}
