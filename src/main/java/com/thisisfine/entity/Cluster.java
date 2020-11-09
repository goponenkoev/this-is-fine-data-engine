package com.thisisfine.entity;

import java.util.Set;
import lombok.Data;

@Data
public class Cluster {

  private String lang;
  private String loc;
  private String header;
  private String title;
  private Set<Question> data;

  public static Cluster of(String lang, String loc, String header, String title,
      Set<Question> data) {
    Cluster cluster = new Cluster();
    cluster.setLang(lang);
    cluster.setLoc(loc);
    cluster.setHeader(header);
    cluster.setTitle(title);
    cluster.setData(data);
    return cluster;
  }
}
