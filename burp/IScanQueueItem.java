package burp;

public interface IScanQueueItem {
    String getStatus();

    byte getPercentageComplete();

    int getNumRequests();

    int getNumErrors();

    int getNumInsertionPoints();

    void cancel();

    IScanIssue[] getIssues();
}
