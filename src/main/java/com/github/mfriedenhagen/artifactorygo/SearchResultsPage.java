package com.github.mfriedenhagen.artifactorygo;

import com.github.mfriedenhagen.artifactorygo.model.ArtifactorySearchResults;
import com.github.mfriedenhagen.artifactorygo.model.ArtifactoryStorage;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.util.string.StringValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SearchResultsPage extends WebPage {

    private static final Logger LOG = LoggerFactory.getLogger(SearchResultsPage.class);
    private static final long serialVersionUID = 1L;
    private static final int ITEMS_PER_PAGE = 10;
    private final transient HttpClient client = new DefaultHttpClient();

    public SearchResultsPage(final PageParameters parameters) {
        super(parameters);
        LOG.debug("Parameters {}", parameters);
        final StringValue groupId = parameters.get("groupId");
        final StringValue artifactId = parameters.get("artifactId");
        final StringValue version = parameters.get("version");
        JsonResponseHandler<ArtifactorySearchResults> jsonResponseHandler = new JsonResponseHandler<ArtifactorySearchResults>(ArtifactorySearchResults.class);
        final String uri = "http://localhost:8081/artifactory/api/search/gavc?g=" + groupId + "&a=" + artifactId + "&v=" + version;
        HttpGet search = new HttpGet(URI.create(uri));
        search.addHeader("X-Result-Detail", "info");
        final ArtifactorySearchResults searchResults;
        try {
            searchResults = client.execute(search, jsonResponseHandler);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        final List<URL> uris = new ArrayList<URL>();
        final List<ArtifactoryStorage> results = searchResults.getResults();
        for (ArtifactoryStorage result : results) {
            uris.add(result.getDownloadUri());
        }
        LOG.info("searchResults = {}" + results.size());
        add(new Label("gav", "Found " + results.size() + " artifacts for " + groupId + ":" + artifactId + ":" + version));
        add(new Label("wicketVersion", getApplication().getFrameworkSettings().getVersion()));
        DataView<URL> dataView = new DataView<URL>("simple", new ListDataProvider<URL>(uris)) {
            @Override
            protected void populateItem(Item<URL> item) {
                final URL url = item.getModelObject();
                item.add(new ExternalLink("id", url.toString(), url.toString()));
            }
        };
        dataView.setItemsPerPage(ITEMS_PER_PAGE);
        add(dataView);
        add(new PagingNavigator("navigator", dataView));

    }
}
