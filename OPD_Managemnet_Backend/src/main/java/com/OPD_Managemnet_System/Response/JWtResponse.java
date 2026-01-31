package com.OPD_Managemnet_System.Response;

import com.OPD_Managemnet_System.OPDEntitys.Role;

public class JWtResponse {
	
	 	private String token;
	    private Role role;
	    private Object data;
		public String getToken() {
			return token;
		}
		public void setToken(String token) {
			this.token = token;
		}
		public Role getRole() {
			return role;
		}
		public void setRole(Role role) {
			this.role = role;
		}
		public Object getData() {
			return data;
		}
		public void setData(Object data) {
			this.data = data;
		}
		@Override
		public String toString() {
			return "JWtResponse [token=" + token + ", role=" + role + ", data=" + data + "]";
		}
		public JWtResponse(String token, Role role, Object data) {
			super();
			this.token = token;
			this.role = role;
			this.data = data;
		}
		public JWtResponse() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
	    

	   

}
