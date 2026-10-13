package com.dodaso.ecosystem.ai.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** A saved question and its answer, as a reopened chat shows it. */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AiChatMessageDTO implements Serializable {
    private Long id;
    private Integer seq;
    private String question;
    private String answer;
    // Results the answer's [n] citations link to, without chunk text
    private List<AiSearchResultDTO> sources;
    // Names of the files attached to the question; their contents aren't saved
    private List<String> fileNames;
    // Files the answer made that can still be downloaded, without their bytes
    private List<AiGeneratedFileDTO> generatedFiles;
    private Instant createdAt;
}
