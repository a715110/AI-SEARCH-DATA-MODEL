package com.dodaso.ecosystem.ai.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** One earlier question and its answer, sent with a follow-up question. */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AiChatTurnDTO implements Serializable {
    private String question;
    private String answer;
}
