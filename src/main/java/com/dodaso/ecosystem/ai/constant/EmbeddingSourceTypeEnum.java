package com.dodaso.ecosystem.ai.constant;

public enum EmbeddingSourceTypeEnum {

    COLLABORATION_TASK    (1L, "collaboration_task"),
    TASK_COMMENT          (2L, "task_comment"),
    TASK_FILE_ATTACHMENT  (3L, "task_file_attachment"),
    COMMENT_FILE_ATTACHMENT(4L, "comment_file_attachment");

    private final Long workspaceId;
    private final String sourceType;

    EmbeddingSourceTypeEnum(Long workspaceId, String sourceType) {
        this.workspaceId = workspaceId;
        this.sourceType = sourceType;
    }

    public Long getWorkspaceId() {
        return workspaceId;
    }

    public String getSourceType() {
        return sourceType;
    }

    public static EmbeddingSourceTypeEnum fromWorkspaceId(Long id) {
        for (EmbeddingSourceTypeEnum e : values()) {
            if (e.workspaceId.equals(id)) return e;
        }
        throw new IllegalArgumentException("Unknown workspaceId: " + id);
    }

    public static EmbeddingSourceTypeEnum fromSourceType(String type) {
        for (EmbeddingSourceTypeEnum e : values()) {
            if (e.sourceType.equals(type)) return e;
        }
        throw new IllegalArgumentException("Unknown sourceType: " + type);
    }
}
