package org.example;

import static spark.Spark.*;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.example.repository.ShortedLinkRepository;
import org.example.repository.impl.ShortedLinkJPARepository;
import org.example.service.ShortUrlService;
import org.example.util.impl.RandomAlphanumericGenerator;

public class App {
    public static void main( String[] args ) {
        final ShortedLinkRepository shortedLinkRepository = new ShortedLinkJPARepository();
        final ShortUrlService shortUrlService = new ShortUrlService(new RandomAlphanumericGenerator(), shortedLinkRepository);

        post("/url-shortener", (req, res) -> {
            JsonObject jsonObject = new JsonParser().parse(req.body()).getAsJsonObject();
            String originalLink = jsonObject.get("url").getAsString();

            String shortedLink = shortUrlService.execute(originalLink);

            res.status(201);
            return shortedLink;
        });

        get("/url-shortener/:public-id", (req, res) -> {
            String publicId = req.params(":public-id");

            var shortedLink = shortedLinkRepository.findByPublicId(publicId);

            res.status(303);
            res.redirect(shortedLink.getOriginalLink());
            return res;
        });
    }
}
