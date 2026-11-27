package com.dodaso.ecosystem.ai.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ADDED 2026-11-23 (task catch-up). Request: taskContext, since (may be null) and items. Response:
 * points, each with at least one valid ref, and the number of model statements dropped because they
 * cited nothing that was sent.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AiCatchUpDTO implements Serializable {

  /** Task summary, status, assignee and due date, as plain lines. Not cited. */
  private String taskContext;
  /** Start of the window; null means the whole thread. */
  private Instant since;
  @Builder.Default
  private List<AiCatchUpItemDTO> items = new ArrayList<>();
  @Builder.Default
  private List<AiCatchUpPointDTO> points = new ArrayList<>();
  private int droppedPoints;
  /** ADDED 2026-11-27: true when the caller also wants proposed action items. */
  private boolean wantActions;
  /** ADDED 2026-11-27: people an action may be given to; the model may name no one else. */
  @Builder.Default
  private List<AiCatchUpPersonDTO> candidateOwners = new ArrayList<>();
  /** ADDED 2026-11-27: titles of sub-tasks that exist already, so they are not proposed again. */
  @Builder.Default
  private List<String> existingSubTasks = new ArrayList<>();
  /** ADDED 2026-11-27: the proposed action items, each with at least one valid ref. */
  @Builder.Default
  private List<AiCatchUpActionDTO> actions = new ArrayList<>();
  private int droppedActions;
  /** ADDED 2026-11-27 (draft reply): the name of the person the draft is written for. */
  private String drafterName;
  /** ADDED 2026-11-27 (draft reply): what the person wants the reply to say; may be empty. */
  private String draftInstruction;
  /** ADDED 2026-11-27 (draft reply): the draft, plain text; null when the model gave none. */
  private String draft;
  /** ADDED 2026-11-27 (draft reply): refs of the items the draft answers; all were sent. */
  @Builder.Default
  private List<String> draftRefs = new ArrayList<>();
  /** ADDED 2026-11-27 (audit trail): the model that answered, as configured. */
  private String model;
  /** ADDED 2026-11-27 (audit trail): every prompt sent for this answer, one after the other. */
  private String promptSent;
}
