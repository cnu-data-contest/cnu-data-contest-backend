package com.cnu.contestarchive.Repository;

import com.cnu.contestarchive.Domain.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository 인터페이스를 상속하여 Favorite 객체를 데이터베이스에 저장하고 검색하는데 사용
public interface FavoriteRepository extends JpaRepository<Favorite, String> {
}
