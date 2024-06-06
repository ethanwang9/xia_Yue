package burp;

public interface IHttpRequestResponsePersisted extends IHttpRequestResponse {
    /** @deprecated */
    @Deprecated
    void deleteTempFiles();
}
