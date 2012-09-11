/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011, Red Hat, Inc., and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.seam.faces.examples.viewconfig.model;

import javax.faces.component.UIComponent;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.jboss.seam.faces.conversion.Converter;

/**
 * @author <a href="mailto:bleathem@gmail.com">Brian Leathem</a>
 */
@FacesConverter("itemConverter")
public class ItemConverter extends Converter<Item> {
    @Inject
    private ItemDao itemDao;

    @Override
    public Item toObject(UIComponent uic, String string) {
        Integer id = Integer.parseInt(string);
        return itemDao.find(id);
    }

    @Override
    public String toString(UIComponent uic, Item t) {
        return t.getId().toString();
    }


}
