package com.person.rentalcar.convert;

import com.person.rentalcar.dto.CarDTO;
import com.person.rentalcar.model.Car;
import com.person.rentalcar.vo.resp.CarVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @describtion:
 * @author: yejun
 * @time: 2020/2/22
 */
public class CarConvert {
    private static ICarConvert mapper = Mappers.getMapper(ICarConvert.class);

    public static CarDTO convertToCarDTO(Car car){
        return mapper.convertToCarDTO(car);
    }

    public static List<CarDTO> convertToCarDTOList(List<Car> carList){
        return mapper.converttoCarDtoList(carList);
    }

    public static CarVO convertToCarVO(CarDTO carDTO){
        return mapper.convertToCarVO(carDTO);
    }

    public static List<CarVO> convertToCarVOList(List<CarDTO> carDTOList){
        return mapper.convertToCarVOList(carDTOList);
    }

    @Mapper
    public interface ICarConvert{

        CarDTO convertToCarDTO(Car car);

        List<CarDTO> converttoCarDtoList(List<Car> carList);

        CarVO convertToCarVO(CarDTO carDTO);

        List<CarVO> convertToCarVOList(List<CarDTO> carDTOList);
    }

}
