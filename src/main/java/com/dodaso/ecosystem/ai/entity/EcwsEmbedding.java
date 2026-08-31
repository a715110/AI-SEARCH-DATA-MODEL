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
@Table(name = "ecws_embeddings")
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

    @Column(name = "project_id", nullable = false)
    protected Long projectId;

    @Column(name = "created_by_user_id", nullable = false)
    protected Long createdByUserId;

    @Column(name = "updated_by_user_id")
    protected Long updatedByUserId;

    @Column(name = "workspace_id", nullable = false)
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
}
