package com.dodaso.ecosystem.ai.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/** A file the user attached to a question; its text is added to the answer's prompt. */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AiChatFileDTO implements Serializable {
    private String fileName;
    // File bytes; sent as base64 in JSON
    @ToString.Exclude
    private byte[] content;
}
