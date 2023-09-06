package com.trubitpro.uploadapkplugin.entry.lark;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ElementsDTO {

    @SerializedName("tag")
    private String tag;
    @SerializedName("text")
    private TextDTO text;
    @SerializedName("type")
    private String type;
    @SerializedName("url")
    private String url;
    @SerializedName("actions")
    private List<ElementsDTO> actions;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public TextDTO getText() {
        return text;
    }

    public void setText(TextDTO text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<ElementsDTO> getActions() {
        return actions;
    }

    public void setActions(List<ElementsDTO> actions) {
        this.actions = actions;
    }
}
