package com.person.rentalcar.mapper;

import com.person.rentalcar.model.Series;
import com.person.rentalcar.vo.query.PageRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SeriesMapper {

    boolean addSeries(Series series);

    boolean deleteSeriesBySeriesId(int seriesId);

    boolean updateSeries(Series series);

    Series selectSeriesBySeriesId(int seriesId);

    String getSeriesNameBySeriesId(int seriesId);

    List<Series> selectAllSeries(PageRequest request);

    List<Series>  SeriesForIdAndname();

    boolean changeStatus(@Param("status") boolean status,@Param("seriesId") int seriesId);
}
