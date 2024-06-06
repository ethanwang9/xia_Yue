package burp;

import java.util.List;

public interface IScannerCheck {
    List<IScanIssue> doPassiveScan(IHttpRequestResponse var1);

    List<IScanIssue> doActiveScan(IHttpRequestResponse var1, IScannerInsertionPoint var2);

    int consolidateDuplicateIssues(IScanIssue var1, IScanIssue var2);
}
