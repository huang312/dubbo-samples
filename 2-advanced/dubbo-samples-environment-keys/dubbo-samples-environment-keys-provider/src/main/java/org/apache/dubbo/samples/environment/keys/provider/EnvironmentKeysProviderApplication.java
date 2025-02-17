/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.dubbo.samples.environment.keys.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class EnvironmentKeysProviderApplication {


    public static void main(String[] args) {
        new EmbeddedZooKeeper(2181,false).start();
        System.setProperty("dubbo.labels", "dubbo.key1=value1; dubbo.key2=value2");
        System.setProperty("dubbo.env.keys", "DUBBO_KEY1, DUBBO_KEY2");
        SpringApplication.run(EnvironmentKeysProviderApplication.class, args);
    }

}
