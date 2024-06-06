package burp;

import java.awt.event.InputEvent;

public interface IContextMenuInvocation {
    byte CONTEXT_MESSAGE_EDITOR_REQUEST = 0;
    byte CONTEXT_MESSAGE_EDITOR_RESPONSE = 1;
    byte CONTEXT_MESSAGE_VIEWER_REQUEST = 2;
    byte CONTEXT_MESSAGE_VIEWER_RESPONSE = 3;
    byte CONTEXT_TARGET_SITE_MAP_TREE = 4;
    byte CONTEXT_TARGET_SITE_MAP_TABLE = 5;
    byte CONTEXT_PROXY_HISTORY = 6;
    byte CONTEXT_SCANNER_RESULTS = 7;
    byte CONTEXT_INTRUDER_PAYLOAD_POSITIONS = 8;
    byte CONTEXT_INTRUDER_ATTACK_RESULTS = 9;
    byte CONTEXT_SEARCH_RESULTS = 10;

    InputEvent getInputEvent();

    int getToolFlag();

    byte getInvocationContext();

    int[] getSelectionBounds();

    IHttpRequestResponse[] getSelectedMessages();

    IScanIssue[] getSelectedIssues();
}
