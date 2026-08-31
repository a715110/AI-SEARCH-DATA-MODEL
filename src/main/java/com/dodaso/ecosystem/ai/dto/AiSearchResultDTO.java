package com.dodaso.ecosystem.ai.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AiSearchResultDTO implements Serializable {
    private Long sourceId;
    private String sourceType;
    private String summary;
    private String status;
    private String description;
    private Double score;
    private String chunkText;
    private Long parentSourceId;
    private Long taskId;

    public String getLabel() {
        if (sourceType == null) return "#" + sourceId;
        switch (sourceType) {
            case "collaboration_task":      return "Task #" + sourceId;
            case "task_comment":            return "Comment #" + sourceId;
            case "task_file_attachment":    return "Attachment #" + sourceId;
            case "comment_file_attachment": return "File #" + sourceId;
            default:                        return sourceType + " #" + sourceId;
        }
    }
}
