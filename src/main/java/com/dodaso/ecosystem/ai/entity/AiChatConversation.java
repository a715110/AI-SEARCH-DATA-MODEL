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
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

/** A saved AI Search chat; only its owner can list, open, rename or delete it. */
@Entity
@Table(name = "dodaso_chat_conversation")
@Getter
@Setter
public class AiChatConversation extends AuditableField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    // Tenant; null until ECWS has a company
    @Column(name = "company_id")
    private Long companyId;

    @Column(name = "app_code", nullable = false, length = 10)
    private String appCode = "ECWS";

    // ECWS project the chat searched
    @Column(name = "project_id")
    private Long projectId;

    // ELCM workspace, later
    @Column(name = "scope_id")
    private Long scopeId;

    @Column(name = "owner_login_id", nullable = false, length = 255)
    private String ownerLoginId;

    @Column(name = "title", nullable = false, length = 200)
    private String title;

    @Column(name = "message_count", nullable = false)
    private Integer messageCount = 0;

    // Order of the Recent chats list
    @Column(name = "last_message_at", nullable = false, columnDefinition = "timestamp")
    private Instant lastMessageAt;

    // char(1) in the table; without CHAR, schema validation expects varchar
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "active_ind", nullable = false, length = 1)
    private String activeInd = "Y";
}
