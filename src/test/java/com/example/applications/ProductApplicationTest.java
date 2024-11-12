package com.example.applications;

import com.example.entities.Product;
import com.example.services.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductApplicationTest {
    @InjectMocks
    private ProductApplication productApplication;

    @Mock
    private ProductService productService;

    @Mock
    Product product;

    @Test
    public void verificarSeSalvaImagemCorretamente(){
        productApplication.append(product);
        verify(productService, times(1)).save(product);
    }

    @Test
    public void verificarSeImagemERemovidaCorretamente(){
        productApplication.remove(product.getId());
        verify(productService, times(1)).remove(product.getId());
    }

    @Test
    public void verificarSeImagemEAtualizadaCorretamente(){
        productApplication.update(product.getId(), product);
        verify(productService, times(1)).update(product);
    }
}
