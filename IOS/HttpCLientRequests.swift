
public class HttpCLientRequests: HttpCLientAPIRequests {

    public override func registerRequestRequestHandler(handler:  @escaping ElectrodeBridgeRequestCompletionHandler) {
        let requestHandlerProcessor = ElectrodeRequestHandlerProcessor(requestName: HttpCLientAPI.kRequestRequest,
    reqClass: RequestData.self, 
    respClass: String.self,
    requestCompletionHandler: handler)
        requestHandlerProcessor.execute()
    }

    //------------------------------------------------------------------------------------------------------------------------------------


    public override func request(requestData: RequestData, responseCompletionHandler: @escaping ElectrodeBridgeResponseCompletionHandler) {
        let requestProcessor = ElectrodeRequestProcessor<RequestData, String, Any>(
            requestName: HttpCLientAPI.kRequestRequest,
            requestPayload: requestData,
            respClass: String.self,
            responseItemType: nil,
            responseCompletionHandler: responseCompletionHandler)

        requestProcessor.execute()
    }
}