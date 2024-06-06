package burp;

public interface IHttpListener {
    void processHttpMessage(int var1, boolean var2, IHttpRequestResponse var3);

    byte[] getRequest();
}
