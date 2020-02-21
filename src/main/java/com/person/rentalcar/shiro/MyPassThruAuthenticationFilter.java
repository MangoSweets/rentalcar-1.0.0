package com.person.rentalcar.shiro;

import org.apache.shiro.web.filter.authc.PassThruAuthenticationFilter;

/**
 * 描述:
 * 版本: v1.0.0
 * 日期：2020/1/15 10:34
 * 作者：yejun
 */
public class MyPassThruAuthenticationFilter extends PassThruAuthenticationFilter {
//    private Logger log = LoggerFactory.getLogger(this.getClass());
//
//    //获取请求方法，若为OPTIONS请求直接返回True放行
//    @Override
//    public boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
//
//        log.info("进入MyPassThruAuthenticationFilter");
//        HttpServletRequest req = (HttpServletRequest) request;
//        HttpServletResponse res = (HttpServletResponse) response;
//        if (req.getMethod().equals(RequestMethod.OPTIONS.name())) {
//            log.info("OPTIONS方法直接返回True");
//            return true;
//        }
//        return super.onPreHandle(request, response, mappedValue);
//    }
//
//
//    @Override
//    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
//        HttpServletResponse httpResp = WebUtils.toHttp(response);
//        HttpServletRequest httpReq = WebUtils.toHttp(request);
//
//        /** 系统重定向会默认把请求头清空，这里通过拦截器重新设置请求头，解决跨域问题 */
//        httpResp.addHeader("Access-Control-Allow-Origin", httpReq.getHeader("Origin"));
//        httpResp.addHeader("Access-Control-Allow-Headers", "*");
//        httpResp.addHeader("Access-Control-Allow-Methods", "*");
//        httpResp.addHeader("Access-Control-Allow-Credentials", "true");
//
//        if (isLoginRequest(request, response)) {
//            return true;
//        } else {
//            saveRequestAndRedirectToLogin(request, response);
//            return false;
//        }
//    }

}
