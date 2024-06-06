package burp;

import java.net.URL;
import java.util.List;

public interface IRequestInfo {
    byte CONTENT_TYPE_NONE = 0;
    byte CONTENT_TYPE_URL_ENCODED = 1;
    byte CONTENT_TYPE_MULTIPART = 2;
    byte CONTENT_TYPE_XML = 3;
    byte CONTENT_TYPE_JSON = 4;
    byte CONTENT_TYPE_AMF = 5;
    byte CONTENT_TYPE_UNKNOWN = -1;

    String getMethod();

    URL getUrl();

    List<String> getHeaders();

    List<IParameter> getParameters();

    int getBodyOffset();

    byte getContentType();
}
