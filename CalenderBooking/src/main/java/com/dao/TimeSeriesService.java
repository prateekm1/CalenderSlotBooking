package com.dao;

import java.util.List;

import com.pojo.ScheduleTimeSeries;

public interface TimeSeriesService {

	public List<ScheduleTimeSeries> loadTimeSeriesDatById(Integer id);
}
