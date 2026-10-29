package com.dodaso.ecosystem.ai.container;

import com.dodaso.ecosystem.ai.dto.AiIndexDTO;
import com.dodaso.ecosystem.ai.dto.AiIndexDeleteDTO;
import com.dodaso.ecosystem.ai.dto.AiScopedSearchDTO;
import com.dodaso.ecosystem.ai.dto.AiSearchResultDTO;
import com.dodaso.ecosystem.baseline.common.container.DataContainer;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
public class AiIndexDTOContainer extends DataContainer<Object> implements Serializable {
    private AiIndexDTO aiIndexDTO;
    private AiIndexDeleteDTO aiIndexDeleteDTO;
    private AiScopedSearchDTO aiScopedSearchDTO;
    private List<AiSearchResultDTO> aiSearchResultDTOList;
    private String resultMessage;
}
