package com.bca.rest.graphqldemo.controller;

import com.bca.rest.graphqldemo.configuration.logging.BaseLogging;

public abstract class BaseController extends BaseLogging {

    public static final String API_VERSION = "v1";
    public static final String API_BASE_PATH = "/api/" + API_VERSION;

}
