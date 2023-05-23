package com.cnu.contestarchive;

import com.cnu.contestarchive.Domain.Favorite;
import com.cnu.contestarchive.Repository.FavoriteRepository;
import com.cnu.contestarchive.Service.FavoriteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class FavoriteServiceTest {

    @Autowired
    private FavoriteService favoriteService;

    @Autowired
    private FavoriteRepository favoriteRepository;

    @Test
    @Transactional
    @Rollback
    public void testAddFavorite() {
        Favorite favorite = new Favorite("1", "Music", "Rock");

        assertTrue(favoriteService.addFavorite(favorite));

        Optional<Favorite> favoriteFromDb = favoriteRepository.findById("1");

        assertTrue(favoriteFromDb.isPresent());
        assertEquals(favorite.getId(), favoriteFromDb.get().getId());
        assertEquals(favorite.getSection(), favoriteFromDb.get().getSection());
        assertEquals(favorite.getTitle(), favoriteFromDb.get().getTitle());
    }

    @Test
    @Transactional
    @Rollback
    public void testAddDuplicateFavorite() {
        Favorite favorite1 = new Favorite("1", "Music", "Rock");
        Favorite favorite2 = new Favorite("1", "Music", "Rock");

        assertTrue(favoriteService.addFavorite(favorite1));
        assertFalse(favoriteService.addFavorite(favorite2));
    }

    @Test
    @Transactional
    @Rollback
    public void testDeleteFavorite() {
        String userId = "1";
        Favorite favorite = new Favorite(userId, "Music", "Rock");

        favoriteService.addFavorite(favorite);
        assertTrue(favoriteService.removeFavorite(favorite));

        assertEquals(0, favoriteService.getFavorites(userId).orElse(Collections.emptyList()).size());
    }

    @Test
    @Transactional
    @Rollback
    public void testDeleteNonExistentFavorite() {
        Favorite favorite = new Favorite("1", "Music", "Rock");

        assertFalse(favoriteService.removeFavorite(favorite));
    }

    @Test
    @Transactional
    @Rollback
    public void testGetFavorites() {
        String userId = "1";
        Favorite favorite1 = new Favorite(userId, "Book", "Mystery");
        Favorite favorite2 = new Favorite(userId, "Movie", "Action");
        Favorite favorite3 = new Favorite("2", "Music", "Rock");

        favoriteService.addFavorite(favorite1);
        favoriteService.addFavorite(favorite2);
        favoriteService.addFavorite(favorite3);

        assertEquals(2, favoriteService.getFavorites(userId).orElse(Collections.emptyList()).size());
    }

    @Test
    @Transactional
    @Rollback
    public void testGetFavoritesEmpty() {
        String userId = "1";

        assertEquals(0, favoriteService.getFavorites(userId).orElse(Collections.emptyList()).size());
    }

}
