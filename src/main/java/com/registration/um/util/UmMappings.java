package com.registration.um.util;

public class UmMappings {

	public static final String USERS = "api/users";
	public static final String ROLES = "api/roles";

	public static final class Singular {
		public static final String USER = "api/user";
		public static final String ROLE = "api/role";
	}
	
	public static final String AUTHENTICATION = "authentication";
	
	private UmMappings() {
		throw new AssertionError();
		//AssertionError() means Constructs an AssertionError with no detail message.
	}
}
