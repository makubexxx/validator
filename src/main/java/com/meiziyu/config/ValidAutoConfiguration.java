package com.meiziyu.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.meiziyu.validator.MzyValidator;

/**
 * @Author: Meiziyu
 * @Date: 2019/9/8 11:26
 * @Email 308348194@qq.com
 */
@Configuration//开启配置
@ConditionalOnProperty//存在对应配置信息时初始化该配置类
        (
                prefix = "mzyvalidtor",//存在配置前缀
                value = "enabled",//开启
                matchIfMissing = true//缺失检查
        )
public class ValidAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(MzyValidator.class)//缺失HelloService实体bean时，初始化HelloService并添加到SpringIoc
    public MzyValidator mzyValidator() {
        MzyValidator mzyValidator = new MzyValidator();
        return mzyValidator;
    }
}
