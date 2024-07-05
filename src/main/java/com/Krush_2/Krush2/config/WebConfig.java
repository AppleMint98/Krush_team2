package com.Krush_2.Krush2.config;


import com.Krush_2.Krush2.common.argument_resolver.HeaderHandlerArgumentResolver;
import com.Krush_2.Krush2.common.interceptor.HeaderInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {
    private final HeaderInterceptor headerInterceptor;
    private final HeaderHandlerArgumentResolver headerHandlerArgumentResolver;
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(headerInterceptor)
//                .order(1)
//                .addPathPatterns("/**")
//                .excludePathPatterns("/member/**");
//    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(headerHandlerArgumentResolver);
    }
}
