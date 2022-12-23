package com.bca.rest.graphqldemo.repository.maintenance;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bca.rest.graphqldemo.model.dao.maintenance.ParameterGroup;

public interface ParameterGroupRepository extends JpaRepository<ParameterGroup, UUID> {
  List<ParameterGroup> findAll();
  List<ParameterGroup> findAllByParamGroupCode(String paramGroupCode);
}
