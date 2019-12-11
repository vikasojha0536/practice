package com.example.springbook.product;

import com.example.springbook.modal.Product;
import com.example.springbook.repository.ProductRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.springbook.util.CoreMatchers.named;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.data.domain.Sort.Direction.DESC;

@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository repository;

    @Test
    public void createProduct() {
        Product product = new Product().setName("Camera bag").setPrice(new BigDecimal("49.99"));
        product = repository.save(product);
        Product abv = product.setName("ABV");
        repository.save(abv);
    }

    @BeforeEach
    public void setup(){
        Map<String, String> attributes = new HashMap<>();
        attributes.put("connector", "plug");
        Product ipad = new Product().setName("iPad bag").setDescription("Apple tablet device").setPrice(new BigDecimal("499.0"));
        Product mac = new Product().setName("MacBook Pro").setDescription("Apple notebook").setPrice(new BigDecimal("1299.0"));
        Product dock = new Product().setName("Dock").setDescription("Dock for iPhone/iPad").setPrice(new BigDecimal("49.0")).setAttributes(attributes);
        List<Product> products = new ArrayList<>();
        products.add(ipad);
        products.add(mac);
        products.add(dock);
        repository.saveAll(products);
    }

    @Test
    public void lookupProductsByDescription() {

        Pageable pageable = PageRequest.of(0, 1, DESC, "name");
        Page<Product> page = repository.findByDescriptionContaining("Apple", pageable);
        assertThat(page.getContent(), hasSize(1));
        assertThat(page, Matchers.hasItems(named("iPad bag")));
        assertThat(page.getTotalElements(), is(2L));
        assertThat(page.isFirst(), is(true));
        assertThat(page.isLast(), is(false));
        assertThat(page.hasNext(), is(true));
    }

    @Test
    public void findsProductsByAttributes() {

        List<Product> products = repository.findByAttributeAndValue("connector", "plug");
        assertThat(products, Matchers. hasItems(named("Dock")));
    }
}
