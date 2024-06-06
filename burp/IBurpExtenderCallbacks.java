package burp;

import java.awt.Component;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public interface IBurpExtenderCallbacks {
    int TOOL_SUITE = 1;
    int TOOL_TARGET = 2;
    int TOOL_PROXY = 4;
    int TOOL_SPIDER = 8;
    int TOOL_SCANNER = 16;
    int TOOL_INTRUDER = 32;
    int TOOL_REPEATER = 64;
    int TOOL_SEQUENCER = 128;
    int TOOL_DECODER = 256;
    int TOOL_COMPARER = 512;
    int TOOL_EXTENDER = 1024;

    void setExtensionName(String var1);

    IExtensionHelpers getHelpers();

    OutputStream getStdout();

    OutputStream getStderr();

    void printOutput(String var1);

    void printError(String var1);

    void registerExtensionStateListener(IExtensionStateListener var1);

    List<IExtensionStateListener> getExtensionStateListeners();

    void removeExtensionStateListener(IExtensionStateListener var1);

    void registerHttpListener(IHttpListener var1);

    List<IHttpListener> getHttpListeners();

    void removeHttpListener(IHttpListener var1);

    void registerProxyListener(IProxyListener var1);

    List<IProxyListener> getProxyListeners();

    void removeProxyListener(IProxyListener var1);

    void registerScannerListener(IScannerListener var1);

    List<IScannerListener> getScannerListeners();

    void removeScannerListener(IScannerListener var1);

    void registerScopeChangeListener(IScopeChangeListener var1);

    List<IScopeChangeListener> getScopeChangeListeners();

    void removeScopeChangeListener(IScopeChangeListener var1);

    void registerContextMenuFactory(IContextMenuFactory var1);

    List<IContextMenuFactory> getContextMenuFactories();

    void removeContextMenuFactory(IContextMenuFactory var1);

    void registerMessageEditorTabFactory(IMessageEditorTabFactory var1);

    List<IMessageEditorTabFactory> getMessageEditorTabFactories();

    void removeMessageEditorTabFactory(IMessageEditorTabFactory var1);

    void registerScannerInsertionPointProvider(IScannerInsertionPointProvider var1);

    List<IScannerInsertionPointProvider> getScannerInsertionPointProviders();

    void removeScannerInsertionPointProvider(IScannerInsertionPointProvider var1);

    void registerScannerCheck(IScannerCheck var1);

    List<IScannerCheck> getScannerChecks();

    void removeScannerCheck(IScannerCheck var1);

    void registerIntruderPayloadGeneratorFactory(IIntruderPayloadGeneratorFactory var1);

    List<IIntruderPayloadGeneratorFactory> getIntruderPayloadGeneratorFactories();

    void removeIntruderPayloadGeneratorFactory(IIntruderPayloadGeneratorFactory var1);

    void registerIntruderPayloadProcessor(IIntruderPayloadProcessor var1);

    List<IIntruderPayloadProcessor> getIntruderPayloadProcessors();

    void removeIntruderPayloadProcessor(IIntruderPayloadProcessor var1);

    void registerSessionHandlingAction(ISessionHandlingAction var1);

    List<ISessionHandlingAction> getSessionHandlingActions();

    void removeSessionHandlingAction(ISessionHandlingAction var1);

    void unloadExtension();

    void addSuiteTab(ITab var1);

    void removeSuiteTab(ITab var1);

    void customizeUiComponent(Component var1);

    IMessageEditor createMessageEditor(IMessageEditorController var1, boolean var2);

    String[] getCommandLineArguments();

    void saveExtensionSetting(String var1, String var2);

    String loadExtensionSetting(String var1);

    ITextEditor createTextEditor();

    void sendToRepeater(String var1, int var2, boolean var3, byte[] var4, String var5);

    void sendToIntruder(String var1, int var2, boolean var3, byte[] var4);

    void sendToIntruder(String var1, int var2, boolean var3, byte[] var4, List<int[]> var5);

    void sendToComparer(byte[] var1);

    void sendToSpider(URL var1);

    IScanQueueItem doActiveScan(String var1, int var2, boolean var3, byte[] var4);

    IScanQueueItem doActiveScan(String var1, int var2, boolean var3, byte[] var4, List<int[]> var5);

    void doPassiveScan(String var1, int var2, boolean var3, byte[] var4, byte[] var5);

    IHttpRequestResponse makeHttpRequest(IHttpService var1, byte[] var2);

    byte[] makeHttpRequest(String var1, int var2, boolean var3, byte[] var4);

    boolean isInScope(URL var1);

    void includeInScope(URL var1);

    void excludeFromScope(URL var1);

    void issueAlert(String var1);

    IHttpRequestResponse[] getProxyHistory();

    IHttpRequestResponse[] getSiteMap(String var1);

    IScanIssue[] getScanIssues(String var1);

    void generateScanReport(String var1, IScanIssue[] var2, File var3);

    List<ICookie> getCookieJarContents();

    void updateCookieJar(ICookie var1);

    void addToSiteMap(IHttpRequestResponse var1);

    /** @deprecated */
    @Deprecated
    void restoreState(File var1);

    /** @deprecated */
    @Deprecated
    void saveState(File var1);

    /** @deprecated */
    @Deprecated
    Map<String, String> saveConfig();

    /** @deprecated */
    @Deprecated
    void loadConfig(Map<String, String> var1);

    String saveConfigAsJson(String... var1);

    void loadConfigFromJson(String var1);

    void setProxyInterceptionEnabled(boolean var1);

    String[] getBurpVersion();

    String getExtensionFilename();

    boolean isExtensionBapp();

    void exitSuite(boolean var1);

    ITempFile saveToTempFile(byte[] var1);

    IHttpRequestResponsePersisted saveBuffersToTempFiles(IHttpRequestResponse var1);

    IHttpRequestResponseWithMarkers applyMarkers(IHttpRequestResponse var1, List<int[]> var2, List<int[]> var3);

    String getToolName(int var1);

    void addScanIssue(IScanIssue var1);

    IBurpCollaboratorClientContext createBurpCollaboratorClientContext();

    /** @deprecated */
    @Deprecated
    String[][] getParameters(byte[] var1);

    /** @deprecated */
    @Deprecated
    String[] getHeaders(byte[] var1);

    /** @deprecated */
    @Deprecated
    void registerMenuItem(String var1, IMenuItemHandler var2);
}
