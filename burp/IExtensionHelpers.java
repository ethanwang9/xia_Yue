package burp;

import java.net.URL;
import java.util.List;

public interface IExtensionHelpers {
    IRequestInfo analyzeRequest(IHttpRequestResponse var1);

    IRequestInfo analyzeRequest(IHttpService var1, byte[] var2);

    IRequestInfo analyzeRequest(byte[] var1);

    IResponseInfo analyzeResponse(byte[] var1);

    IParameter getRequestParameter(byte[] var1, String var2);

    String urlDecode(String var1);

    String urlEncode(String var1);

    byte[] urlDecode(byte[] var1);

    byte[] urlEncode(byte[] var1);

    byte[] base64Decode(String var1);

    byte[] base64Decode(byte[] var1);

    String base64Encode(String var1);

    String base64Encode(byte[] var1);

    byte[] stringToBytes(String var1);

    String bytesToString(byte[] var1);

    int indexOf(byte[] var1, byte[] var2, boolean var3, int var4, int var5);

    byte[] buildHttpMessage(List<String> var1, byte[] var2);

    byte[] buildHttpRequest(URL var1);

    byte[] addParameter(byte[] var1, IParameter var2);

    byte[] removeParameter(byte[] var1, IParameter var2);

    byte[] updateParameter(byte[] var1, IParameter var2);

    byte[] toggleRequestMethod(byte[] var1);

    IHttpService buildHttpService(String var1, int var2, String var3);

    IHttpService buildHttpService(String var1, int var2, boolean var3);

    IParameter buildParameter(String var1, String var2, byte var3);

    IScannerInsertionPoint makeScannerInsertionPoint(String var1, byte[] var2, int var3, int var4);

    IResponseVariations analyzeResponseVariations(byte[]... var1);

    IResponseKeywords analyzeResponseKeywords(List<String> var1, byte[]... var2);
}
