package org.example.service;

import org.example.entity.ShortedLink;
import org.example.repository.ShortedLinkRepository;
import org.example.util.RandomIdGenerator;

public class ShortUrlService {

  private RandomIdGenerator randomIdGenerator;
  private ShortedLinkRepository shortedLinkRepository;

  public ShortUrlService(RandomIdGenerator randomIdGenerator, ShortedLinkRepository shortedLinkRepository) {
    this.randomIdGenerator = randomIdGenerator;
    this.shortedLinkRepository = shortedLinkRepository;
  }
  public String execute(String originalLink) {
    var id = randomIdGenerator.generate(6);
    ShortedLink shortedLink = new ShortedLink(id, originalLink);
    shortedLinkRepository.save(shortedLink);
    return id;
  }
}
