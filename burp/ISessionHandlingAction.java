package burp;

public interface ISessionHandlingAction {
    String getActionName();

    void performAction(IHttpRequestResponse var1, IHttpRequestResponse[] var2);
}
