/*
 * Copyright (c) 2019, sflink.com. All rights reserved.
 */
package com.sf.multimodal.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.sf.multimodal.util.DateUtils;

import org.apache.commons.text.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Jacky on 2019/1/15 11:23
 */
@Configuration
public class HttpMessageConvertersConfig {

    private static final Logger logger = LoggerFactory.getLogger(HttpMessageConvertersConfig.class);

    @Bean
    public HttpMessageConverters httpMessageConverters() {
        // 1.需要定义一个convert转换消息的对象;
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        // 2:添加fastJson的配置信息;
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        // 返回Json日期格式处理
        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
        fastJsonConfig.setSerializeFilters(new ValueFilter() {
            // 处理XSS攻击
            @Override
            public Object process(Object object, String name, Object value) {
                if (value instanceof String) {
                    return StringEscapeUtils.escapeHtml4(value.toString());
                }
                return value;
            }
        });
        // 3处理中文乱码问题
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        // 4.在convert中添加配置信息.
        converter.setSupportedMediaTypes(fastMediaTypes);
        converter.setFastJsonConfig(fastJsonConfig);
        return new HttpMessageConverters(converter);
    }

    /**
     * <p>Description: 接收参数日期格式处理</p>
     *
     * @author 01381782 funing on 2019-01-14 19:08:58
     */
    @Bean
    public Converter<String, Date> addNewConvert() {
        return new Converter<String, Date>() {
            @Override
            public Date convert(String source) {
                if (StringUtils.isEmpty(source)) {
                    return null;
                }
                source = source.trim();
                if (StringUtils.isEmpty(source)) {
                    return null;
                }
                if (source.indexOf("T") > 0) {
                    source = source.replaceAll("T", " ");
                }
                if (source.indexOf("Z") > 0) {
                    source = source.substring(0, source.lastIndexOf("."));
                }

                if (source.matches("^\\d{4}-\\d{1,2}$")) {
                    return DateUtils.parse(source, DateUtils.DateFormatter.YYYY_MM);
                } else if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$")) {
                    return DateUtils.parse(source, DateUtils.DateFormatter.YYYY_MM_DD);
                } else if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}$")) {
                    return DateUtils.parse(source, DateUtils.DateFormatter.YYYY_MM_DD_HH_MM);
                } else if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")) {
                    return DateUtils.parse(source, DateUtils.DateFormatter.YYYY_MM_DD_HH_MM_SS);
                } else {
                    logger.error("日期转换错误{}", source);
                    return null;
                }
            }
        };
    }
}
