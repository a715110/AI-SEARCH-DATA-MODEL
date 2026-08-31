package com.dodaso.ecosystem.ai.container;

import com.dodaso.ecosystem.ai.dto.AiSearchResultDTO;
import com.dodaso.ecosystem.ai.dto.AiSearchSyncDTO;

import com.dodaso.ecosystem.baseline.common.container.DataContainer;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
public class AiSearchSyncDTOContainer extends DataContainer<Object> implements Serializable {
    private AiSearchSyncDTO aiSearchSyncDTO;
    private List<AiSearchSyncDTO> aiSearchSyncDTOList;
    private String resultMessage;
    private List<AiSearchResultDTO> aiSearchResultDTOList;
}
