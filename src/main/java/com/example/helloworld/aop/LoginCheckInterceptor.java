package com.example.helloworld.aop;

import com.alibaba.fastjson2.JSON;
import com.example.helloworld.dto.Result;
import com.example.helloworld.util.JwtUtils;
import com.example.helloworld.util.ResultUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String jwt = request.getHeader("Authorization");
        if (jwt == null || jwt.isEmpty()) {
            log.info("token is null");
            response.setStatus(401);
            Result<String> error =ResultUtil.error("empty token", 401);
            String errorJsonString = JSON.toJSONString(error);
            response.getWriter().write(errorJsonString);
            return false;
        }

        /*try {
            JwtUtils.parseJwt(jwt);
        } catch (Exception e){
            e.printStackTrace();
            log.info("failed to parse jwt token");
            response.setStatus(401);
            Result<String> error =ResultUtil.error("invalid token", 401);
            String errorJsonString = JSON.toJSONString(error);
            response.getWriter().write(errorJsonString);
            return false;
        }*/
        JwtUtils.parseJwt(jwt);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }


}
