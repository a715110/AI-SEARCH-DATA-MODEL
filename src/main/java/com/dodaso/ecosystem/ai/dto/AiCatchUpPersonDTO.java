package com.dodaso.ecosystem.ai.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** ADDED 2026-11-27 (catch-up actions). A person who may be named as owner of an action item. */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AiCatchUpPersonDTO implements Serializable {
  private String login;
  private String name;
}
