package com.cherry.patterns.structural;

interface IDbExecuter {
	void executeQuery(String query) throws Exception;
}

class DbExecuter implements IDbExecuter {

	@Override
	public void executeQuery(String query) throws Exception {
		System.out.println(query + " executed successfully");
	}

}

class DbProxyExecuter implements IDbExecuter {
	boolean isAdmin = false;
	DbExecuter dbExecuter;

	DbProxyExecuter(String name, String password) {
		if (name.equals("admin") && password.equals("admin")) {
			isAdmin = true;
		}
		dbExecuter = new DbExecuter();
	}

	@Override
	public void executeQuery(String query) throws Exception {
		if (isAdmin) {
			dbExecuter.executeQuery(query);
			return;
		}
		if (query.toLowerCase().contains("delete")) {
			throw new Exception("You are not allowed to perform delete operation");
		}
		dbExecuter.executeQuery(query);
	}
}

public class Proxy {
	public static void main(String[] args) throws Exception {
		DbProxyExecuter admin = new DbProxyExecuter("admin", "admin");
		DbProxyExecuter user = new DbProxyExecuter("Charan", "charan");
		admin.executeQuery("delete");
		admin.executeQuery("update");
		user.executeQuery("update");
		user.executeQuery("delete");
	}
}
