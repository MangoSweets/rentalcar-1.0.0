package com.person.rentalcar.shiro;//package com.rentalcar.main.config.shiro;

import org.springframework.context.annotation.Configuration;


@Configuration
public class ShiroConfig {

//    @Bean
//    public static LifecycleBeanPostProcessor getLifecycleBeanProcessor(){
//        return new LifecycleBeanPostProcessor();
//    }
//
//    @Bean
//    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
//        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
//        shiroFilterFactoryBean.setSecurityManager(securityManager);
//        return shiroFilterFactoryBean;
//    }
//
//    @Bean
//    public SecurityManager securityManager() {
//        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        securityManager.setRealm(getMyRealm());
//        return securityManager;
//    }
//
//    @Bean
//    public MyShiroRealm getMyRealm(){
//        MyShiroRealm myShiroRealm=new MyShiroRealm();
//        myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
//        return myShiroRealm;
//    }
//    @Bean
//    public HashedCredentialsMatcher hashedCredentialsMatcher() {
//        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
//        hashedCredentialsMatcher.setHashAlgorithmName("md5");
//        hashedCredentialsMatcher.setHashIterations(2);
//        return hashedCredentialsMatcher;
//    }
//
//
//    @Bean
//    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
//        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
//        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
//        return authorizationAttributeSourceAdvisor;
//    }
//
//
//    /***
//     * @describtion: Remember me
//     * @author: yejun
//     * @time: 2020/1/20 20:11
//     * @params:
//     * @return: * @return: org.apache.shiro.web.mgt.CookieRememberMeManager
//    */
//    public CookieRememberMeManager rememberMeManager() {
//        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
//        cookieRememberMeManager.setCookie(rememberMeCookie());
//        cookieRememberMeManager.setCipherKey("EVANNIGHTLY_WAOU".getBytes());
//        return cookieRememberMeManager;
//    }
//
//    @Bean
//    public SimpleCookie rememberMeCookie() {
//        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
//        simpleCookie.setMaxAge(259200);
//        return simpleCookie;
//    }

}
