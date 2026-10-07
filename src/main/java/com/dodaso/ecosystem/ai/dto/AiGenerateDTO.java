package com.dodaso.ecosystem.ai.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AiGenerateDTO implements Serializable {
    private String generatePrompt;
    private String generatedText;
    private Long projectId;
    private Long workspaceId;
    // Results the answer was written from; [n] in generatedText is sources.get(n - 1)
    private List<AiSearchResultDTO> sources;
    // Earlier questions and answers, oldest first; empty for a first question
    private List<AiChatTurnDTO> history;
    // Text the sources are found with; null means generatePrompt. A follow-up sends the earlier
    // questions too, so "what about Safari?" still finds the login tasks.
    private String searchText;
    // Logged-in user's login_id; their EARS alerts and reminders are added to the answer's context
    private String loginId;
    // EARS alerts the answer could use: the user's own and those on the source tasks
    private List<AiAlertDTO> alerts;
    public AiGenerateDTO(String generatePrompt) {
        this.generatePrompt = generatePrompt;
    }
}
