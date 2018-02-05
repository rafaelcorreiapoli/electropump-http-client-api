public class HttpClientAPI: NSObject  {

    static let kRequestRequest = "com.HttpClientApi.ern.api.request.request";


    public lazy var requests: HttpClientAPIRequests = {
        return HttpClientRequests()
    }()
}


public class HttpClientAPIRequests: NSObject {
    public func registerRequestRequestHandler(handler: @escaping ElectrodeBridgeRequestCompletionHandler) {
        assertionFailure("should override")
    }

    public func request(requestData: RequestData, responseCompletionHandler: @escaping ElectrodeBridgeResponseCompletionHandler) {
        assertionFailure("should override")
    }

}

