/*
 * $Header: /home/jerenkrantz/tmp/commons/commons-convert/cvs/home/cvs/jakarta-commons//collections/src/java/org/apache/commons/collections/decorators/Attic/FixedSizeSortedMap.java,v 1.3 2003/11/16 00:39:37 scolebourne Exp $
 * ====================================================================
 *
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 2003 The Apache Software Foundation.  All rights
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution, if
 *    any, must include the following acknowledgement:
 *       "This product includes software developed by the
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowledgement may appear in the software itself,
 *    if and wherever such third-party acknowledgements normally appear.
 *
 * 4. The names "The Jakarta Project", "Commons", and "Apache Software
 *    Foundation" must not be used to endorse or promote products derived
 *    from this software without prior written permission. For written
 *    permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache"
 *    nor may "Apache" appear in their names without prior written
 *    permission of the Apache Software Foundation.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */
package org.apache.commons.collections.decorators;

import java.util.Comparator;
import java.util.SortedMap;

/**
 * <code>FixedSizeSortedMap</code> decorates another <code>SortedMap</code>
 * to fix the size.
 * <p>
 * Any action that would change the size of the map is disallowed.
 * The put method is allowed to change the value associated with an existing
 * key however.
 * <p>
 * If trying to remove or clear the map, an UnsupportedOperationException is
 * thrown. If trying to put a new mapping into the map, an 
 * IllegalArgumentException is thrown. This is because the put method can 
 * succeed if the mapping's key already exists in the map, so the put method
 * is not always unsupported.
 *
 * @since Commons Collections 3.0
 * @version $Revision: 1.3 $ $Date: 2003/11/16 00:39:37 $
 * @deprecated TO BE REMOVED BEFORE v3.0
 * 
 * @author Stephen Colebourne
 * @author Paul Jack
 */
public class FixedSizeSortedMap extends FixedSizeMap implements SortedMap {

    /**
     * Factory method to create a fixed size sorted map.
     * 
     * @param map  the map to decorate, must not be null
     * @throws IllegalArgumentException if map is null
     */
    public static SortedMap decorate(SortedMap map) {
        return new FixedSizeSortedMap(map);
    }

    /**
     * Constructor that wraps (not copies).
     * 
     * @param map  the map to decorate, must not be null
     * @throws IllegalArgumentException if map is null
     */
    protected FixedSizeSortedMap(SortedMap map) {
        super(map);
    }

    /**
     * Gets the map being decorated.
     * 
     * @return the decorated map
     */
    protected SortedMap getSortedMap() {
        return (SortedMap) map;
    }

    //-----------------------------------------------------------------------
    public Object firstKey() {
        return getSortedMap().firstKey();
    }

    public Object lastKey() {
        return getSortedMap().lastKey();
    }

    public Comparator comparator() {
        return getSortedMap().comparator();
    }

    public SortedMap subMap(Object fromKey, Object toKey) {
        SortedMap map = getSortedMap().subMap(fromKey, toKey);
        return new FixedSizeSortedMap(map);
    }

    public SortedMap headMap(Object toKey) {
        SortedMap map = getSortedMap().headMap(toKey);
        return new FixedSizeSortedMap(map);
    }

    public SortedMap tailMap(Object fromKey) {
        SortedMap map = getSortedMap().tailMap(fromKey);
        return new FixedSizeSortedMap(map);
    }

}