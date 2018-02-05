
public class HttpClientRequests: HttpClientAPIRequests {

    public override func registerRequestRequestHandler(handler:  @escaping ElectrodeBridgeRequestCompletionHandler) {
        let requestHandlerProcessor = ElectrodeRequestHandlerProcessor(requestName: HttpClientAPI.kRequestRequest,
    reqClass: RequestData.self, 
    respClass: Response.self,
    requestCompletionHandler: handler)
        requestHandlerProcessor.execute()
    }

    //------------------------------------------------------------------------------------------------------------------------------------


    public override func request(requestData: RequestData, responseCompletionHandler: @escaping ElectrodeBridgeResponseCompletionHandler) {
        let requestProcessor = ElectrodeRequestProcessor<RequestData, Response, Any>(
            requestName: HttpClientAPI.kRequestRequest,
            requestPayload: requestData,
            respClass: Response.self,
            responseItemType: nil,
            responseCompletionHandler: responseCompletionHandler)

        requestProcessor.execute()
    }
}