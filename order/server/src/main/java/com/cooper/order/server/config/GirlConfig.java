package com.cooper.order.server.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author xueao
 * @create 2018-05-16 23:55
 * @desc ${DESCRIPTION}
 **/
@Data
@Component
@ConfigurationProperties("girl")
@RefreshScope
public class GirlConfig {
	private String name;

	private Integer age;
}
