package com.github.mfriedenhagen.artifactorygo;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SearchResultsPage extends WebPage {

    private final static Logger LOG = LoggerFactory.getLogger(SearchResultsPage.class);
    
    private static final long serialVersionUID = 1L;

    public SearchResultsPage(final PageParameters parameters) {
        super(parameters);
        LOG.debug("Parameters {}", parameters);
        add(new Label("gav"));
        add(new Label("wicketVersion", getApplication().getFrameworkSettings().getVersion()));
    }
}
