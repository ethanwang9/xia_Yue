package burp;

import java.net.InetAddress;

public interface IInterceptedProxyMessage {
    int ACTION_FOLLOW_RULES = 0;
    int ACTION_DO_INTERCEPT = 1;
    int ACTION_DONT_INTERCEPT = 2;
    int ACTION_DROP = 3;
    int ACTION_FOLLOW_RULES_AND_REHOOK = 16;
    int ACTION_DO_INTERCEPT_AND_REHOOK = 17;
    int ACTION_DONT_INTERCEPT_AND_REHOOK = 18;

    int getMessageReference();

    IHttpRequestResponse getMessageInfo();

    int getInterceptAction();

    void setInterceptAction(int var1);

    String getListenerInterface();

    InetAddress getClientIpAddress();
}
