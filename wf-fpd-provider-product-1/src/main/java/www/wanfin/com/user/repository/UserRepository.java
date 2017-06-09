package www.wanfin.com.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import www.wanfin.com.user.entity.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	/*public List<User> findList();*/
	/*@Query("select u from User u where u.sex=?1")
	public List<User> getUsersBySex(String sex);*/
}
