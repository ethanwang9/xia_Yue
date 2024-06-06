package burp;

import java.awt.Component;

public interface IMessageEditor {
    Component getComponent();

    void setMessage(byte[] var1, boolean var2);

    byte[] getMessage();

    boolean isMessageModified();

    byte[] getSelectedData();

    int[] getSelectionBounds();
}
