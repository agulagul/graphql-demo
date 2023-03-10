package com.bca.rest.graphqldemo.service.maintenance;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bca.rest.graphqldemo.model.dao.maintenance.ParameterGroup;
import com.bca.rest.graphqldemo.model.dao.maintenance.User;
import com.bca.rest.graphqldemo.model.dto.maintenance.ParameterGroupRequestDto;
import com.bca.rest.graphqldemo.model.dto.maintenance.ParameterGroupResponseDto;
import com.bca.rest.graphqldemo.repository.maintenance.ParameterGroupRepository;
import com.bca.rest.graphqldemo.repository.maintenance.UserRepository;

@Service
public class ParameterGroupService {
  @Autowired
  private ParameterGroupRepository parameterGroupRepository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private ModelMapper modelMapper;

  public List<ParameterGroupResponseDto> getAllParameterGroups() {
    List<ParameterGroup> parameterGroups = parameterGroupRepository.findAll();
    return parameterGroups.stream().map(e -> modelMapper.map(e, ParameterGroupResponseDto.class)).collect(Collectors.toList());
  }
  
  public ParameterGroupResponseDto getParameterGroupById(UUID id) {
    ParameterGroup parameterGroup = parameterGroupRepository.findById(id).get();
    return modelMapper.map(parameterGroup, ParameterGroupResponseDto.class);
  }

  public List<ParameterGroupResponseDto> getAllParameterGroupsByCode(ParameterGroupRequestDto parameterGroupRequest) {
    List<ParameterGroup> parameterGroups = parameterGroupRepository.findAllByParamGroupCode(parameterGroupRequest.getParamGroupCode());
    return parameterGroups.stream().map(e -> modelMapper.map(e, ParameterGroupResponseDto.class)).collect(Collectors.toList());
  }

  public ParameterGroupResponseDto createParameterGroup(ParameterGroupRequestDto parameterGroupRequest){
    User user = userRepository.findById(UUID.fromString(parameterGroupRequest.getCreatedBy())).get();
    ParameterGroup newParameterGroup = modelMapper.map(parameterGroupRequest, ParameterGroup.class);
    newParameterGroup.setCreatedBy(user);
    ParameterGroup createdParameterGroup = parameterGroupRepository.save(newParameterGroup);
    return modelMapper.map(createdParameterGroup, ParameterGroupResponseDto.class);
  }
  
  public ParameterGroupResponseDto updateParameterGroup(ParameterGroupRequestDto parameterGroupRequest){
    User user = userRepository.findById(UUID.fromString(parameterGroupRequest.getUpdatedBy())).get();
    ParameterGroup parameterGroup = parameterGroupRepository.findById(UUID.fromString(parameterGroupRequest.getParamGroupId())).get();
    modelMapper.map(parameterGroupRequest, parameterGroup);
    parameterGroup.setUpdatedBy(user);
    parameterGroupRepository.save(parameterGroup);
    return modelMapper.map(parameterGroup, ParameterGroupResponseDto.class);
  }
  
  public ParameterGroupResponseDto deleteParameterGroup(ParameterGroupRequestDto parameterGroupRequest){
    ParameterGroup parameterGroup = parameterGroupRepository.findById(UUID.fromString(parameterGroupRequest.getParamGroupId())).get();
    parameterGroupRepository.delete(parameterGroup);
    return modelMapper.map(parameterGroup, ParameterGroupResponseDto.class);
  }
}
