package com.person.rentalcar.mapper.client;

import com.person.rentalcar.model.Order;
import com.person.rentalcar.model.Series;
import com.person.rentalcar.model.User;
import com.person.rentalcar.vo.query.ClientQueryCarVO;
import com.person.rentalcar.vo.resp.ClientCarVO;
import com.person.rentalcar.vo.resp.MyOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @describtion:
 * @author: yejun
 * @time: 2020/4/12
 */
public interface ClientUserMapper {

    User getPwdByUsername(String username);

    boolean addUser(User user);

    boolean updateUser(User user);

    boolean modifyPassword(@Param("password") String password,@Param("id") String userId);

    List<ClientCarVO> selectCarInformationForClient(ClientQueryCarVO vo);

    Long getTotalSize();

    int getUserIdForUsername(String username);

    User getUserInfoForOrder(int userId);

    Series getSeriesInfoForCarId(int carId);

    boolean addOrder(Order order);

    List<MyOrder> selectMyOrderForUserId(int userId);
}
