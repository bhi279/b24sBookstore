package bookstoreproject.bookstore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.ArrayList;

import bookstoreproject.bookstore.domain.Category;
import bookstoreproject.bookstore.domain.CategoryRepository;

@DataJpaTest
public class CategoryRepositoryTests {

    @Autowired
    private CategoryRepository categoryRepository;

    // Test to create new categories
    @Test
    public void createNewCategoriesTest() {
        categoryRepository.save(new Category("romance"));
        Iterable<Category> categories = categoryRepository.findAll();

        List<String> categoryNames = new ArrayList<String>();
        for (Category category : categories) {
            categoryNames.add(category.getCategoryName());
        }

        assertThat(categoryNames.contains("romance"));
    }

    // Test to delete categories
    @Test
    public void deleteCategoryTest() {
        long repositorySize = categoryRepository.count();
        categoryRepository.save(new Category("romance"));
        long id = (categoryRepository.findByCategoryName("romance")).getId();
        categoryRepository.deleteById(id);

        assertThat(repositorySize).isEqualTo(categoryRepository.count());
    }

    // Test to find categories by their category name
    @Test
    public void findByCategoryNameTest() {
        Category romanceCategory = new Category("romance");
        categoryRepository.save(romanceCategory);

        assertThat(romanceCategory).isEqualTo(categoryRepository.findByCategoryName("romance"));
    }

}
