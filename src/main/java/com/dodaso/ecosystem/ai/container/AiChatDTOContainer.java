package com.dodaso.ecosystem.ai.container;

import com.dodaso.ecosystem.ai.dto.AiChatConversationDTO;
import com.dodaso.ecosystem.ai.dto.AiChatMessageDTO;
import com.dodaso.ecosystem.baseline.common.container.DataContainer;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * Saved AI Search chats. Requests send loginId and, for one chat, aiChatConversationDTO with its id
 * (and a new title for a rename); responses carry the list or the chat with its messages.
 */
@Data
public class AiChatDTOContainer extends DataContainer<Object> implements Serializable {
    private AiChatConversationDTO aiChatConversationDTO;
    private List<AiChatConversationDTO> aiChatConversationDTOList;
    private List<AiChatMessageDTO> aiChatMessageDTOList;
}
