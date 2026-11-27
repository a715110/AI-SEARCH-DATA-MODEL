package com.dodaso.ecosystem.ai.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ADDED 2026-11-27 (catch-up actions). One thing the thread says someone still has to do: a short
 * title, the suggested owner (a login from the candidates, or null), a due date only when an item
 * states one (yyyy-MM-dd, or null) and the items it comes from.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AiCatchUpActionDTO implements Serializable {
  private String title;
  private String ownerLogin;
  private String dueDate;
  @Builder.Default
  private List<String> refs = new ArrayList<>();
}
