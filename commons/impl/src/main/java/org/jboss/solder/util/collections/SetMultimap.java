/*
 * Copyright (C) 2007 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jboss.solder.util.collections;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * A {@code Multimap} that cannot hold duplicate key-value pairs. Adding a
 * key-value pair that's already in the multimap has no effect.
 * <p/>
 * <p>The {@link #get}, {@link #removeAll}, and {@link #replaceValues} methods
 * each return a {@link Set} of values, while {@link #entries} returns a {@code
 * Set} of map entries. Though the method signature doesn't say so explicitly,
 * the map returned by {@link #asMap} has {@code Set} values.
 *
 * @author Jared Levy
 */
public interface SetMultimap<K, V> extends Multimap<K, V> {
    /**
     * {@inheritDoc}
     * <p/>
     * <p>Because a {@code SetMultimap} has unique values for a given key, this
     * method returns a {@link Set}, instead of the {@link java.util.Collection}
     * specified in the {@link Multimap} interface.
     */
    Set<V> get(K key);

    /**
     * {@inheritDoc}
     * <p/>
     * <p>Because a {@code SetMultimap} has unique values for a given key, this
     * method returns a {@link Set}, instead of the {@link java.util.Collection}
     * specified in the {@link Multimap} interface.
     */
    Set<V> removeAll(Object key);

    /**
     * {@inheritDoc}
     * <p/>
     * <p>Because a {@code SetMultimap} has unique values for a given key, this
     * method returns a {@link Set}, instead of the {@link java.util.Collection}
     * specified in the {@link Multimap} interface.
     * <p/>
     * <p>Any duplicates in {@code values} will be stored in the multimap once.
     */
    Set<V> replaceValues(K key, Iterable<? extends V> values);

    /**
     * {@inheritDoc}
     * <p/>
     * <p>Because a {@code SetMultimap} has unique values for a given key, this
     * method returns a {@link Set}, instead of the {@link java.util.Collection}
     * specified in the {@link Multimap} interface.
     */
    Set<Map.Entry<K, V>> entries();

    /**
     * {@inheritDoc}
     * <p/>
     * <p>Though the method signature doesn't say so explicitly, the returned map
     * has {@link Set} values.
     */
    Map<K, Collection<V>> asMap();

    /**
     * Compares the specified object to this multimap for equality.
     * <p/>
     * <p>Two {@code SetMultimap} instances are equal if, for each key, they
     * contain the same values. Equality does not depend on the ordering of keys
     * or values.
     */
    boolean equals(Object obj);
}
