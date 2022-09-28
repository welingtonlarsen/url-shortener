package org.example.repository.impl;

import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.example.entity.ShortedLink;
import org.example.repository.ShortedLinkRepository;

public class ShortedLinkJPARepository implements ShortedLinkRepository {

  private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("URL-SHORTENER-DB");
  private static EntityManager entityManager = entityManagerFactory.createEntityManager();
  @Override
  public void save(ShortedLink shortedLink) {
    try {
      entityManager.getTransaction().begin();
      entityManager.persist(shortedLink);
      entityManager.getTransaction().commit();
    } catch (EntityExistsException exception) {
      save(shortedLink);
    }
  }

  @Override
  public ShortedLink findByPublicId(String publicId) {
    String jpql = "select sl from ShortedLink sl where publicId = :publicId ";
    TypedQuery<ShortedLink> typedQuery = entityManager
        .createQuery(jpql, ShortedLink.class)
        .setParameter("publicId", publicId);

    List<ShortedLink> result = typedQuery.getResultList();
    return result.get(0);
  }
}
