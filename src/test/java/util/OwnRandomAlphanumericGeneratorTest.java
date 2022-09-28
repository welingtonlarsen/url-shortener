package util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.util.RandomIdGenerator;
import org.example.util.impl.OwnRandomAlphanumericGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OwnRandomAlphanumericGeneratorTest {

  private RandomIdGenerator randomIdGenerator;

  @BeforeEach
  void beforeEach() {
    randomIdGenerator = new OwnRandomAlphanumericGenerator();
  }

  @Test
  void shouldGenerateRandomAlphanumericId() {
    String result = randomIdGenerator.generate(6);
    assertEquals(6, result.length());
  }

}
