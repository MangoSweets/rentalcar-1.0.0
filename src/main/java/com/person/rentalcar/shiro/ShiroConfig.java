package com.person.rentalcar.shiro;

import com.person.rentalcar.login.SystemLogoutFilter;
import com.person.rentalcar.redis.api.ISyncCacheService;
import com.person.rentalcar.shiro.cache.ShiroCacheManager;
import com.person.rentalcar.shiro.security.JwtFilter;
import com.person.rentalcar.shiro.security.JwtProperties;
import com.person.rentalcar.shiro.security.UserContextFilter;
import com.person.rentalcar.utils.JedisUtils;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class ShiroConfig {

//    @Autowired
//    ShiroFilterProperties shiroFilterProperties;

    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public static DefaultAdvisorAutoProxyCreator getLifecycleBeanPostProcessor() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        // 强制使用cglib
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }

    @Bean
    public DefaultWebSecurityManager  securityManager(ShiroRealm shiroRealm, ShiroCacheManager shiroCacheManager){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();

        securityManager.setRealm(shiroRealm);

        //关闭shiro自带的session
        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
        DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
        defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
        subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
        securityManager.setSubjectDAO(subjectDAO);

        securityManager.setCacheManager(shiroCacheManager);
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilter(DefaultWebSecurityManager securityManager, JedisUtils jedisUtils, JwtProperties jwtProp, ISyncCacheService syncCacheService) {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);

        // 添加jwt过滤器
        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put("jwt",new JwtFilter(jwtProp,syncCacheService,jedisUtils));
        filterMap.put("logout",new SystemLogoutFilter(jedisUtils));
        shiroFilter.setFilters(filterMap);

        //动态配置拦截器注入
        Map<String, String> filterRuleMap = new HashMap<>(16);
        List<Map<String, String>> perms = this.getShiroFilterProperties().getPerms();
        perms.forEach(perm -> filterRuleMap.put(perm.get("key"), perm.get("value")));

        shiroFilter.setFilterChainDefinitionMap(filterRuleMap);
        shiroFilter.setUnauthorizedUrl("/unauth");
        return shiroFilter;
    }

//    @Bean("jwtFilter")
//    public JwtFilter jwtFilterBean(JedisUtils jedisUtils, JwtProperties jwtProp, ISyncCacheService syncCacheService) {
//        return new JwtFilter(jwtProp,syncCacheService,jedisUtils);
//    }

//    @Bean("SystemLogoutFilter")
//    public SystemLogoutFilter SystemLogoutFilterBean(JedisUtils jedisUtils) {
//        return new SystemLogoutFilter(jedisUtils);
//    }

    @Bean
    public ShiroFilterProperties getShiroFilterProperties(){
        return new ShiroFilterProperties();
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new UserContextFilter());
        return bean;
    }

}
