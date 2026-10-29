package com.dodaso.ecosystem.ai.entity;
import com.dodaso.ecosystem.ecws.entity.AuditableField;
import java.time.Instant;
import java.util.Date;
import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Table(name = "dodaso_embeddings")
public class EcwsEmbedding extends AuditableField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "source_type", nullable = false, length = 50)
    protected String sourceType;

    @Column(name = "source_id", nullable = false)
    protected Long sourceId;

    @Column(name = "chunk_index", nullable = false)
    protected Integer chunkIndex;

    @Column(name = "chunk_text", nullable = false, columnDefinition = "text")
    protected String chunkText;

    @Column(name = "chunk_tokens", nullable = false)
    protected Integer chunkTokens;

    @Column(name = "embedding", nullable = false, columnDefinition = "vector(768)")
    @org.hibernate.annotations.ColumnTransformer(
        write = "CAST(? AS vector)",
        read = "embedding::text"
    )
    protected String embedding;

    @Column(name = "summary", length = 500)
    protected String summary;

    @Column(name = "status", length = 50)
    protected String status;

    // ECWS project; null on ELCM rows
    @Column(name = "project_id")
    protected Long projectId;

    @Column(name = "created_by_user_id", nullable = false)
    protected Long createdByUserId;

    @Column(name = "updated_by_user_id")
    protected Long updatedByUserId;

    // ECWS content kind 1..4 (EmbeddingSourceTypeEnum), not an ELCM workspace; null on ELCM rows
    @Column(name = "workspace_id")
    protected Long workspaceId;

    @Column(name = "user_id")
    protected Long userId;

    @Column(name = "source_updated_at", nullable = false)
    protected Instant sourceUpdatedAt;

    // CollaborationTask metadata (null for other source types)
    @Column(name = "priority", length = 20)
    protected String priority;

    @Column(name = "requestor", length = 100)
    protected String requestor;

    @Temporal(TemporalType.DATE)
    @Column(name = "due_date")
    protected Date dueDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "scheduled_date")
    protected Date scheduledDate;

    // Hierarchy: null for COLLABORATION_TASK, task.id for TASK_COMMENT and TASK_FILE_ATTACHMENT,
    //            comment.id for COMMENT_FILE_ATTACHMENT
    @Column(name = "parent_source_id")
    protected Long parentSourceId;

    // Task the row belongs to, for every source type (plan PLAN-attachment-to-common-service §7.5).
    // parent_source_id can't hold it: comment files use it for the comment id. NULL on rows
    // written before this column existed.
    @Column(name = "task_id")
    protected Long taskId;

    // Unused, always null: each customer company has its own instance
    @Column(name = "company_id")
    protected Long companyId;

    // AppCodeEnum name
    @Column(name = "app_code", nullable = false, length = 10)
    protected String appCode = "ECWS";

    // Access boundary inside the instance: ELCM workspace.id; null on ECWS rows (they use project_id)
    @Column(name = "scope_id")
    protected Long scopeId;

    // Record a result opens on ELCM rows (contract_record, staged_document); null on ECWS rows (they use task_id)
    @Column(name = "owner_type", length = 50)
    protected String ownerType;

    @Column(name = "owner_id")
    protected Long ownerId;

    // Label shown in results (ELCM record code, file name)
    @Column(name = "title", length = 500)
    protected String title;

    // Model that produced the vector; vectors of different models can't be compared. Null on older rows
    @Column(name = "embedding_model", length = 100)
    protected String embeddingModel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public Integer getChunkIndex() {
        return chunkIndex;
    }

    public void setChunkIndex(Integer chunkIndex) {
        this.chunkIndex = chunkIndex;
    }

    public String getChunkText() {
        return chunkText;
    }

    public void setChunkText(String chunkText) {
        this.chunkText = chunkText;
    }

    public Integer getChunkTokens() {
        return chunkTokens;
    }

    public void setChunkTokens(Integer chunkTokens) {
        this.chunkTokens = chunkTokens;
    }

    public String getEmbedding() {
        return embedding;
    }

    public void setEmbedding(String embedding) {
        this.embedding = embedding;
    }

    public Instant getSourceUpdatedAt() {
        return sourceUpdatedAt;
    }

    public void setSourceUpdatedAt(Instant sourceUpdatedAt) {
        this.sourceUpdatedAt = sourceUpdatedAt;
    }

    @Transient
    @Override
    public boolean isHasNonAuditChanges() {
        return super.isHasNonAuditChanges();
    }

    @Override
    public void setHasNonAuditChanges(boolean hasNonAuditChanges) {
        super.setHasNonAuditChanges(hasNonAuditChanges);
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getWorkspaceId() {
        return workspaceId;
    }

    public void setWorkspaceId(Long workspaceId) {
        this.workspaceId = workspaceId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


    public Long getCreatedByUserId() {
        return createdByUserId;
    }

    public void setCreatedByUserId(Long createdByUserId) {
        this.createdByUserId = createdByUserId;
    }

    public Long getUpdatedByUserId() {
        return updatedByUserId;
    }

    public void setUpdatedByUserId(Long updatedByUserId) {
        this.updatedByUserId = updatedByUserId;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getRequestor() {
        return requestor;
    }

    public void setRequestor(String requestor) {
        this.requestor = requestor;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(Date scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public Long getParentSourceId() {
        return parentSourceId;
    }

    public void setParentSourceId(Long parentSourceId) {
        this.parentSourceId = parentSourceId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public Long getScopeId() {
        return scopeId;
    }

    public void setScopeId(Long scopeId) {
        this.scopeId = scopeId;
    }

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmbeddingModel() {
        return embeddingModel;
    }

    public void setEmbeddingModel(String embeddingModel) {
        this.embeddingModel = embeddingModel;
    }
}
