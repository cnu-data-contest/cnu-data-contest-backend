package com.cnu.contestarchive.Service;

import com.cnu.contestarchive.Domain.Favorite;
import com.cnu.contestarchive.Repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service  // 스프링의 서비스 빈으로 등록
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;

    @Autowired  // 애노테이션을 추가, favoriteRepository를 자동 주입
    public FavoriteService(FavoriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
    }

    // 관심 대외 활동을 추가. 이미 존재하는 경우 false를 반환하고, 그렇지 않으면 true를 반환함.
    public boolean addFavorite(Favorite favorite) {
        if (favoriteRepository.existsById(favorite.getId())) {
            return false;
        }
        favoriteRepository.save(favorite);
        return true;
    }

    // 관심 대외 활동을 삭제. 존재하지 않는 경우 false를 반환하고, 그렇지 않으면 true를 반환함.
    public boolean removeFavorite(Favorite favorite) {
        if (!favoriteRepository.existsById(favorite.getId())) {
            return false;
        }
        favoriteRepository.delete(favorite);
        return true;
    }

    // 모든 관심 대외 활동을 반환힘.
    public Optional<List<Favorite>> getFavorites(String id) {
        return Optional.of(favoriteRepository.findAll());
    }
}
