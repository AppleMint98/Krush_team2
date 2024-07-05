package com.Krush_2.Krush2.common.interceptor;

import com.Krush_2.Krush2.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserIdInterceptor implements HandlerInterceptor {

    private final MemberService memberService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userId = resolveUserId(request);
        validateUserId(userId);
        request.setAttribute("userId", userId);
        return true;
    }

    private String resolveUserId(HttpServletRequest request) {
        String userId = request.getHeader("userId");
        return userId;
    }

    private void validateUserId(String userId) {
        if (userId == null) {
            // throw exception
        }
        if(!memberService.existLoginId(userId)){
            // throw exception
        }
    }
}
