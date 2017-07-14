package www.wanfin.com.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import www.wanfin.com.user.entity.OrderInfo;




@Repository
public interface OrderRepository extends JpaRepository<OrderInfo, Long> {


	/*public List<User> findList();*/
	@Modifying
    @Query(value = "INSERT INTO  order_info (`acc_id`, `order_id`) " +
	            "VALUES (?2, ?1)", nativeQuery=true)
	int insert(Long orderId,String accId);
	@Modifying
    @Query(value = "update  order_info set `status`=?2 where order_id=?1", nativeQuery=true)
	int update(Long orderId,String status);
}
