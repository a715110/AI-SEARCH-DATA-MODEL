package com.dodaso.ecosystem.ai.entity;

import com.dodaso.ecosystem.ecws.entity.AuditableField;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.Instant;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ecws_embedding_sync")
@Getter
@Setter
public class EcwsEmbeddingSync extends AuditableField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "source_type", nullable = false, length = 50)
    private String sourceType;

    @Column(name = "source_id", nullable = false)
    private Long sourceId;

    @Column(name = "status", nullable = false, length = 20)
    private String status; // PENDING, COMPLETED, FAILED

    @Column(name = "error_message", columnDefinition = "text")
    private String errorMessage;

    @Column(name = "retry_count", nullable = false)
    private Integer retryCount = 0;

    @Column(name = "max_retries", nullable = false)
    private Integer maxRetries = 3;

    @Column(name = "processed_at")
    private Instant processedAt;

    @Column(name = "next_retry_at")
    private Instant nextRetryAt;

    @Column(name = "project_id")
    private Long projectId;

    @Column(name = "workspace_id")
    private Long workspaceId;

    @Column(name = "user_id")
    private Long userId;
}
