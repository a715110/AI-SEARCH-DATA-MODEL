package com.dodaso.ecosystem.ai.entity;

import com.dodaso.ecosystem.ecws.entity.AuditableField;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.Instant;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

/** A file the AI Search chat made from an answer; only its owner can download it until it expires. */
@Entity
@Table(name = "dodaso_chat_file")
@Getter
@Setter
public class AiChatFile extends AuditableField {
    // Set in Java (UUID.randomUUID()), so ids can't be guessed
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    // Tenant; null until ECWS has a company
    @Column(name = "company_id")
    private Long companyId;

    @Column(name = "app_code", nullable = false, length = 10)
    private String appCode = "ECWS";

    @Column(name = "owner_login_id", nullable = false, length = 255)
    private String ownerLoginId;

    // Saved chat the file belongs to, once chats are saved
    @Column(name = "conversation_id")
    private Long conversationId;

    @Column(name = "message_id")
    private Long messageId;

    @Column(name = "file_name", nullable = false, length = 255)
    private String fileName;

    @Column(name = "content_type", nullable = false, length = 100)
    private String contentType;

    @Column(name = "size_bytes", nullable = false)
    private Long sizeBytes;

    @Column(name = "content", nullable = false, columnDefinition = "bytea")
    private byte[] content;

    // Document spec the file was built from
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "spec", columnDefinition = "jsonb")
    private String spec;

    @Column(name = "expires_at", nullable = false, columnDefinition = "timestamp")
    private Instant expiresAt;

    // char(1) in the table; without CHAR, schema validation expects varchar
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "active_ind", nullable = false, length = 1)
    private String activeInd = "Y";
}
