/*
 * Copyright (C) 2015 Sebastian Daschner, sebastian-daschner.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sebastian_daschner.jaxrs_analyzer.analysis.results.testclasses.typeanalyzer;

import com.sebastian_daschner.jaxrs_analyzer.model.rest.TypeRepresentation;
import com.sebastian_daschner.jaxrs_analyzer.model.types.Type;

import javax.json.Json;
import javax.json.JsonObject;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author Sebastian Daschner
 */
public class TestClass6 {

    private boolean first;
    private String second;

    public boolean isFirst() {
        return first;
    }

    public String getSecond() {
        return second;
    }

    // not taken, wrong return type
    public void getFake() {
    }

    public String isFake() {
        return second;
    }

    @XmlElement
    private String getThird() {
        return second;
    }

    public static TypeRepresentation getResult() {
        final TypeRepresentation representation = new TypeRepresentation(new Type(TestClass6.class.getName()));

        final JsonObject jsonObject = Json.createObjectBuilder().add("first", false).add("second", "string").add("third", "string").build();

        representation.getRepresentations().put("application/json", jsonObject);
        return representation;
    }

}