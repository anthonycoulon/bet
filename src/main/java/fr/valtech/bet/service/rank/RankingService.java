package fr.valtech.bet.service.rank;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import fr.valtech.bet.domain.model.user.User;
import fr.valtech.bet.domain.model.user.dto.UserBetDetailDto;
import fr.valtech.bet.domain.model.user.dto.UserRankingDto;

@Transactional(readOnly = true)
public interface RankingService {

    List<User> findRankingUser();

    List<UserRankingDto> transform(List<User> users);

    UserBetDetailDto findUserBetDetail(Long userId, Integer userRank);
}
