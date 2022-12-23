package com.bca.rest.graphqldemo.model.dto.maintenance;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLName;
import lombok.Data;

@Data
@GraphQLName("parameter_detail")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ParameterDetailResponseDto {

  @JsonProperty("param_detail_id")
  @GraphQLField
  @GraphQLName("param_detail_id")
  private String paramDetailId;
  
  @JsonProperty("param_detail_code")
  @GraphQLField
  @GraphQLName("param_detail_code")
  private String paramDetailCode;
  
  @JsonProperty("param_detail_name")
  @GraphQLField
  @GraphQLName("param_detail_name")
  private String paramDetailName;
  
  @JsonProperty("param_detail_desc")
  @GraphQLField
  @GraphQLName("param_detail_desc")
  private String paramDetailDesc;
  
  @JsonProperty("parent_id")
  @GraphQLField
  @GraphQLName("parent_id")
  private String parentId;

  @JsonProperty("param_group")
  @GraphQLField
  @GraphQLName("param_group")
  private ParameterGroupResponseDto paramGroup;
    
  @JsonProperty("created_date")
  @GraphQLField
  @GraphQLName("created_date")
  private Long createdDate;

  @JsonProperty("created_by")
  @GraphQLField
  @GraphQLName("created_by")
  private UserResponseDto createdBy;

  @JsonProperty("updated_date")
  @GraphQLField
  @GraphQLName("updated_date")
  private Long updatedDate;

  @JsonProperty("updated_by")
  @GraphQLField
  @GraphQLName("updated_by")
  private UserResponseDto updatedBy;

  @JsonProperty("version")
  @GraphQLField
  @GraphQLName("version")
  private Integer version;

  @JsonProperty("is_active")
  @GraphQLField
  @GraphQLName("is_active")
  private Boolean isActive;
}
