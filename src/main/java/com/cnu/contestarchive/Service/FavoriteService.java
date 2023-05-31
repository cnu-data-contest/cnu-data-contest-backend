package com.cnu.contestarchive.Service;

import com.cnu.contestarchive.Domain.Favorite;
import com.cnu.contestarchive.Domain.User;
import com.cnu.contestarchive.Dto.FavoriteRequestDto;
import com.cnu.contestarchive.Repository.FavoriteRepository;
import com.cnu.contestarchive.Repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service  // 스프링의 서비스 빈으로 등록
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;
    private final UserJpaRepository userJpaRepository;

    // 관심 대외 활동을 추가. 이미 존재하는 경우 false 를 반환하고, 그렇지 않으면 true 를 반환함.
    @Transactional
    public boolean addFavorite(FavoriteRequestDto favorite) {
        if (findFavorite(favorite)) {
            return false;
        }

        Optional<User> user = userJpaRepository.findById(favorite.getUserId());
        if (!user.isPresent()) {
            return false;
        }
        favoriteRepository.save(Favorite.builder()
                .section(favorite.getSection())
                .title(favorite.getTitle())
                .user(user.get())
                .build());
        return true;
    }

    // 관심 대외 활동을 삭제. 존재하지 않는 경우 false 를 반환하고, 그렇지 않으면 true 를 반환함.
    public boolean removeFavorite(FavoriteRequestDto favorite) {
        if (!findFavorite(favorite)) {
            return false;
        }

        Optional<User> user = userJpaRepository.findById(favorite.getUserId());
        Optional<Favorite> deleteFavorite = favoriteRepository.findBySectionAndTitleAndUser(favorite.getSection(), favorite.getTitle(), user.get());

        if (!user.isPresent() && !deleteFavorite.isPresent()) {
            return false;
        }
        favoriteRepository.delete(deleteFavorite.get());
        return true;

    }

    // 모든 관심 대외 활동을 반환함.
    public Optional<List<Favorite>> getFavorites(String id) {
        return Optional.of(favoriteRepository.findAllByUserId(id));
    }

    // 관심 대외 활동이 존재하는지 확인함.
    public boolean findFavorite(FavoriteRequestDto favorite) {
        Optional<User> user = userJpaRepository.findById(favorite.getUserId());

        if (!user.isPresent()) {
            return false;
        }

        return favoriteRepository.findAll()
                .stream()
                .anyMatch(f -> f.getUser().getId().equals(user.get().getId())
                        && f.getSection().equals(favorite.getSection())
                        && f.getTitle().equals(favorite.getTitle()));
    }
}
