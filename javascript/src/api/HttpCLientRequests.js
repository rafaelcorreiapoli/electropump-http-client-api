// @flow


export default class HttpCLientRequests {
    constructor(bridge) {
     this._bridge = bridge;
    }

        /**
         * Registers a handler for a particular api.  This allows javascript to handle a request from native.
         * @param The handler function, taking a single parameter being the data of the request and returning a Promise. Implementer of the handler should either resolve the promise with an object being the response data (if any) or reject the promise with an Error
         */
    registerRequestRequestHandler( handler : Function): Promise<any> {
        this._bridge.registerRequestHandler("com.HttpClientApi.ern.api.request.request", handler);
    }

    //------------------------------------------------------------------------------------------------------------------------------------


    /**
      * Single api through which every request is made
      * @param  url 
      * @param  method Method for the request (currently supported: get and post)
      * @param integer timeout in milliseconds
      * @return {Promise} a {@link https://www.promisejs.org/|Promise}, with data of type {@link String }
      */

     request(url: string, method: string,timeout: number): Promise<any> {
     const data =  {}
        // verify the required parameter 'url' is set
        if (url  == null) {
        throw "Missing the required parameter 'url' when calling 'HttpCLientApi#request'";
        }
        // verify the required parameter 'method' is set
        if (method  == null) {
        throw "Missing the required parameter 'method' when calling 'HttpCLientApi#request'";
        }
          data['url'] = url;
          data['method'] = method;
        return this._bridge.sendRequest("com.HttpClientApi.ern.api.request.request", { data, timeout })
    }
}
