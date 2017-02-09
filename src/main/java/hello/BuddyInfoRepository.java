package hello;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by vincentvu on 2/2/2017.
 */
@RepositoryRestResource(collectionResourceRel = "buddies", path = "buddies")
public interface BuddyInfoRepository extends PagingAndSortingRepository<BuddyInfo, Long> {

    List<BuddyInfo> findByName(@Param("name") String name);
    List<BuddyInfo> findByAddress(@Param("address") String address);
    List<BuddyInfo> findByPhoneNumber(@Param("phoneNumber") String phoneNumber);

}
