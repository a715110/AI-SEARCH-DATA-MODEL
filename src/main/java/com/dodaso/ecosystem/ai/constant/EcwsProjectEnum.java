package com.dodaso.ecosystem.ai.constant;

public enum EcwsProjectEnum {

    ECWS(1L);

    private final Long projectId;

    EcwsProjectEnum(Long projectId) {
        this.projectId = projectId;
    }

    public Long getProjectId() {
        return projectId;
    }
}
