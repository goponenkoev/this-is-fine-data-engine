package com.thisisfine.entity;

import lombok.Data;

@Data
public class Answer {

  private String plainText;
  private String html;

  public static Answer of(String plainText, String html) {
    Answer answer = new Answer();
    answer.setPlainText(plainText);
    answer.setHtml(html);
    return answer;
  }
}
