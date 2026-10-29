package com.dodaso.ecosystem.ai.dto;

import java.io.Serializable;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * One source record to (re)index in dodaso_embeddings, sent by an app service other than ECWS
 * (ELCM today). ECWS keeps AiSearchSyncDTO. Either text or fileBytes + fileName is sent.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AiIndexDTO implements Serializable {
    private String appCode;           // required: AppCodeEnum name, "ELCM"
    private Long scopeId;             // required: ELCM workspace.id
    private String sourceType;        // required: ElcmSourceTypeEnum value
    private Long sourceId;            // required
    private String ownerType;         // required: record a result opens
    private Long ownerId;             // required
    private Long parentSourceId;
    private String title;             // shown in results
    private String text;              // plain text to embed (records, notes); null when a file is sent
    private byte[] fileBytes;         // file content (staged documents); null for text sources
    private String fileName;          // needed with fileBytes so the extractor can detect the type
    private Instant sourceUpdatedAt;  // required; older than the stored one is ignored
    private String userRef;           // who triggered it
}
