package burp;

import java.awt.Component;

public interface ITextEditor {
    Component getComponent();

    void setEditable(boolean var1);

    void setText(byte[] var1);

    byte[] getText();

    boolean isTextModified();

    byte[] getSelectedText();

    int[] getSelectionBounds();

    void setSearchExpression(String var1);
}
