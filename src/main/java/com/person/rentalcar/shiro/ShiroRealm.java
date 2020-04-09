package com.person.rentalcar.shiro;//package com.rentalcar.main.config.shiro;

import com.person.rentalcar.constant.SecurityConsts;
import com.person.rentalcar.model.Permission;
import com.person.rentalcar.model.Role;
import com.person.rentalcar.model.User;
import com.person.rentalcar.service.RoleService;
import com.person.rentalcar.service.UserService;
import com.person.rentalcar.shiro.security.JwtToken;
import com.person.rentalcar.shiro.security.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 自定义权限匹配和账号密码匹配
 */
@Slf4j
@Service
public class ShiroRealm extends AuthorizingRealm {


    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

//    @Autowired
//    private PermissionService authorityService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     *
     * @param auth
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth)
            throws AuthenticationException {
        String token = (String) auth.getPrincipal();
        String account = JwtUtil.getClaim(token, SecurityConsts.ACCOUNT);

        if (account == null) {
            throw new AuthenticationException("token invalid");
        }

        if (JwtUtil.verify(token)) {
            return new SimpleAuthenticationInfo(token, token, "shiroRealm");
        }
        throw new AuthenticationException("Token expired or incorrect.");
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//		logger.info("调用doGetAuthorizationInfo方法获取权限");

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        String account = JwtUtil.getClaim(principals.toString(), SecurityConsts.ACCOUNT);
        User UserInfo = userService.findByUsername(account);

        //获取role
        Role role = userService.selectRoleByUserId(UserInfo.getUserId());
        //获取权限
        List<Permission> permissions = roleService.selectPermissionByRole(role.getRoleId());
//        for(Role Role : RoleList){
        authorizationInfo.addRole(role.getRoleIdentity());
        for (Permission auth : permissions) {

            authorizationInfo.addStringPermission(auth.getPermissionCode());
        }
//        }
        return authorizationInfo;
    }

}
