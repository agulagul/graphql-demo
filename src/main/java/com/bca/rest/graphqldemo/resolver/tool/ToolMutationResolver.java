package com.bca.rest.graphqldemo.resolver.tool;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bca.rest.graphqldemo.model.dto.maintenance.ParameterDetailRequestDto;
import com.bca.rest.graphqldemo.model.dto.maintenance.ParameterDetailResponseDto;
import com.bca.rest.graphqldemo.model.dto.maintenance.ParameterGroupRequestDto;
import com.bca.rest.graphqldemo.model.dto.maintenance.ParameterGroupResponseDto;
import com.bca.rest.graphqldemo.model.dto.maintenance.UserRequestDto;
import com.bca.rest.graphqldemo.model.dto.maintenance.UserResponseDto;
import com.bca.rest.graphqldemo.service.maintenance.ParameterDetailService;
import com.bca.rest.graphqldemo.service.maintenance.ParameterGroupService;
import com.bca.rest.graphqldemo.service.maintenance.UserService;

import graphql.kickstart.tools.GraphQLMutationResolver;

@Service
public class ToolMutationResolver implements GraphQLMutationResolver {
  
  @Autowired
  private UserService userService;

  @Autowired
  private ParameterGroupService parameterGroupService;

  @Autowired
  private ParameterDetailService parameterDetailService;

  public UserResponseDto createUser(UserRequestDto input) {
    return userService.createUser(input);
  }

  public UserResponseDto updateUser(UserRequestDto input) {
    return userService.updateUser(input);
  }

  public UserResponseDto deleteUser(UserRequestDto input) {
    return userService.deleteUser(UUID.fromString(input.getUserId()));
  }

  public ParameterGroupResponseDto createParameterGroup(ParameterGroupRequestDto input) {
    return parameterGroupService.createParameterGroup(input);
  }

  public ParameterGroupResponseDto updateParameterGroup(ParameterGroupRequestDto input) {
    return parameterGroupService.updateParameterGroup(input);
  }

  public ParameterGroupResponseDto deleteParameterGroup(ParameterGroupRequestDto input) {
    return parameterGroupService.deleteParameterGroup(input);
  }

  public ParameterDetailResponseDto createParameterDetail(ParameterDetailRequestDto input) {
    return parameterDetailService.createParameterDetail(input);
  }

  public ParameterDetailResponseDto updateParameterDetail(ParameterDetailRequestDto input) {
    return parameterDetailService.updateParameterDetail(input);
  }

  public ParameterDetailResponseDto deleteParameterDetail(ParameterDetailRequestDto input) {
    return parameterDetailService.deleteParameterDetail(input);
  }
}
