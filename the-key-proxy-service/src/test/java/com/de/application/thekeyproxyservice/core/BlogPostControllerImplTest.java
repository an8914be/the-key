package com.de.application.thekeyproxyservice.core;

import com.de.application.thekeyproxyservice.common.util.adapter.FetchDataFromBlogAdapter;
import com.de.application.thekeyproxyservice.common.util.adapter.WordCountAdapter;
import com.de.application.thekeyproxyservice.core.blogpost.BlogPostControllerImpl;
import com.de.application.thekeyproxyservice.helper.TestDataGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


/**
 * Test for BlogPostControllerImpl class
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {BlogPostControllerImpl.class})
class BlogPostControllerImplTest {
    @MockBean
    private FetchDataFromBlogAdapter fetchDataFromBlogAdapter;
    @MockBean
    private WordCountAdapter wordCountAdapter;

    private final BlogPostControllerImpl blogPostController;

    @Autowired
    BlogPostControllerImplTest(BlogPostControllerImpl blogPostController) {
        this.blogPostController = blogPostController;
    }

    @Test
    void testPrepareDataFromBlog() {
        // Arrange
        when(fetchDataFromBlogAdapter.fetchData()).thenReturn(TestDataGenerator.createListOfBlogPosts());
        when(wordCountAdapter.countWordsToMap(any())).thenReturn(TestDataGenerator.createWordCountMap());

        // Act
        Map<String, Integer> result = this.blogPostController.prepareDataFromBlog();

        // Assert
        assertThat(result.size()).isEqualTo(TestDataGenerator.createWordCountMap().size());
    }

    @Test
    void testPrepareDataFromBlogConcat() {
        // Arrange
        when(fetchDataFromBlogAdapter.fetchData()).thenReturn(TestDataGenerator.createListOfBlogPostsWithContent());
        when(wordCountAdapter.countWordsToMap(any())).thenReturn(TestDataGenerator.createWordCountMap());

        // Act
        Map<String, Integer> result = this.blogPostController.prepareDataFromBlog();

        // Assert
        assertThat(result.size()).isEqualTo(TestDataGenerator.createWordCountMap().size());
        verify(this.wordCountAdapter).countWordsToMap(eq(TestDataGenerator.createReadyStringToCompare()));
    }

    @Test
    void testPrepareDataFromBlogContentNull() {
        // Arrange
        when(fetchDataFromBlogAdapter.fetchData()).thenReturn(TestDataGenerator.createListOfBlogPosts());
        when(wordCountAdapter.countWordsToMap(any())).thenReturn(TestDataGenerator.createWordCountMap());

        // Act
        Map<String, Integer> result = this.blogPostController.prepareDataFromBlog();

        // Assert
        assertThat(result.size()).isEqualTo(TestDataGenerator.createWordCountMap().size());
        verify(this.wordCountAdapter).countWordsToMap(eq(TestDataGenerator.createEmptyString()));
    }

    @Test
    void testPrepareDataFromBlogRendererNull() {
        // Arrange
        when(fetchDataFromBlogAdapter.fetchData()).thenReturn(TestDataGenerator.createListOfBlogPostsWithoutRenderer());
        when(wordCountAdapter.countWordsToMap(any())).thenReturn(TestDataGenerator.createWordCountMap());

        // Act
        Map<String, Integer> result = this.blogPostController.prepareDataFromBlog();

        // Assert
        assertThat(result.size()).isEqualTo(TestDataGenerator.createWordCountMap().size());
        verify(this.wordCountAdapter).countWordsToMap(eq(TestDataGenerator.createEmptyString()));
    }

    @Test
    void testPrepareDataFromBlogWithHTMLTags() {
        // Arrange
        when(fetchDataFromBlogAdapter.fetchData()).thenReturn(TestDataGenerator.createListOfBlogPostsWithHTMLTags());
        when(wordCountAdapter.countWordsToMap(any())).thenReturn(TestDataGenerator.createWordCountMap());

        // Act
        Map<String, Integer> result = this.blogPostController.prepareDataFromBlog();

        // Assert
        assertThat(result.size()).isEqualTo(TestDataGenerator.createWordCountMap().size());
        verify(this.wordCountAdapter).countWordsToMap(eq(TestDataGenerator.createReadyStringToCompareWithWhitespaces()));
    }
}