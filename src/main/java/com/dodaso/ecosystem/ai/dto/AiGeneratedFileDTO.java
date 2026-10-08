package com.dodaso.ecosystem.ai.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/** A file (Word, Excel) the AI Search chat made from an answer, for the user to download. */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AiGeneratedFileDTO implements Serializable {
    private UUID id;
    // With extension, such as "Meeting summary.docx"
    private String fileName;
    private String contentType;
    private Long sizeBytes;
    // After this the file can't be downloaded any more
    private Instant expiresAt;
    // File bytes, only in a download response; sent as base64 in JSON
    @ToString.Exclude
    private byte[] content;
}
