package _01_intro_to_APIs;

import java.util.List;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Result {


@SerializedName("title")
@Expose
private String title;
@SerializedName("authors")
@Expose
private List<String> authors = null;
@SerializedName("link")
@Expose
private String link;

public String getTitle() {
return title;
}

public void setTitle(String title) {
this.title = title;
}

public List<String> getAuthors() {
return authors;
}

public void setAuthors(List<String> authors) {
this.authors = authors;
}

public String getLink() {
return link;
}

public void setLink(String link) {
this.link = link;
}

}