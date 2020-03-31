package com.person.rentalcar.shiro;//package com.rentalcar.main.config.shiro;

/**
 * 自定义权限匹配和账号密码匹配
 */
//public class MyShiroRealm extends AuthorizingRealm {

//    @Autowired
//    private UserService userService;
//
//    /***
//     * @describtion: 简单重写获取权限的方法
//     * @author: yejun
//     * @time: 2020/1/18 16:47
//     * @params: * @Param principals:
//     * @return: * @return: org.apache.shiro.authz.AuthorizationInfo
//     */
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo();
//        User user= (User) principals.getPrimaryPrincipal();
//        String roles = user.getRoles();
//        return new SimpleAuthorizationInfo();
//    }
//
//    /***
//     * @describtion: 获取认证信息，即根据token中的用户名从数据库中获取密码和盐返回
//     * @author: yejun
//     * @time: 2020/1/18 16:56
//     * @params: * @Param token:
//     * @return: * @return: org.apache.shiro.authc.AuthenticationInfo
//     */
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//        String username = token.getPrincipal().toString();
//        User user = userService.selectUserByUsername(username);
//        String passwordFromDB = user.getPassword();
//        String salt = user.getSalt();
//        return new SimpleAuthenticationInfo(username, passwordFromDB, ByteSource.Util.bytes(salt), getName());
//    }
//}
