package com.bca.rest.graphqldemo.model.dto.maintenance;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLName;
import lombok.Data;

@Data
@GraphQLName("parameter_detail")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ParameterDetailRequestDto {

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

  @JsonProperty("param_group_id")
  @GraphQLField
  @GraphQLName("param_group_id")
  private String parameterGroupId;

  @JsonProperty("created_by")
  @GraphQLField
  @GraphQLName("created_by")
  private String createdBy;

  @JsonProperty("updated_by")
  @GraphQLField
  @GraphQLName("updated_by")
  private String updatedBy;
}
