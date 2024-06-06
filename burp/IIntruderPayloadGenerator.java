package burp;

public interface IIntruderPayloadGenerator {
    boolean hasMorePayloads();

    byte[] getNextPayload(byte[] var1);

    void reset();
}
