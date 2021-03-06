package PollPoint.data;

import PollPoint.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
    Category findByCategoryString(String categoryString);
}
