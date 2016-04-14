/*
 * File: AssemblyBuilder.java
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

package com.oracle.tools.runtime;

import com.oracle.tools.Option;

/**
 * A builder of {@link Assembly}s.
 * <p>
 * Copyright (c) 2014. All Rights Reserved. Oracle Corporation.<br>
 * Oracle is a registered trademark of Oracle Corporation and/or its affiliates.
 *
 * @author Brian Oliver
 *
 */
public interface AssemblyBuilder<A extends Application, G extends Assembly<A>>
{
    /**
     * Includes the necessary information required for launching one or more {@link Application}s of a specified
     * type as part of an {@link Assembly} on the specified {@link Platform} when {@link #build(Option...)}
     * method is called.
     * <p>
     * Multiple calls to this method are permitted, allowing an {@link Assembly} to be created containing
     * multiple different types of {@link Application}s.
     *
     * @param count             the number of instances of the {@link Application} that should be realized for
     *                          the {@link Assembly}
     * @param platform          the {@link Platform} on which to launch the {@link Application}s
     * @param applicationClass  the class of {@link Application}
     * @param options           the {@link Option}s to use for realizing the {@link Application}s
     *
     * @see Platform#launch(String, Option...)
     */
    void include(int                count,
                 Platform           platform,
                 Class<? extends A> applicationClass,
                 Option...          options);


    /**
     * Builds an {@link Assembly}, using the specified {@link Option}s to override those
     * defined by the {@link Platform}s and {@link Application}s.
     *
     * @param options  the {@link Option}s to override those specified in {@link #include(int, Platform, Class, Option...)}
     *
     * @return an {@link Assembly} representing the collection of realized {@link Application}s.
     *
     * @throws RuntimeException when a problem occurs building the {@link Assembly}
     */
    G build(Option... options);
}