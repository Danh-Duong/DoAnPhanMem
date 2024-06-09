package Dao;

import java.util.List;

import model.NhanKhau;

public interface DaoInterface<Entity, DataType> {
	public void insert(Entity entity);

	public int update(Entity entity);

	public int delete(DataType id);

	public Entity selectById(DataType id);

	public java.util.List<Entity> selectAll();

	public java.util.List<Entity> selectBySQL(String sql, Object... arr);
}
