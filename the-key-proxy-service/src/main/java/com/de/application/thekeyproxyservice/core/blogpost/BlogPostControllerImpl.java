package com.de.application.thekeyproxyservice.core.blogpost;

import com.de.application.thekeyproxyservice.common.util.adapter.FetchDataFromBlogAdapter;
import com.de.application.thekeyproxyservice.common.util.adapter.WordCountAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementation of the core functionality
 */
@Component
public class BlogPostControllerImpl implements BlogPostController {
    private final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private final FetchDataFromBlogAdapter fetchDataFromBlogAdapter;
    private final WordCountAdapter wordCountAdapter;

    /**
     * The constructor
     * @param fetchDataFromBlogAdapter {@link FetchDataFromBlogAdapter}
     * @param wordCountAdapter {@link WordCountAdapter}
     */
    @Autowired
    public BlogPostControllerImpl(FetchDataFromBlogAdapter fetchDataFromBlogAdapter, WordCountAdapter wordCountAdapter) {
        this.fetchDataFromBlogAdapter = fetchDataFromBlogAdapter;
        this.wordCountAdapter = wordCountAdapter;
    }

    @Override
    public Map<String, Integer> prepareDataFromBlog() {
        try {
            final String[] content = {""};

            this.fetchDataFromBlogAdapter.fetchData().forEach(blogPost -> {
                if(blogPost.getContent() != null && blogPost.getContent().getRendered() != null) {
                    content[0] = content[0].concat(blogPost.getContent().getRendered().replaceAll("<[^>]*>", " "));
                    content[0] = content[0].concat(" ");
                }
            });

            return this.wordCountAdapter.countWordsToMap(content[0]);
        } catch (Exception exception) {
            logger.log(Level.WARNING, exception.toString());
            exception.printStackTrace();
        }
        return null;
    }
}
