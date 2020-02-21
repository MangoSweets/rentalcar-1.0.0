package com.person.rentalcar.shiro;//package com.rentalcar.main.config.shiro;
//
//import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
//import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
//import org.apache.shiro.web.util.WebUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.util.StringUtils;
//
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import java.io.Serializable;
//
//
//public class SessionConfig extends DefaultWebSessionManager {
//
//    private Logger logger = LoggerFactory.getLogger(this.getClass());
//    private static final String AUTHORIZATION = "Authorization";
//    private static final String REFERENCED_SESSION_ID_SOURCE = "Stateless request";
//
//    public SessionConfig() {
//        super();
//    }
//
//    @Override
//    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
//
//        HttpServletRequest httpServletRequest = WebUtils.toHttp(request);
//        String id = WebUtils.toHttp(request).getHeader("token");
//        if (!StringUtils.isEmpty(id)) {
//            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, "Stateless request");
//            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, id);
//            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
//            logger.info("调用SessionConfig获取sessionId="+id);
//            return id;
//        } else {
//            //否则按默认规则从cookie取sessionId
//            logger.info("调用SessionConfig使用默认模式从cookie获取sessionID为"+id);
//            return super.getSessionId(request, response);
//        }
//    }
//}
