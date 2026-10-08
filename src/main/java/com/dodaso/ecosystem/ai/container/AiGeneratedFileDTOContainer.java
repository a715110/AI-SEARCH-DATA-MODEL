package com.dodaso.ecosystem.ai.container;

import com.dodaso.ecosystem.ai.dto.AiGeneratedFileDTO;
import com.dodaso.ecosystem.baseline.common.container.DataContainer;
import java.io.Serializable;
import lombok.Data;

/** Download of a generated file: the request sends its id and loginId, the response its bytes. */
@Data
public class AiGeneratedFileDTOContainer extends DataContainer<Object> implements Serializable {
    private AiGeneratedFileDTO aiGeneratedFileDTO;
}
