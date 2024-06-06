package burp;

import java.util.List;

public interface IScannerInsertionPointProvider {
    List<IScannerInsertionPoint> getInsertionPoints(IHttpRequestResponse var1);
}
