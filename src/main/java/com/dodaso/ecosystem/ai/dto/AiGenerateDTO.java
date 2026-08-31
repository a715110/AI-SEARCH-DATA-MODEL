package com.dodaso.ecosystem.ai.dto;

import java.io.Serializable;
import java.time.Instant;
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
    public AiGenerateDTO(String generatePrompt) {
        this.generatePrompt = generatePrompt;
    }
}
