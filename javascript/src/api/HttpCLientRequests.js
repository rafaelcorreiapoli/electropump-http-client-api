// @flow


export default class HttpClientRequests {
    constructor(bridge) {
     this._bridge = bridge;
    }

        /**
         * Registers a handler for a particular api.  This allows javascript to handle a request from native.
         * @param The handler function, taking a single parameter being the data of the request and returning a Promise. Implementer of the handler should either resolve the promise with an object being the response data (if any) or reject the promise with an Error
         */
    registerFetchRequestHandler( handler : Function): Promise<any> {
        this._bridge.registerRequestHandler("com.HttpClientApi.ern.api.request.fetch", handler);
    }

    //------------------------------------------------------------------------------------------------------------------------------------


    /**
      * Single api through which every fetch is made
      * @param  url 
      * @param  method Method for the fetch (currently supported: get and post)
      * @param {Object} opts Optional parameters
      * @param  opts.data Request payload
      * @param  opts.headers Request headers
      * @param integer timeout in milliseconds
      * @return {Promise} a {@link https://www.promisejs.org/|Promise}, with data of type {@link module:com.HttpClientApi.ern.model/Response }
      */

     fetch(url: string, method: string, opts: any,timeout: number): Promise<any> {
        opts = opts || {};
     const data =  {}
        // verify the required parameter 'url' is set
        if (url  == null) {
        throw "Missing the required parameter 'url' when calling 'HttpClientApi#fetch'";
        }
        // verify the required parameter 'method' is set
        if (method  == null) {
        throw "Missing the required parameter 'method' when calling 'HttpClientApi#fetch'";
        }
          data['url'] = url;
          data['method'] = method;
          data['data'] = opts['data'];
          data['headers'] = opts['headers'];
        return this._bridge.sendRequest("com.HttpClientApi.ern.api.request.fetch", { data, timeout })
    }
}
