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
}
