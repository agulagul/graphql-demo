package com.bca.rest.graphqldemo.repository.maintenance;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bca.rest.graphqldemo.model.dao.maintenance.ParameterDetail;

public interface ParameterDetailRepository extends JpaRepository<ParameterDetail, UUID> {
  List<ParameterDetail> findAll();
  List<ParameterDetail> findAllByParamDetailCode(String paramDetailCode);
}
