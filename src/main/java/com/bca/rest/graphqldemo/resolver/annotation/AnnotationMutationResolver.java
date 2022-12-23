package com.bca.rest.graphqldemo.resolver.annotation;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.bca.rest.graphqldemo.model.dto.maintenance.UserRequestDto;
import com.bca.rest.graphqldemo.model.dto.maintenance.UserResponseDto;
import com.bca.rest.graphqldemo.service.maintenance.UserService;

import graphql.annotations.annotationTypes.GraphQLDescription;
import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLName;
import graphql.annotations.annotationTypes.GraphQLNonNull;
import graphql.kickstart.annotations.GraphQLMutationResolver;

@Service
@GraphQLMutationResolver
public class AnnotationMutationResolver implements ApplicationContextAware {
  
  private static UserService userService;

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    userService = applicationContext.getBean(UserService.class);
  }

  @GraphQLField
  @GraphQLDescription("Create new user")
  @GraphQLName("create_user")
  public static UserResponseDto createUser(@GraphQLNonNull UserRequestDto userRequestDto) {
    return userService.createUser(userRequestDto);
  }
}
