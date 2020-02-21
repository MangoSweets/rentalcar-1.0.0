package com.person.rentalcar.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @describtion:
 * @author: yejun
 * @time: 2020/1/20
 */
public class LoginInterceptor implements HandlerInterceptor {
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//
//        // 放行 options 请求，否则无法让前端带上自定义的 header 信息，导致 sessionID 改变，shiro 验证失败
//        if (HttpMethod.OPTIONS.toString().equals(request.getMethod())) {
//            response.setStatus(HttpStatus.NO_CONTENT.value());
//            return true;
//        }
//
//        Subject subject = SecurityUtils.getSubject();
//        // 使用 shiro 验证
//        if (!subject.isAuthenticated() && !subject.isRemembered()) {
//            return false;
//        }
//        return true;
//    }
//
//    private boolean begingWith(String page, String[] requiredAuthPages) {
//        boolean result = false;
//        for (String requiredAuthPage : requiredAuthPages) {
//            if (StringUtils.startsWith(page, requiredAuthPage)) {
//                result = true;
//                break;
//            }
//        }
//        return result;
//    }
}
