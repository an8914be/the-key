package com.de.application.thekeyproxyservice.core.blogpost;

import java.util.Map;

/**
 * Interface for the core functionality for preparing data from the key academy blog
 */
public interface BlogPostController {
    /**
     * Prepare the data from the key academy blog
     *
     * @return {@link Map} of {@link String} and {@link Integer}
     */
    Map<String, Integer> prepareDataFromBlog();
}