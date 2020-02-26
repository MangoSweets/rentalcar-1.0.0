package com.person.rentalcar.mapper;

import com.person.rentalcar.model.Series;

import java.util.List;

public interface SeriesMapper {

    boolean addSeries(Series series);

    boolean deleteSeriesBySeriesId(int seriesId);

    boolean updateSeries(Series series);

    Series selectSeriesBySeriesId(int seriesId);

    String getSeriesNameBySeriesId(int seriesId);

    List<Series> selectAllSeries();

    List<Series>  SeriesForIdAndname();
}
