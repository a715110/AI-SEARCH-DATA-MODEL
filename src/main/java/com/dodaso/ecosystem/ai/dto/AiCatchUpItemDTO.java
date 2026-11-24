package com.dodaso.ecosystem.ai.dto;

import java.io.Serializable;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ADDED 2026-11-23 (task catch-up). One comment or activity event of a task, as the app service
 * sends it. The ref (for example C12 for comment 12, E40 for event 40) is what the model cites.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AiCatchUpItemDTO implements Serializable {

  private String ref;
  /** "comment" or "event". */
  private String kind;
  private String author;
  private Instant at;
  private String text;
}
