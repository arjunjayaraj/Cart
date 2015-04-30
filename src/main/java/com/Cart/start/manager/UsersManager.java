package com.Cart.start.manager;

import java.util.List;

import com.Cart.start.dao.UsersDAO;
import com.Cart.start.model.Users;

public class UsersManager {

		private static UsersDAO UsersDAO;

		public UsersManager() {
			UsersDAO = new UsersDAO();
		}

		public void save(Users entity) {
			UsersDAO.openCurrentSessionwithTransaction();
			UsersDAO.save(entity);
			UsersDAO.closeCurrentSessionwithTransaction();
		}

		public void update(Users entity) {
			UsersDAO.openCurrentSessionwithTransaction();
			UsersDAO.update(entity);
			UsersDAO.closeCurrentSessionwithTransaction();
		}

		public Users findById(String id) {
			UsersDAO.openCurrentSession();
			Users Users = UsersDAO.findById(id);
			UsersDAO.closeCurrentSession();
			return Users;
		}

		public void delete(String id) {
			UsersDAO.openCurrentSessionwithTransaction();
			Users Users = UsersDAO.findById(id);
			UsersDAO.delete(Users);
			UsersDAO.closeCurrentSessionwithTransaction();
		}

		public List<Users> findAll() {
			UsersDAO.openCurrentSession();
			List<Users> Users = UsersDAO.findAll();
			UsersDAO.closeCurrentSession();
			return Users;
		}

		public void deleteAll() {
			UsersDAO.openCurrentSessionwithTransaction();
			UsersDAO.deleteAll();
			UsersDAO.closeCurrentSessionwithTransaction();
		}

		public UsersDAO UsersDAO() {
			return UsersDAO;
		}
}
