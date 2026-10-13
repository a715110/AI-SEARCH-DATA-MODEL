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
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

/** One question and its answer in a saved AI Search chat. */
@Entity
@Table(name = "dodaso_chat_message")
@Getter
@Setter
public class AiChatMessage extends AuditableField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "conversation_id", nullable = false)
    private Long conversationId;

    // 1, 2, 3... within the conversation
    @Column(name = "seq", nullable = false)
    private Integer seq;

    @Column(name = "question", nullable = false, columnDefinition = "text")
    private String question;

    // Model text with [n] citations
    @Column(name = "answer", nullable = false, columnDefinition = "text")
    private String answer;

    // Text the sources were found with
    @Column(name = "search_text", columnDefinition = "text")
    private String searchText;

    // Results the [n] citations point to, without chunk text
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "sources", columnDefinition = "jsonb")
    private String sources;

    // Files attached to the question, names and sizes only
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "attached_files", columnDefinition = "jsonb")
    private String attachedFiles;

    @Column(name = "model", length = 100)
    private String model;

    @Column(name = "latency_ms")
    private Long latencyMs;
}
