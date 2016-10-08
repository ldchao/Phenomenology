package bl.loginBL;

import Dao.UserDao;
import DaoImpl.UserDaoImpl;
import ENUM.UniversalState;
import POJO.User;
import blservice.loginBLService.LoginBLService;

/**
 * Created by lvdechao on 2016/10/8.
 */
public class LoginBL implements LoginBLService{
    public UniversalState login(String name, String password) {
        UserDao userDao=new UserDaoImpl();
        User user=userDao.findByUserName(name);
        if(user!=null){
            if(user.getPassword().equals(password)){
                return UniversalState.SUCCEED;
            }
        }
        return UniversalState.FAIL;
    }

    public UniversalState changePassword(String name,String oldPassword,String newPassword){
        UserDao userDao=new UserDaoImpl();
        User user=userDao.findByUserName(name);
        if(user!=null){
            if(user.getPassword().equals(oldPassword)){
                user.setPassword(newPassword);
                userDao.update(user);
                return UniversalState.SUCCEED;
            }
        }
        return UniversalState.FAIL;
    }
}
