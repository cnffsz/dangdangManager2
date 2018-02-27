package src.com.baizhi.manager.service;

import java.util.List;
import java.util.Map;

import src.com.baizhi.manager.entity.Category;

public interface CategoryService {
	/**
	 * ��ȡ�������
	 * @param page
	 * @param rows
	 * @return
	 */
	Map getCate(int page, int rows);
	/**
	 * ������ǰ��ȡ����1������ҵ��
	 * @return
	 */
	List<Category> getFirst();
	/**
	 * ���������ҵ��
	 * @param category
	 * @return
	 */
	boolean addCategory(Category category);
	/**
	 * �޸�ǰ��ȡ��ҵ��
	 * @param id
	 * @return
	 */
	Category getOne(int id);
	/**
	 * ���������޸ĵ�ҵ��
	 * @param category
	 * @return
	 */
	boolean updateCategory(Category category);
	/**
	 * ɾ�����
	 * @param ids
	 * @return
	 */
	boolean delete(int[] ids);
	/**
	 * ��ѯ����Ŀ¼��ҵ��
	 * @return
	 */
	List<Category> getSecond();

}
