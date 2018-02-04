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

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.List;
import com.walmartlabs.electrode.reactnative.bridge.Bridgeable;

import static com.walmartlabs.electrode.reactnative.bridge.util.BridgeArguments.*;

public class RequestData implements Parcelable, Bridgeable {

    private String url;
    private String method;

    private RequestData() {}

    private RequestData(Builder builder) {
        this.url = builder.url;
        this.method = builder.method;
    }

    private RequestData(Parcel in) {
        this(in.readBundle());
    }

    public RequestData(@NonNull Bundle bundle) {
        if(bundle.get("url") == null){
            throw new IllegalArgumentException("url property is required");
        }
        if(bundle.get("method") == null){
            throw new IllegalArgumentException("method property is required");
        }
        this.url = bundle.getString("url");
        this.method = bundle.getString("method");
    }

    public static final Creator<RequestData> CREATOR = new Creator<RequestData>() {
        @Override
        public RequestData createFromParcel(Parcel in) {
            return new RequestData(in);
        }

        @Override
        public RequestData[] newArray(int size) {
            return new RequestData[size];
        }
    };

    @NonNull
    public String geturl() {
        return url;
    }

    /**
    * Method for the request (currently supported: get and post)
    *
    * @return String
    */
    @NonNull
    public String getmethod() {
        return method;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeBundle(toBundle());
    }

    @NonNull
    @Override
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        this.url = bundle.getString("url");
        this.method = bundle.getString("method");
        return bundle;
    }

    public static class Builder {
        private final String url;
        private final String method;

        public Builder(@NonNull String url, @NonNull String method) {
            this.url = url;
            this.method = method;
        }


        @NonNull
        public RequestData build() {
            return new RequestData(this);
        }
    }
}