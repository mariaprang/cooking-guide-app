package cookingguide.repositories;

import cookingguide.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    public User findUsersByUsername(String email);
}
