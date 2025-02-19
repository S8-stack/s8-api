package com.s8.api.flow.space.requests;

import com.s8.api.flow.space.objects.SpaceS8Object;

/**
 *
 *	The Request Object to expose a space.
 * 
 * @author Pierre Convert
 * Copyright (C) 2025, Pierre Convert. All rights reserved.
 */
public abstract class ExposeSpaceS8Request {
	
	
	/**
	 * The space id
	 */
	public final String spaceId;
	
	
	/**
	 * The exposure of the space
	 */
	public final SpaceS8Object[] exposure;
	
	
	/**
	 * true if hardware persistency is required immediately after
	 */
	public final boolean saveImmediatelyAfter;
	
	
	
	
	/**
	 * Main Constructor
	 * 
	 * @param spaceId the space id
	 * @param exposure the exposure selected for the space
	 * @param saveImmediatelyAfter true if hardware persisentcy is required immeditaley after exposing
	 */
	public ExposeSpaceS8Request(String spaceId, SpaceS8Object[] exposure, boolean saveImmediatelyAfter) {
		super();
		this.spaceId = spaceId;
		this.exposure = exposure;
		this.saveImmediatelyAfter = saveImmediatelyAfter;
	}
	
	
	/**
	 * Request responses
	 */
	public enum Status {
		
		/** Everything went fine */
		OK,
		
		/** Space cannot be found */
		NOT_FOUND;
	}
	
	
	/**
	 * Callback method to be run on successful request processing.
	 * 
	 * @param status the status of the response
	 * @param version the response content
	 */
	public abstract void onResponse(Status status, long version);
	
	
	/**
	 * Callback method to be run on failed request processing.
	 * 
	 * @param message the exception
	 */
	public abstract void onFailed(Exception message);

}
