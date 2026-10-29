package com.dodaso.ecosystem.ai.dto;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Search limited to one app and the scopes the caller may see. scopeIds come from the app
 * service's own permission check, never from browser input; an empty list is rejected, never
 * read as "all".
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AiScopedSearchDTO implements Serializable {
    private String appCode;           // required: "ELCM"
    private List<Long> scopeIds;      // required, non-empty: ELCM workspace ids
    private List<String> sourceTypes; // optional filter
    private String query;             // required
    private Integer limit;            // optional, default 10, max 50
    private String userRef;           // for history
}
