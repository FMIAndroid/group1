package com.unisofia.fmi.clientserver.server.request;

import java.lang.reflect.Type;

import org.apache.http.client.methods.HttpUriRequest;

public abstract class BaseRequest<T> {

	public abstract HttpUriRequest getRequestObject();

	public abstract Type getResponseType();
}
