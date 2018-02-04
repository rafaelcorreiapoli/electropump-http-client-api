/*
* Copyright 2017 WalmartLabs
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

package com.HttpClientApi.ern.api;

import android.support.annotation.NonNull;

import com.walmartlabs.electrode.reactnative.bridge.ElectrodeBridgeEventListener;
import com.walmartlabs.electrode.reactnative.bridge.ElectrodeBridgeEvent;
import com.walmartlabs.electrode.reactnative.bridge.ElectrodeBridgeRequestHandler;
import com.walmartlabs.electrode.reactnative.bridge.ElectrodeBridgeResponseListener;
import com.walmartlabs.electrode.reactnative.bridge.None;
import java.util.*;
import java.util.UUID;


public final class HttpCLientApi {
    private static final Requests REQUESTS;

    static {
        REQUESTS = new HttpCLientRequests();
    }

    private HttpCLientApi() {
    }

    @NonNull
    public static Requests requests() {
        return REQUESTS;
    }



    public interface Requests {
        String REQUEST_REQUEST = "com.HttpClientApi.ern.api.request.request";


        void registerRequestRequestHandler(@NonNull final ElectrodeBridgeRequestHandler<RequestData, String> handler);

        void request(RequestData requestData, @NonNull final ElectrodeBridgeResponseListener<String> responseListener);

    }
}