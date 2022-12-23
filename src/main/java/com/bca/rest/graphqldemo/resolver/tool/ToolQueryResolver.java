package com.bca.rest.graphqldemo.resolver.tool;

import java.util.List;
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

import graphql.kickstart.tools.GraphQLQueryResolver;

@Service
public class ToolQueryResolver implements GraphQLQueryResolver {

    @Autowired
    private UserService userService;

    @Autowired
    private ParameterGroupService parameterGroupService;

    @Autowired
    private ParameterDetailService parameterDetailService;

    public List<UserResponseDto> getAllUser() {
        return userService.getAllUsers();
    }

    public UserResponseDto getUserById(String id) {
        return userService.getUserById(UUID.fromString(id));
    }

    public List<UserResponseDto> getAllUserByUsername(UserRequestDto input) {
        return userService.getAllUsersByUserName(input);
    }

    public List<ParameterGroupResponseDto> getAllParameterGroup() {
        return parameterGroupService.getAllParameterGroups();
    }

    public ParameterGroupResponseDto getParameterGroupById(String id) {
        return parameterGroupService.getParameterGroupById(UUID.fromString(id));
    }

    public List<ParameterGroupResponseDto> getAllParameterGroupByCode(ParameterGroupRequestDto input) {
        return parameterGroupService.getAllParameterGroupsByCode(input);
    }

    public List<ParameterDetailResponseDto> getAllParameterDetail() {
        return parameterDetailService.getAllParameterDetail();
    }

    public ParameterDetailResponseDto getParameterDetailById(String id) {
        return parameterDetailService.getParameterDetailById(UUID.fromString(id));
    }

    public List<ParameterDetailResponseDto> getAllParameterDetailByCode(ParameterDetailRequestDto input) {
        return parameterDetailService.getAllParameterDetailsByCode(input);
    }
}
