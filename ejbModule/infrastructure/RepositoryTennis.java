package infrastructure;

import javax.ejb.Local;

@Local
public interface RepositoryTennis {
	public void persist(Object object);
	public <T> T find(Class<T> clazz, int id);
}
