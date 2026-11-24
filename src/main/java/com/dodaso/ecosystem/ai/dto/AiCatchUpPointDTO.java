package com.dodaso.ecosystem.ai.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** ADDED 2026-11-23 (task catch-up). One statement of the summary and the items it came from. */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AiCatchUpPointDTO implements Serializable {

  private String text;
  @Builder.Default
  private List<String> refs = new ArrayList<>();
}
