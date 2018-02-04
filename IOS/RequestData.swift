
public class RequestData: ElectrodeObject, Bridgeable {

    private static let tag = String(describing: type(of: self))

    public let url: String
    public let method: String

    public init(url: String, method: String) {
        self.url = url
        self.method = method
        super.init()
    }

    public override init() {
        self.url = String()
        self.method = String()
        super.init()
    }

    required public init(dictionary:[AnyHashable:Any]) {
        if

                let url = dictionary["url"] as? String,

                let method = dictionary["method"] as? String { 
            self.url = url
            self.method = method
        } else {
            assertionFailure("\(RequestData.tag) missing one or more required properties[url,method]")
            self.url = dictionary["url"] as! String
            self.method = dictionary["method"] as! String
        }


        super.init(dictionary: dictionary)
    }

    public func toDictionary() -> NSDictionary {
        var dict =  [
            "url": self.url,
            "method": self.method
        ] as [AnyHashable : Any]

        return dict as NSDictionary
    }

}
