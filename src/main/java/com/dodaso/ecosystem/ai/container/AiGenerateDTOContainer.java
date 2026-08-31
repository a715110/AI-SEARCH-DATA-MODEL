package com.dodaso.ecosystem.ai.container;

import com.dodaso.ecosystem.ai.dto.AiSearchResultDTO;
import com.dodaso.ecosystem.ai.dto.AiGenerateDTO;
import com.dodaso.ecosystem.baseline.common.container.DataContainer;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
public class AiGenerateDTOContainer extends DataContainer<Object> implements Serializable {
    private AiGenerateDTO aiGenerateDTO;

}
