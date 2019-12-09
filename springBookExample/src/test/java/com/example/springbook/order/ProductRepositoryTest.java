package com.example.springbook.order;

import com.example.springbook.modal.Product;
import com.example.springbook.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class ProductRepositoryTest {

    @Autowired
    private ProductRepository repository;



    @Test
    public void createProduct() {
        Product product = new Product().setName("Camera bag").setPrice(new BigDecimal(49.99));

        product = repository.save(product);

    }



  /*  @Test

    @SuppressWarnings("unchecked")

    public void lookupProductsByDescription() {



        Pageable pageable = new PageRequest(0, 1, Direction.DESC, "name");

        Page<Product> page = repository.findByDescriptionContaining("Apple", pageable);



        assertThat(page.getContent(), hasSize(1));

        assertThat(page, Matchers.<Product> hasItems(named("iPad")));

        assertThat(page.getTotalElements(), is(2L));

        assertThat(page.isFirstPage(), is(true));

        assertThat(page.isLastPage(), is(false));

        assertThat(page.hasNextPage(), is(true));

    }
*/

}
