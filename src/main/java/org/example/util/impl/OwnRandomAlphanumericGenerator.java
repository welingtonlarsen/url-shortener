package org.example.util.impl;

import java.util.Locale;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import org.example.util.RandomIdGenerator;

public class OwnRandomAlphanumericGenerator implements RandomIdGenerator {

  public static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  public static final String lower = upper.toLowerCase(Locale.ROOT);
  public static final String digits = "0123456789";
  public static final String alphanumeric = upper + lower + digits;
  private final char[] symbols = alphanumeric.toCharArray();
  private final Random random = Objects.requireNonNull(ThreadLocalRandom.current());

  @Override
  public String generate(Integer length) {
    if (length < 1) throw new IllegalArgumentException();

    char[] idBuffer = new char[length];
    for (int index = 0; index < idBuffer.length; index++)
      idBuffer[index] = symbols[random.nextInt(symbols.length)];

    return new String(idBuffer);
  }
}
