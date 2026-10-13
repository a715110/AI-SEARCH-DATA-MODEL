package com.dodaso.ecosystem.ai.dto;

import java.io.Serializable;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** A saved AI Search chat in the Recent chats list. */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AiChatConversationDTO implements Serializable {
    private Long id;
    private String appCode;
    private String title;
    private Integer messageCount;
    private Instant lastMessageAt;
}
