package burp;

import java.util.List;

public interface IBurpCollaboratorClientContext {
    String generatePayload(boolean var1);

    List<IBurpCollaboratorInteraction> fetchAllCollaboratorInteractions();

    List<IBurpCollaboratorInteraction> fetchCollaboratorInteractionsFor(String var1);

    List<IBurpCollaboratorInteraction> fetchAllInfiltratorInteractions();

    List<IBurpCollaboratorInteraction> fetchInfiltratorInteractionsFor(String var1);

    String getCollaboratorServerLocation();
}
