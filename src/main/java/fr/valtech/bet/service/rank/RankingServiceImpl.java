package fr.valtech.bet.service.rank;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.google.common.collect.Lists;
import fr.valtech.bet.domain.model.user.User;
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
            dto.setUserName(user.getFirstName() + " " + user.getName());
            dtos.add(dto);
        }
        return dtos;
    }
}
