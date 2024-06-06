package burp;

public interface ITempFile {
    byte[] getBuffer();

    /** @deprecated */
    @Deprecated
    void delete();
}
