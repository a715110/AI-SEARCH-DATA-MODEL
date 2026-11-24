package com.dodaso.ecosystem.ai.container;

import com.dodaso.ecosystem.ai.dto.AiCatchUpDTO;
import com.dodaso.ecosystem.baseline.common.container.DataContainer;
import java.io.Serializable;
import lombok.Data;

/** ADDED 2026-11-23 (task catch-up). */
@Data
public class AiCatchUpDTOContainer extends DataContainer<Object> implements Serializable {

  private AiCatchUpDTO aiCatchUpDTO;
}
