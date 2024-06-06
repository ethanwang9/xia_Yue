package burp;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class BurpExtender extends AbstractTableModel implements IBurpExtender, ITab, IHttpListener, IScannerCheck, IMessageEditorController {
    private IBurpExtenderCallbacks callbacks;
    private IExtensionHelpers helpers;
    private JSplitPane splitPane;
    private IMessageEditor requestViewer;
    private IMessageEditor responseViewer;
    private IMessageEditor requestViewer_1;
    private IMessageEditor responseViewer_1;
    private IMessageEditor requestViewer_2;
    private IMessageEditor responseViewer_2;
    private final List<LogEntry> log = new ArrayList<>();
    private IHttpRequestResponse currentlyDisplayedItem;
    private IHttpRequestResponse currentlyDisplayedItem_1;
    private IHttpRequestResponse currentlyDisplayedItem_2;
    private final List<Request_md5> log4_md5 = new ArrayList<>();
    public PrintWriter stdout;
    JTabbedPane tabs;
    int switchs = 0;
    int conut = 0;
    int original_data_len;
    String temp_data;
    int select_row = 0;
    Table logTable;
    String white_URL = "";
    int white_switchs = 0;
    String data_1 = "";
    String data_2 = "";
    String universal_cookie = "";

    public BurpExtender() {
    }

    public void registerExtenderCallbacks(final IBurpExtenderCallbacks callbacks) {
        this.stdout = new PrintWriter(callbacks.getStdout(), true);
        this.stdout.println("hello xia Yue!");
        this.stdout.println("��� ��ӭʹ�� ϹԽ!");
        this.stdout.println("version:1.2");
        this.callbacks = callbacks;
        this.helpers = callbacks.getHelpers();
        callbacks.setExtensionName("xia Yue V1.2 changed Ethan.Wang V1.0");
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                BurpExtender.this.splitPane = new JSplitPane(1);
                JSplitPane splitPanes = new JSplitPane(0);
                JSplitPane splitPanes_2 = new JSplitPane(0);
                BurpExtender.this.logTable = BurpExtender.this.new Table(BurpExtender.this);
                BurpExtender.this.logTable.getColumnModel().getColumn(0).setPreferredWidth(10);
                BurpExtender.this.logTable.getColumnModel().getColumn(1).setPreferredWidth(50);
                BurpExtender.this.logTable.getColumnModel().getColumn(2).setPreferredWidth(300);
                JScrollPane scrollPane = new JScrollPane(BurpExtender.this.logTable);
                JPanel jp = new JPanel();
                jp.setLayout(new GridLayout(1, 1));
                jp.add(scrollPane);
                JPanel jps = new JPanel();
                jps.setLayout(new GridLayout(10, 1));
                JLabel jls = new JLabel("�������ϹԽ author�������[��");
                JLabel jls_1 = new JLabel("��˾:www.t00ls.com");
                JLabel jls_2 = new JLabel("�汾��xia Yue V1.2 changed Ethan.Wang V1.0");
                JLabel jls_3 = new JLabel("��л������Moonlit");
                final JCheckBox chkbox1 = new JCheckBox("�������");
                final JCheckBox chkbox2 = new JCheckBox("��������cookie");
                JLabel jls_5 = new JLabel("�����Ҫ��������Ӱ�����,����");
                final JTextField textField = new JTextField("��д����������");
                JButton btn1 = new JButton("����б�");
                final JButton btn3 = new JButton("����������");
                JPanel jps_2 = new JPanel();
                JLabel jps_2_jls_1 = new JLabel("ԽȨ����д��Ȩ����֤��Ϣ,�����滻������");
                final JTextArea jta = new JTextArea("Cookie: JSESSIONID=test;UUID=1; userid=admin\nAuthorization: Bearer test", 5, 30);
                JScrollPane jsp = new JScrollPane(jta);
                JLabel jps_2_jls_2 = new JLabel("δ��Ȩ�����Ƴ�����ͷ����֤��Ϣ,���ִ�Сд");
                final JTextArea jta_1 = new JTextArea("Cookie\nAuthorization\nToken", 5, 30);
                JScrollPane jsp_1 = new JScrollPane(jta_1);
                jps_2.add(jps_2_jls_1);
                jps_2.add(jsp);
                jps_2.add(jps_2_jls_2);
                jps_2.add(jsp_1);
                jps_2.setLayout(new GridLayout(5, 1, 0, 0));
                chkbox1.addItemListener(new ItemListener() {
                    public void itemStateChanged(ItemEvent e) {
                        if (chkbox1.isSelected()) {
                            BurpExtender.this.switchs = 1;
                            BurpExtender.this.data_1 = jta.getText();
                            BurpExtender.this.data_2 = jta_1.getText();
                            jta.setForeground(Color.BLACK);
                            jta.setBackground(Color.LIGHT_GRAY);
                            jta.setEditable(false);
                            jta_1.setForeground(Color.BLACK);
                            jta_1.setBackground(Color.LIGHT_GRAY);
                            jta_1.setEditable(false);
                        } else {
                            BurpExtender.this.switchs = 0;
                            jta.setForeground(Color.BLACK);
                            jta.setBackground(Color.WHITE);
                            jta.setEditable(true);
                            jta_1.setForeground(Color.BLACK);
                            jta_1.setBackground(Color.WHITE);
                            jta_1.setEditable(true);
                        }

                    }
                });
                chkbox2.addItemListener(new ItemListener() {
                    public void itemStateChanged(ItemEvent e) {
                        BurpExtender.this.universal_cookie = "";
                    }
                });
                btn1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        BurpExtender.this.log.clear();
                        BurpExtender.this.conut = 0;
                        BurpExtender.this.log4_md5.clear();
                        BurpExtender.this.fireTableRowsInserted(BurpExtender.this.log.size(), BurpExtender.this.log.size());
                    }
                });
                btn3.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (btn3.getText().equals("����������")) {
                            btn3.setText("�رհ�����");
                            BurpExtender.this.white_URL = textField.getText();
                            BurpExtender.this.white_switchs = 1;
                            textField.setEditable(false);
                            textField.setForeground(Color.GRAY);
                        } else {
                            btn3.setText("����������");
                            BurpExtender.this.white_switchs = 0;
                            textField.setEditable(true);
                            textField.setForeground(Color.BLACK);
                        }

                    }
                });
                jps.add(jls);
                jps.add(jls_1);
                jps.add(jls_2);
                jps.add(jls_3);
                jps.add(chkbox1);
                jps.add(btn1);
                jps.add(jls_5);
                jps.add(textField);
                jps.add(btn3);
                BurpExtender.this.tabs = new JTabbedPane();
                BurpExtender.this.requestViewer = callbacks.createMessageEditor(BurpExtender.this, false);
                BurpExtender.this.responseViewer = callbacks.createMessageEditor(BurpExtender.this, false);
                BurpExtender.this.requestViewer_1 = callbacks.createMessageEditor(BurpExtender.this, false);
                BurpExtender.this.responseViewer_1 = callbacks.createMessageEditor(BurpExtender.this, false);
                BurpExtender.this.requestViewer_2 = callbacks.createMessageEditor(BurpExtender.this, false);
                BurpExtender.this.responseViewer_2 = callbacks.createMessageEditor(BurpExtender.this, false);
                JSplitPane y_jp = new JSplitPane(1);
                y_jp.setDividerLocation(500);
                y_jp.setLeftComponent(BurpExtender.this.requestViewer.getComponent());
                y_jp.setRightComponent(BurpExtender.this.responseViewer.getComponent());
                JSplitPane d_jp = new JSplitPane(1);
                d_jp.setDividerLocation(500);
                d_jp.setLeftComponent(BurpExtender.this.requestViewer_1.getComponent());
                d_jp.setRightComponent(BurpExtender.this.responseViewer_1.getComponent());
                JSplitPane w_jp = new JSplitPane(1);
                w_jp.setDividerLocation(500);
                w_jp.setLeftComponent(BurpExtender.this.requestViewer_2.getComponent());
                w_jp.setRightComponent(BurpExtender.this.responseViewer_2.getComponent());
                BurpExtender.this.tabs.addTab("ԭʼ���ݰ�", y_jp);
                BurpExtender.this.tabs.addTab("��Ȩ�����ݰ�", d_jp);
                BurpExtender.this.tabs.addTab("δ��Ȩ���ݰ�", w_jp);
                splitPanes_2.setLeftComponent(jps);
                splitPanes_2.setRightComponent(jps_2);
                splitPanes.setLeftComponent(jp);
                splitPanes.setRightComponent(BurpExtender.this.tabs);
                BurpExtender.this.splitPane.setLeftComponent(splitPanes);
                BurpExtender.this.splitPane.setRightComponent(splitPanes_2);
                BurpExtender.this.splitPane.setDividerLocation(1000);
                callbacks.customizeUiComponent(BurpExtender.this.splitPane);
                callbacks.customizeUiComponent(BurpExtender.this.logTable);
                callbacks.customizeUiComponent(scrollPane);
                callbacks.customizeUiComponent(jps);
                callbacks.customizeUiComponent(jp);
                callbacks.customizeUiComponent(BurpExtender.this.tabs);
                callbacks.addSuiteTab(BurpExtender.this);
                callbacks.registerHttpListener(BurpExtender.this);
                callbacks.registerScannerCheck(BurpExtender.this);
            }
        });
    }

    public String getTabCaption() {
        return "xia Yue";
    }

    public Component getUiComponent() {
        return this.splitPane;
    }

    public void processHttpMessage(final int toolFlag, boolean messageIsRequest, final IHttpRequestResponse messageInfo) {
        if (this.switchs == 1 && toolFlag == 4 && !messageIsRequest) {
            synchronized(this.log) {
                Thread thread = new Thread(new Runnable() {
                    public void run() {
                        try {
                            BurpExtender.this.checkVul(messageInfo, toolFlag);
                        } catch (Exception var2) {
                            var2.printStackTrace();
                            BurpExtender.this.stdout.println(var2);
                        }

                    }
                });
                thread.start();
            }
        }

    }

    public List<IScanIssue> doPassiveScan(IHttpRequestResponse baseRequestResponse) {
        return null;
    }

    private void checkVul(IHttpRequestResponse baseRequestResponse, int toolFlag) {
        this.temp_data = String.valueOf(this.helpers.analyzeRequest(baseRequestResponse).getUrl());
        this.original_data_len = baseRequestResponse.getResponse().length;
        int original_len = this.original_data_len - this.helpers.analyzeResponse(baseRequestResponse.getResponse()).getBodyOffset();
        String[] temp_data_strarray = this.temp_data.split("\\?");
        String temp_data = temp_data_strarray[0];
        String[] white_URL_list = this.white_URL.split(",");
        boolean white_swith;
        if (this.white_switchs == 1) {
            white_swith = false;

            for (String s : white_URL_list) {
                if (temp_data.contains(s)) {
                    this.stdout.println("������URL��" + temp_data);
                    white_swith = true;
                }
            }

            if (!white_swith) {
                this.stdout.println("���ǰ�����URL��" + temp_data);
                return;
            }
        }

        int bodyOffset;
        if (toolFlag == 4 || toolFlag == 64) {
            String[] static_file = new String[]{"jpg", "png", "gif", "css", "js", "pdf", "mp3", "mp4", "avi", "map", "svg", "ico", "svg", "woff", "woff2", "ttf"};
            String[] static_file_1 = temp_data.split("\\.");
            String static_file_2 = static_file_1[static_file_1.length - 1];
            bodyOffset = static_file.length;

            for(int var13 = 0; var13 < bodyOffset; ++var13) {
                String i = static_file[var13];
                if (static_file_2.equals(i)) {
                    this.stdout.println("��ǰurlΪ��̬�ļ���" + temp_data + "\n");
                    return;
                }
            }
        }

        List<IParameter> paraLists = this.helpers.analyzeRequest(baseRequestResponse).getParameters();

        Iterator var29;
        IParameter para;
        for(var29 = paraLists.iterator(); var29.hasNext(); temp_data = temp_data + "+" + para.getName()) {
            para = (IParameter)var29.next();
        }

        temp_data = temp_data + "+" + this.helpers.analyzeRequest(baseRequestResponse).getMethod();
        this.stdout.println("\nMD5(\"" + temp_data + "\")");
        temp_data = MD5(temp_data);
        this.stdout.println(temp_data);
        var29 = this.log4_md5.iterator();

        while(var29.hasNext()) {
            Request_md5 i = (Request_md5)var29.next();
            if (i.md5_data.equals(temp_data)) {
                return;
            }
        }

        this.log4_md5.add(new Request_md5(temp_data));
        IRequestInfo analyIRequestInfo = this.helpers.analyzeRequest(baseRequestResponse);
        IHttpService iHttpService = baseRequestResponse.getHttpService();
        String request = this.helpers.bytesToString(baseRequestResponse.getRequest());
        bodyOffset = analyIRequestInfo.getBodyOffset();
        byte[] body = request.substring(bodyOffset).getBytes();
        List<String> headers_y = analyIRequestInfo.getHeaders();
        String[] data_1_list = this.data_1.split("\n");

        int i;
        int low_len;
        for(i = 0; i < headers_y.size(); ++i) {
            String head_key = headers_y.get(i).split(":")[0];

            for(low_len = 0; low_len < data_1_list.length; ++low_len) {
                if (head_key.equals(data_1_list[low_len].split(":")[0])) {
                    headers_y.remove(i);
                }
            }
        }

        for(i = 0; i < data_1_list.length; ++i) {
            headers_y.add(headers_y.size() / 2, data_1_list[i]);
        }

        byte[] newRequest_y = this.helpers.buildHttpMessage(headers_y, body);
        IHttpRequestResponse requestResponse_y = this.callbacks.makeHttpRequest(iHttpService, newRequest_y);
        low_len = requestResponse_y.getResponse().length - this.helpers.analyzeResponse(requestResponse_y.getResponse()).getBodyOffset();
        String low_len_data;
        String var10000;
        if (original_len == 0) {
            low_len_data = Integer.toString(low_len);
        } else if (original_len == low_len) {
            low_len_data = low_len + "  ��";
        } else {
            var10000 = Integer.toString(low_len);
            low_len_data = var10000 + "  ==> " + (original_len - low_len);
        }

        List<String> headers_w = analyIRequestInfo.getHeaders();
        String[] data_2_list = this.data_2.split("\n");

        int Unauthorized_len;
        for(i = 0; i < headers_w.size(); ++i) {
            String head_key = headers_w.get(i).split(":")[0];

            for(Unauthorized_len = 0; Unauthorized_len < data_2_list.length; ++Unauthorized_len) {
                if (head_key.equals(data_2_list[Unauthorized_len])) {
                    headers_w.remove(i);
                }
            }
        }

        if (!this.universal_cookie.isEmpty()) {
            String[] universal_cookies = this.universal_cookie.split("\n");
            headers_w.add(headers_w.size() / 2, universal_cookies[0]);
            headers_w.add(headers_w.size() / 2, universal_cookies[1]);
        }

        byte[] newRequest_w = this.helpers.buildHttpMessage(headers_w, body);
        IHttpRequestResponse requestResponse_w = this.callbacks.makeHttpRequest(iHttpService, newRequest_w);
        Unauthorized_len = requestResponse_w.getResponse().length - this.helpers.analyzeResponse(requestResponse_w.getResponse()).getBodyOffset();
        String original_len_data;
        if (original_len == 0) {
            original_len_data = Integer.toString(Unauthorized_len);
        } else if (original_len == Unauthorized_len) {
            original_len_data = Unauthorized_len + "  ��";
        } else {
            var10000 = Integer.toString(Unauthorized_len);
            original_len_data = var10000 + "  ==> " + (original_len - Unauthorized_len);
        }

        ++this.conut;
        int id = this.conut;
        this.log.add(new LogEntry(id, this.helpers.analyzeRequest(baseRequestResponse).getMethod(), this.callbacks.saveBuffersToTempFiles(baseRequestResponse), this.callbacks.saveBuffersToTempFiles(requestResponse_y), this.callbacks.saveBuffersToTempFiles(requestResponse_w), String.valueOf(this.helpers.analyzeRequest(baseRequestResponse).getUrl()), original_len, low_len_data, original_len_data));
        this.fireTableDataChanged();
        this.logTable.setRowSelectionInterval(this.select_row, this.select_row);
    }

    public List<IScanIssue> doActiveScan(IHttpRequestResponse baseRequestResponse, IScannerInsertionPoint insertionPoint) {
        return null;
    }

    public int consolidateDuplicateIssues(IScanIssue existingIssue, IScanIssue newIssue) {
        return existingIssue.getIssueName().equals(newIssue.getIssueName()) ? -1 : 0;
    }

    public int getRowCount() {
        return this.log.size();
    }

    public int getColumnCount() {
        return 6;
    }

    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0 -> {
                return "#";
            }
            case 1 -> {
                return "����";
            }
            case 2 -> {
                return "URL";
            }
            case 3 -> {
                return "ԭʼ������";
            }
            case 4 -> {
                return "��Ȩ�ް�����";
            }
            case 5 -> {
                return "δ��Ȩ������";
            }
            default -> {
                return "";
            }
        }
    }

    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        LogEntry logEntry = this.log.get(rowIndex);
        switch (columnIndex) {
            case 0 -> {
                return logEntry.id;
            }
            case 1 -> {
                return logEntry.Method;
            }
            case 2 -> {
                return logEntry.url;
            }
            case 3 -> {
                return logEntry.original_len;
            }
            case 4 -> {
                return logEntry.low_len;
            }
            case 5 -> {
                return logEntry.Unauthorized_len;
            }
            default -> {
                return "";
            }
        }
    }

    public byte[] getRequest() {
        return this.currentlyDisplayedItem.getRequest();
    }

    public byte[] getResponse() {
        return this.currentlyDisplayedItem.getResponse();
    }

    public IHttpService getHttpService() {
        return this.currentlyDisplayedItem.getHttpService();
    }

    public static String MD5(String key) {
        char[] hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        try {
            byte[] btInput = key.getBytes();
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            int j = md.length;
            char[] str = new char[j * 2];
            int k = 0;

            for (byte byte0 : md) {
                str[k++] = hexDigits[byte0 >>> 4 & 15];
                str[k++] = hexDigits[byte0 & 15];
            }

            return new String(str);
        } catch (Exception var10) {
            return null;
        }
    }

    private static class Request_md5 {
        final String md5_data;

        Request_md5(String md5_data) {
            this.md5_data = md5_data;
        }
    }

    private static class LogEntry {
        final int id;
        final String Method;
        final IHttpRequestResponsePersisted requestResponse;
        final IHttpRequestResponsePersisted requestResponse_1;
        final IHttpRequestResponsePersisted requestResponse_2;
        final String url;
        final int original_len;
        final String low_len;
        final String Unauthorized_len;

        LogEntry(int id, String Method, IHttpRequestResponsePersisted requestResponse, IHttpRequestResponsePersisted requestResponse_1, IHttpRequestResponsePersisted requestResponse_2, String url, int original_len, String low_len, String Unauthorized_len) {
            this.id = id;
            this.Method = Method;
            this.requestResponse = requestResponse;
            this.requestResponse_1 = requestResponse_1;
            this.requestResponse_2 = requestResponse_2;
            this.url = url;
            this.original_len = original_len;
            this.low_len = low_len;
            this.Unauthorized_len = Unauthorized_len;
        }
    }

    private class Table extends JTable {
        public Table(TableModel tableModel) {
            super(tableModel);
        }

        public void changeSelection(int row, int col, boolean toggle, boolean extend) {
            LogEntry logEntry = BurpExtender.this.log.get(row);
            BurpExtender.this.select_row = row;
            if (col == 4) {
                BurpExtender.this.tabs.setSelectedIndex(1);
            } else if (col == 5) {
                BurpExtender.this.tabs.setSelectedIndex(2);
            } else if (col == 3) {
                BurpExtender.this.tabs.setSelectedIndex(0);
            }

            BurpExtender.this.requestViewer.setMessage(logEntry.requestResponse.getRequest(), true);
            BurpExtender.this.responseViewer.setMessage(logEntry.requestResponse.getResponse(), false);
            BurpExtender.this.currentlyDisplayedItem = logEntry.requestResponse;
            BurpExtender.this.requestViewer_1.setMessage(logEntry.requestResponse_1.getRequest(), true);
            BurpExtender.this.responseViewer_1.setMessage(logEntry.requestResponse_1.getResponse(), false);
            BurpExtender.this.currentlyDisplayedItem_1 = logEntry.requestResponse_1;
            BurpExtender.this.requestViewer_2.setMessage(logEntry.requestResponse_2.getRequest(), true);
            BurpExtender.this.responseViewer_2.setMessage(logEntry.requestResponse_2.getResponse(), false);
            BurpExtender.this.currentlyDisplayedItem_2 = logEntry.requestResponse_2;
            super.changeSelection(row, col, toggle, extend);
        }
    }
}