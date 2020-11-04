package com.thisisfine.entity;

import lombok.Data;

@Data
public class Question {

  private String question;
  private Answer answer;

  public static Question of(String text, Answer answer) {
    Question question = new Question();
    question.setQuestion(text);
    question.setAnswer(answer);
    return question;
  }
}
