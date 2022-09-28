package org.example.repository;

import org.example.entity.ShortedLink;

public interface ShortedLinkRepository {
  void save(ShortedLink shortedLink);

  ShortedLink findByPublicId(String publicId);
}
