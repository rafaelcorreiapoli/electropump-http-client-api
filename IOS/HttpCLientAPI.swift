public class HttpCLientAPI: NSObject  {

    static let kRequestRequest = "com.HttpClientApi.ern.api.request.request";


    public lazy var requests: HttpCLientAPIRequests = {
        return HttpCLientRequests()
    }()
}


public class HttpCLientAPIRequests: NSObject {
    public func registerRequestRequestHandler(handler: @escaping ElectrodeBridgeRequestCompletionHandler) {
        assertionFailure("should override")
    }

    public func request(requestData: RequestData, responseCompletionHandler: @escaping ElectrodeBridgeResponseCompletionHandler) {
        assertionFailure("should override")
    }

}

