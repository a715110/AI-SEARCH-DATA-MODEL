package com.dodaso.ecosystem.ai.constant;

/**
 * ELCM source types in dodaso_embeddings. Kept apart from EmbeddingSourceTypeEnum, which is tied to
 * ECWS's workspaceId content kinds. Every value starts with "elcm_" so it never shares a name with an
 * ECWS source type: the unique keys (source_type, source_id[, chunk_index]) have no app_code.
 */
public enum ElcmSourceTypeEnum {

    STAGED_DOCUMENT ("elcm_staged_document"),
    CONTRACT_RECORD ("elcm_contract_record"),
    REVIEW_NOTATION ("elcm_review_notation");

    private final String sourceType;

    ElcmSourceTypeEnum(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getSourceType() {
        return sourceType;
    }

    public static ElcmSourceTypeEnum fromSourceType(String type) {
        for (ElcmSourceTypeEnum e : values()) {
            if (e.sourceType.equals(type)) return e;
        }
        throw new IllegalArgumentException("Unknown sourceType: " + type);
    }
}
