package src.com.baizhi.manager.service;

import java.util.Map;

import src.com.baizhi.manager.entity.User;

public interface UserService {
	/**
	 * ��֤�û�����ҵ��
	 * @param userCount
	 * @return
	 */
	boolean checkCount(String userCount);
	/**
	 * ��¼��ҵ��
	 * @param u
	 * @return
	 */
	Map login(User u);

}
