package burp;

public interface IHttpRequestResponse {
    byte[] getRequest();

    void setRequest(byte[] var1);

    byte[] getResponse();

    void setResponse(byte[] var1);

    String getComment();

    void setComment(String var1);

    String getHighlight();

    void setHighlight(String var1);

    IHttpService getHttpService();

    void setHttpService(IHttpService var1);
}
