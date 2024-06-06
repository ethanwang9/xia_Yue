package burp;

public interface IIntruderPayloadProcessor {
    String getProcessorName();

    byte[] processPayload(byte[] var1, byte[] var2, byte[] var3);
}
