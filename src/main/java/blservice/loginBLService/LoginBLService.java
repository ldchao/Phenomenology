package blservice.loginBLService;

import ENUM.UniversalState;

/**
 * Created by lvdechao on 2016/10/8.
 */
public interface LoginBLService {

    //登录验证
    public UniversalState login(String name,String password);

    //修改密码
    public UniversalState changePassword(String name,String oldPassword,String newPassword);

}
