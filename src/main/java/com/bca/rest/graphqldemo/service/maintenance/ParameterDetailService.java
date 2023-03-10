package com.bca.rest.graphqldemo.service.maintenance;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bca.rest.graphqldemo.model.dao.maintenance.ParameterDetail;
import com.bca.rest.graphqldemo.model.dao.maintenance.ParameterGroup;
import com.bca.rest.graphqldemo.model.dao.maintenance.User;
import com.bca.rest.graphqldemo.model.dto.maintenance.ParameterDetailRequestDto;
import com.bca.rest.graphqldemo.model.dto.maintenance.ParameterDetailResponseDto;
import com.bca.rest.graphqldemo.repository.maintenance.ParameterDetailRepository;
import com.bca.rest.graphqldemo.repository.maintenance.ParameterGroupRepository;
import com.bca.rest.graphqldemo.repository.maintenance.UserRepository;

@Service
public class ParameterDetailService {
  
  @Autowired
  ParameterDetailRepository parameterDetailRepository;

  @Autowired
  ParameterGroupRepository parameterGroupRepository;

  @Autowired
  UserRepository userRepository;

  @Autowired
  ModelMapper modelMapper;

  public List<ParameterDetailResponseDto> getAllParameterDetail() {
    List<ParameterDetail> parameterDetails = parameterDetailRepository.findAll();
    return parameterDetails.stream().map(e -> modelMapper.map(e, ParameterDetailResponseDto.class)).collect(Collectors.toList());
  }

  public ParameterDetailResponseDto getParameterDetailById(UUID id) {
    ParameterDetail parameterDetail = parameterDetailRepository.findById(id).get();
    return modelMapper.map(parameterDetail, ParameterDetailResponseDto.class);
  }

  public List<ParameterDetailResponseDto> getAllParameterDetailsByCode(ParameterDetailRequestDto parameterDetailRequest) {
    List<ParameterDetail> parameterDetails = parameterDetailRepository.findAllByParamDetailCode(parameterDetailRequest.getParamDetailCode());
    return parameterDetails.stream().map(e -> modelMapper.map(e, ParameterDetailResponseDto.class)).collect(Collectors.toList());
  }

  public ParameterDetailResponseDto createParameterDetail(ParameterDetailRequestDto parameterDetailRequest){
    User user = userRepository.findById(UUID.fromString(parameterDetailRequest.getCreatedBy())).get();
    ParameterGroup parameterGroup = parameterGroupRepository.findById(UUID.fromString(parameterDetailRequest.getParameterGroupId())).get();
    ParameterDetail newParameterDetail = modelMapper.map(parameterDetailRequest, ParameterDetail.class);
    newParameterDetail.setCreatedBy(user);
    newParameterDetail.setParamGroup(parameterGroup);
    ParameterDetail createdParameterDetail = parameterDetailRepository.save(newParameterDetail);
    return modelMapper.map(createdParameterDetail, ParameterDetailResponseDto.class);
  }
  
  public ParameterDetailResponseDto updateParameterDetail(ParameterDetailRequestDto parameterDetailRequest){
    User user = userRepository.findById(UUID.fromString(parameterDetailRequest.getUpdatedBy())).get();
    ParameterGroup parameterGroup = parameterGroupRepository.findById(UUID.fromString(parameterDetailRequest.getParameterGroupId())).get();
    ParameterDetail parameterDetail = parameterDetailRepository.findById(UUID.fromString(parameterDetailRequest.getParamDetailId())).get();
    modelMapper.map(parameterDetailRequest, parameterDetail);
    parameterDetail.setUpdatedBy(user);
    parameterDetail.setParamGroup(parameterGroup);
    parameterDetailRepository.save(parameterDetail);
    return modelMapper.map(parameterDetail, ParameterDetailResponseDto.class);
  }
  
  public ParameterDetailResponseDto deleteParameterDetail(ParameterDetailRequestDto parameterDetailRequestDto){
    ParameterDetail parameterDetail = parameterDetailRepository.findById(UUID.fromString(parameterDetailRequestDto.getParamDetailId())).get();
    parameterDetailRepository.delete(parameterDetail);
    return modelMapper.map(parameterDetail, ParameterDetailResponseDto.class);
  }
}
