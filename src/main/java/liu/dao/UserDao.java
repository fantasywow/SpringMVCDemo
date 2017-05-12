package liu.dao;

import liu.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

/**
 * Created by wtswindows7 on 2017/2/10.
 */
@Service
public interface UserDao {

    @Select("select name from customer where email= #{email}")
    String queryUserNameByEmail(@Param("email") String email);

    User queryUserInfoByEmail(@Param("email") String email);

    User queryUserInfoById(@Param("id") String id);
}