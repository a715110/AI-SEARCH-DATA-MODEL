package com.dodaso.ecosystem.ai.entity;

import com.dodaso.ecosystem.ecws.entity.AuditableField;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "dodaso_search_history")
@Getter
@Setter
public class EcwsSearchHistory extends AuditableField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "query_text", nullable = false, columnDefinition = "text")
    private String queryText;

    @Column(name = "result_ids", columnDefinition = "text")
    private String resultIds;    // e.g., JSON list of source IDs

    @Column(name = "result_count")
    private Integer resultCount;

    @Column(name = "search_latency_ms")
    private Long searchLatencyMs;

    @Column(name = "llm_latency_ms")
    private Long llmLatencyMs;

    @Column(name = "tokens_used")
    private Long tokensUsed;

    @Column(name = "feedback_helpful")
    private Boolean feedbackHelpful;

    @Column(name = "feedback_comment", columnDefinition = "text")
    private String feedbackComment;

    @Column(name = "project_id")
    private Long projectId;

    @Column(name = "workspace_id")
    private Long workspaceId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "top_k")
    private Integer topK;

    @Column(name = "created_by_user_id", nullable = false)
    private Long createdByUserId;

    @Column(name = "updated_by_user_id")
    private Long updatedByUserId;

    // Unused, always null: each customer company has its own instance
    @Column(name = "company_id")
    private Long companyId;

    // AppCodeEnum name
    @Column(name = "app_code", nullable = false, length = 10)
    private String appCode = "ECWS";

    // Scopes searched (ELCM workspace ids), e.g. "[3, 7]"
    @Column(name = "scope_ids", length = 1000)
    private String scopeIds;

    // ELCM users are login strings, not Long ids
    @Column(name = "user_ref", length = 255)
    private String userRef;


}
