package com.dodaso.ecosystem.ai.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * An alert or reminder from EARS that an answer can use, such as "Task #12 is past due".
 * Read from the EARS event_alert_reminder response, so fields EARS adds later are ignored.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AiAlertDTO implements Serializable {
    private Integer id;
    private String subject;
    private String body;
    private String priority;
    // What the alert is about: collaboration_task or workflow, and that row's id
    private String sourceReferenceTable;
    private Integer sourceReferenceId;
    // login_id of the user the alert was sent to
    private String recipientValue;
    // 1 when the recipient has read it
    private Byte readInd;
    private Instant createdAt;
}
