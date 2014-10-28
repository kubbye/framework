/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: JdbcAuthenticationRealm.java
 * Author:   weih
 * Date:     2014年10月28日 下午1:45:51
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wade.framework.admin.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author weih
 */
public class JdbcAuthenticationRealm extends AuthorizingRealm {

  
    
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String loginName = usernamePasswordToken.getUsername();
        char[] password=usernamePasswordToken.getPassword();
        /*Map<String, Object> param = new HashMap<String, Object>();
        param.put("login_id", loginName);
        Users user = dalClient.queryForObject("shiro.getUserByLoginId", param, Users.class);
        if (user == null)
            throw new AuthenticationException ( new BusinessException(MessageCodes.E11001, "loginName = " + loginName));
        if (!Md5Crypt.apr1Crypt(String.valueOf(password), loginName).equals(user.getPassword()))
            throw new AuthenticationException (new BusinessException(MessageCodes.E11002, "loginName = " + loginName));*/

        return new SimpleAuthenticationInfo(loginName,password,getName());
    }
    
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //null usernames are invalid
        if (principals == null) {
            throw new AuthorizationException("用户没有登陆");
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(null);
        return info;
    }

}
