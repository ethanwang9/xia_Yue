package burp;

import java.util.List;

public interface IResponseVariations {
    List<String> getVariantAttributes();

    List<String> getInvariantAttributes();

    int getAttributeValue(String var1, int var2);

    void updateWith(byte[]... var1);
}
