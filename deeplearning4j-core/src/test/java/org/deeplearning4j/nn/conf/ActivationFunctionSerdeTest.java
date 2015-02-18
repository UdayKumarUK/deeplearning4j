/*
 * Copyright 2015 Skymind,Inc.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.deeplearning4j.nn.conf;

import static org.junit.Assert.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.deeplearning4j.nn.conf.deserializers.ActivationFunctionDeSerializer;
import org.deeplearning4j.nn.conf.serializers.ActivationFunctionSerializer;
import org.junit.Test;
import org.nd4j.linalg.api.activation.ActivationFunction;
import org.nd4j.linalg.api.activation.Activations;

/**
 * Created by agibsonccc on 11/27/14.
 */
public class ActivationFunctionSerdeTest {

    @Test
    public void testSerde() throws Exception {
        ActivationFunction softmax = Activations.softmax();
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(ActivationFunction.class,new ActivationFunctionDeSerializer());
        module.addSerializer(ActivationFunction.class,new ActivationFunctionSerializer());
        mapper.registerModule(module);
        String val = mapper.writeValueAsString(softmax);
        assertTrue(val.contains(softmax.getClass().getName() + ":" + false));
    }



}
