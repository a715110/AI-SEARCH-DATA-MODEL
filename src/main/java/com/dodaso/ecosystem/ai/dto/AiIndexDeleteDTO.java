package com.dodaso.ecosystem.ai.dto;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** Source records whose embeddings and sync rows are removed, within one app. */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AiIndexDeleteDTO implements Serializable {
    private String appCode;           // required: "ELCM"
    private String sourceType;        // required: ElcmSourceTypeEnum value
    private List<Long> sourceIds;     // required, non-empty
}
