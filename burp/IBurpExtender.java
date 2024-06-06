package burp;

public interface IBurpExtender {
    void registerExtenderCallbacks(IBurpExtenderCallbacks var1);

    void processHttpMessage(int var1, boolean var2, IHttpRequestResponse var3);

    byte[] getResponse();

    IHttpService getHttpService();
}
