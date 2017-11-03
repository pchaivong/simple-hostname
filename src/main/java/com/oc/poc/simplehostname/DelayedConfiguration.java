package com.oc.poc.simplehostname;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

/**
 * Created by pchaivong on 11/3/2017 AD.
 */

@Configuration
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DelayedConfiguration {

    private long delayed;

}
