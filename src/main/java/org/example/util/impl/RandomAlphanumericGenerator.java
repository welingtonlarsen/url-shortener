package org.example.util.impl;

import org.apache.commons.lang3.RandomStringUtils;
import org.example.util.RandomIdGenerator;

public class RandomAlphanumericGenerator implements RandomIdGenerator {

  @Override
  public String generate(Integer length) {
    return RandomStringUtils.randomAlphanumeric(length);
  }
}
