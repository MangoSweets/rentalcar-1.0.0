package com.person.rentalcar.mapper.client;

import com.person.rentalcar.model.*;
import com.person.rentalcar.vo.query.ClientQueryCarVO;
import com.person.rentalcar.vo.query.PublishSharingOrderVO;
import com.person.rentalcar.vo.query.QuerySharingOrderVO;
import com.person.rentalcar.vo.resp.ClientCarVO;
import com.person.rentalcar.vo.resp.MyOrder;
import com.person.rentalcar.vo.resp.MySharingOrder;
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

    boolean modifyPassword(@Param("password") String password, @Param("id") String userId);

    List<ClientCarVO> selectCarInformationForClient(ClientQueryCarVO vo);

    Long getTotalSize();

    Integer getUserIdForUsername(String username);

    User getUserInfoForOrder(int userId);

    Series getSeriesInfoForCarId(int carId);

    boolean addOrder(Order order);

    List<MyOrder> selectMyOrderForUserId(int userId);

    User getUserForUsername(String username);

    boolean setRole(@Param("userId") int userId, @Param("roleId") int roleId);

    List<SharingOrder> selectSharingOrder(QuerySharingOrderVO vo);

    boolean becomeDriveSharing(int userId);

    List<DrivingBehalf> driveSharingExit(int userId);

    boolean publishSharingOrderVO(PublishSharingOrderVO vo);

    Integer getDrivingBehalfId(int userId);

    boolean orderSharingDriver(@Param("sharingoderId") int sharingoderId, @Param("userId") int userId, @Param("drivingBehalfId") int drivingBehalfId);

    List<MySharingOrder> selectMySharingOrder(int drivingBehalfId);

}
