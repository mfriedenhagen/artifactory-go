package com.github.mfriedenhagen.artifactorygo;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;

public class HomePage extends WebPage {

    private static final long serialVersionUID = 1L;

    public HomePage(final PageParameters parameters) {
        super(parameters);
        add(new TextFieldWithValue("groupId", "myGroupId"));
        add(new TextFieldWithValue("artifactId", "myArtifactId"));
        add(new TextFieldWithValue("version", "myVersion"));
        add(new Label("wicketVersion", getApplication().getFrameworkSettings().getVersion()));
    }
}
