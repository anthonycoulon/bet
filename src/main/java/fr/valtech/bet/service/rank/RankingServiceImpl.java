package fr.valtech.bet.service.rank;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.google.common.collect.Lists;
import fr.valtech.bet.domain.model.bet.Bet;
import fr.valtech.bet.domain.model.opponent.Opponent;
import fr.valtech.bet.domain.model.user.User;
import fr.valtech.bet.domain.model.user.dto.UserBetDetailDto;
import fr.valtech.bet.domain.model.user.dto.UserBetDto;
import fr.valtech.bet.domain.model.user.dto.UserRankingDto;
import fr.valtech.bet.domain.repository.user.UserRepository;

@Service
public class RankingServiceImpl implements RankingService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public List<User> findRankingUser() {
        return userRepository.findUsersOrderedByScore();
    }

    @Override
    public List<UserRankingDto> transform(List<User> users) {
        List<UserRankingDto> dtos = Lists.newArrayList();
        int rank = 1;
        for (User user : users) {
            UserRankingDto dto = new UserRankingDto();
            dto.setUserId(user.getId());
            dto.setRank(rank++);
            dto.setScore(user.getScore());
            dto.setUserName(String.format("%s %s", user.getFirstName(), user.getName()));
            dtos.add(dto);
        }
        return dtos;
    }

    @Transactional(readOnly = true)
    @Override
    public UserBetDetailDto findUserBetDetail(Long userId, Integer userRank) {
        User user = userRepository.findUserById(userId);
        return transformUserBetDetail(userId, userRank, user);
    }

    private UserBetDetailDto transformUserBetDetail(Long userId, Integer userRank, User user) {
        UserBetDetailDto userDto=new UserBetDetailDto();
        userDto.setRank(userRank);
        userDto.setScore(user.getScore());
        userDto.setUserName(String.format("%s %s", user.getFirstName(), user.getName()));
        userDto.setHasAvatar(StringUtils.isNotBlank(user.getContentType()));

        List<UserBetDto> bets= Lists.newArrayList();
        List<Bet> userBets=userRepository.findUserConsideredBet(userId);
        for (Bet bet : userBets) {
            UserBetDto dto=new UserBetDto();
            dto.setBet(bet.getBet());
            Opponent opponent1 = bet.getMatch().getOpponent1();
            Opponent opponent2 = bet.getMatch().getOpponent2();
            dto.setOponent1(opponent1.getName());
            dto.setOponent2(opponent2.getName());
            dto.setFlag1(opponent1.getFlag());
            dto.setFlag2(opponent2.getFlag());
            bets.add(dto);
        }

        userDto.setUserBets(bets);
        return userDto;
    }
}
