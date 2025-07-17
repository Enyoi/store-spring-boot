package com.example.store.application.usecase;

import com.example.store.domain.model.Category;
import com.example.store.domain.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class CategoryServiceTest {
    private CategoryRepository categoryRepository;
    private CategoryService categoryService;

    @BeforeEach
    void setUp() {
        categoryRepository  = mock(CategoryRepository.class);
        categoryService = new CategoryService(categoryRepository);
    }

    @Test
    void shouldSaveCategory() {
        Category category = new Category(null, "test");
        Category saved = new Category(UUID.randomUUID(), "test");
        when(categoryRepository.save(category)).then(invocation -> saved);
        Category result = categoryService.create(category);
        assertEquals("test", result.getName());
        verify( categoryRepository).save(category);
    }

    @Test
    void shouldReturnCategoryById() {
        UUID id = UUID.randomUUID();

        Category category = new Category(id, "test");

        when(categoryRepository.findById(id)).thenReturn(Optional.of(category));

        Category result = categoryService.getById(id);

        assertEquals("test", result.getName());
        assertEquals(id, result.getId());
        verify( categoryRepository).findById(id);
    }

    @Test
    void shouldReturnAllCategories() {
        List<Category> categories = Arrays.asList(new Category(UUID.randomUUID(), "test"), new Category(UUID.randomUUID(), "test2"));

        when(categoryRepository.findAll()).thenReturn(categories);

        List<Category> result = categoryService.findAll();

        assertEquals(2, result.size());
        assertEquals(categories.get(0), result.get(0));
        assertEquals(categories.get(1), result.get(1));
        verify(categoryRepository).findAll();
    }

    @Test
    void shouldUpdateCategoryIfExists() {
        UUID id = UUID.randomUUID();
        Category input = new Category(null, "Updated");
        Category existing = new Category(id, "Old");

        when(categoryRepository.findById(id)).thenReturn(Optional.of(existing));
        when(categoryRepository.save(any(Category.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Category result = categoryService.update(id, input);
        assertEquals("Updated", result.getName());
        assertEquals(id, result.getId());

        ArgumentCaptor<Category> categoryArgumentCaptor = ArgumentCaptor.forClass(Category.class);
        verify(categoryRepository).save(categoryArgumentCaptor.capture());
        assertEquals(id, categoryArgumentCaptor.getValue().getId());
    }

    @Test
    void shouldThrowExceptionWhenUpdatingNonExistentCategory() {
        UUID id = UUID.randomUUID();
        Category input = new Category(null, "Updated");

        when(categoryRepository.findById(id)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> categoryService.update(id, input));

        assertEquals("Category not found", exception.getMessage());

    }

}
