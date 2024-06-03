package Dao;

import java.util.List;

import model.NhanKhau;

public interface DaoInterface<T> {
	public List<T> selectAll();

	public T selectById(T t);

	public boolean insert(T t);

	public boolean delete(T t);

	public boolean update(T t);
}
