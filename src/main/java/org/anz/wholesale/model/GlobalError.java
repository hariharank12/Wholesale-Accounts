package org.anz.wholesale.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by hariharank12 on 25/11/20.
 */
@AllArgsConstructor
@Getter
public class GlobalError {
    private String message;
    private String errorReason;
}
