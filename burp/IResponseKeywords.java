package burp;

import java.util.List;

public interface IResponseKeywords {
    List<String> getVariantKeywords();

    List<String> getInvariantKeywords();

    int getKeywordCount(String var1, int var2);

    void updateWith(byte[]... var1);
}
