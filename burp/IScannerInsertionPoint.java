package burp;

public interface IScannerInsertionPoint {
    byte INS_PARAM_URL = 0;
    byte INS_PARAM_BODY = 1;
    byte INS_PARAM_COOKIE = 2;
    byte INS_PARAM_XML = 3;
    byte INS_PARAM_XML_ATTR = 4;
    byte INS_PARAM_MULTIPART_ATTR = 5;
    byte INS_PARAM_JSON = 6;
    byte INS_PARAM_AMF = 7;
    byte INS_HEADER = 32;
    byte INS_URL_PATH_FOLDER = 33;
    /** @deprecated */
    @Deprecated
    byte INS_URL_PATH_REST = 33;
    byte INS_PARAM_NAME_URL = 34;
    byte INS_PARAM_NAME_BODY = 35;
    byte INS_ENTIRE_BODY = 36;
    byte INS_URL_PATH_FILENAME = 37;
    byte INS_USER_PROVIDED = 64;
    byte INS_EXTENSION_PROVIDED = 65;
    byte INS_UNKNOWN = 127;

    String getInsertionPointName();

    String getBaseValue();

    byte[] buildRequest(byte[] var1);

    int[] getPayloadOffsets(byte[] var1);

    byte getInsertionPointType();
}
