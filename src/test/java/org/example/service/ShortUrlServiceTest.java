package org.example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.example.entity.ShortedLink;
import org.example.repository.ShortedLinkRepository;
import org.example.util.RandomIdGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ShortUrlServiceTest {

  private ShortUrlService shortUrlUseCase;
  @Mock
  private ShortedLinkRepository shortedLinkRepository;
  @Mock
  private RandomIdGenerator randomIdGenerator;

  @BeforeEach
  public void beforeEach() {
    shortUrlUseCase = new ShortUrlService(randomIdGenerator, shortedLinkRepository);
  }

  @Test
  void shouldSuccessfulShortAnUrl() {
    Mockito.when(randomIdGenerator.generate(6)).thenReturn("AakBHX");
    var originalLink = "http://www.somehost.com/some-path";

    var result = shortUrlUseCase.execute(originalLink);

    assertEquals("AakBHX", result);
    verify(randomIdGenerator, times(1)).generate(6);
    verify(shortedLinkRepository, times(1)).save(any(ShortedLink.class));
  }
}
