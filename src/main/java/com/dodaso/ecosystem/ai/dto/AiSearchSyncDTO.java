package com.dodaso.ecosystem.ai.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AiSearchSyncDTO implements Serializable {
    private Long sourceId;
    private String sourceType;
    private String summary;
    private String status;
    private String description;
    private Long projectId;
    private Long workspaceId;
    private Instant sourceUpdatedAt;
    private Long userId;

    // CollaborationTask metadata fields
    private String priority;
    private String requestor;
    private Date dueDate;
    private Date scheduledDate;

    // Hierarchy: task_comment -> task.id, file_attachment -> task.id or comment.id
    private Long parentSourceId;
}
