package com.cnu.contestarchive.Controller;

import com.cnu.contestarchive.Domain.Favorite;
import com.cnu.contestarchive.Service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController  // 스프링의 REST 컨트롤러 빈으로 등록
@RequestMapping("/favorite")  // 모든 메서드는 '/favorite' URL에 매핑
public class FavoriteController {

    private final FavoriteService favoriteService;

    @Autowired  // 생성자에 이 어노테이션을 추가, favoriteService를 자동 주입함.
    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    // HTTP POST 요청을 처리하여 관심 대외 활동을 추가합니다.
    @PostMapping
    public ResponseEntity<Boolean> addFavorite(@RequestBody Favorite favorite) {
        return ResponseEntity.ok(favoriteService.addFavorite(favorite));
    }

    // HTTP DELETE 요청을 처리하여 관심 대외 활동을 삭제합니다.
    @DeleteMapping
    public ResponseEntity<Boolean> removeFavorite(@RequestBody Favorite favorite) {
        return ResponseEntity.ok(favoriteService.removeFavorite(favorite));
    }

    // HTTP GET 요청을 처리하여 모든 관심 대외 활동을 반환합니다.
    @GetMapping("/{id}")
    public ResponseEntity<List<Favorite>> getFavorites(@PathVariable String id) {
        List<Favorite> favorites = favoriteService.getFavorites(id).orElse(Collections.emptyList());
        return ResponseEntity.ok(favorites);
    }

}