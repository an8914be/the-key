package com.de.application.thekeyproxyservice.common.config.other;

/**
 * Routes-class for needed routes in the application
 */
public class Routes {
    private Routes() {
    }

    /**
     * Host route
     */
    private static final String HOST = "http://localhost";

    /**
     * Word-Count-Map service route
     */
    public static final String WORD_COUNT_MAP_SERVICE_URL = HOST + ":8080/rest/word-count-map/v1/count";

    /**
     * Fetch-Data-Service route
     */
    public static final String FETCH_DATA_SERVICE_URL = HOST + ":8081/rest/data/v1/fetch/blog";
    /**
     * GUI route
     */
    public static final String GUI_URL = HOST + ":4200";

    /**
     * Own route
     */
    public static final String PROXY_URL = HOST + ":8082";

    /**
     * Websocket endpoint
     */
    public static final String WEBSOCKET_ENDPOINT = "/ws";

    /**
     * GUI websocket destination endpoint
     */
    public static final String DESTINATION_ENDPOINT = "/connection/message";

    /**
     * GUI websocket destination
     */
    public static final String DESTINATION = "/connection";

    /**
     * Websocket destination prefix
     */
    public static final String DESTINATION_PREFIX = "/backend";
}