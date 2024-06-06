package burp;

import java.awt.Component;

public interface IMessageEditorTab {
    String getTabCaption();

    Component getUiComponent();

    boolean isEnabled(byte[] var1, boolean var2);

    void setMessage(byte[] var1, boolean var2);

    byte[] getMessage();

    boolean isModified();

    byte[] getSelectedData();
}
