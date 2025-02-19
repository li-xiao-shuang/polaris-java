/*
 * Tencent is pleased to support the open source community by making Polaris available.
 *
 * Copyright (C) 2019 THL A29 Limited, a Tencent company. All rights reserved.
 *
 * Licensed under the BSD 3-Clause License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://opensource.org/licenses/BSD-3-Clause
 *
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.tencent.polaris.router.examples.consumer;

import com.tencent.polaris.api.core.ConsumerAPI;
import com.tencent.polaris.api.rpc.GetAllInstancesRequest;
import com.tencent.polaris.api.rpc.InstancesResponse;
import com.tencent.polaris.router.examples.utils.ExampleUtils;
import com.tencent.polaris.router.examples.utils.ExampleUtils.InitResult;
import com.tencent.polaris.factory.api.DiscoveryAPIFactory;

public class GetAllInstancesExample {

    public static void main(String[] args) throws Exception {
        InitResult initResult = ExampleUtils.initConsumerConfiguration(args);
        String namespace = initResult.getNamespace();
        String service = initResult.getService();
        try (ConsumerAPI consumerAPI = DiscoveryAPIFactory.createConsumerAPI()) {
            System.out.println("namespace " + namespace + ", service " + service);
            GetAllInstancesRequest allInstancesRequest = new GetAllInstancesRequest();
            allInstancesRequest.setNamespace(namespace);
            allInstancesRequest.setService(service);
            InstancesResponse instancesResponse = consumerAPI.getAllInstance(allInstancesRequest);
            System.out.println("instances count is " + instancesResponse.getInstances().length);
        }
    }
}
