package com.oc.poc.simplehostname;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by pchaivong on 11/3/2017 AD.
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DelayedRequest {

    @JsonProperty
    private long delayed;

}
