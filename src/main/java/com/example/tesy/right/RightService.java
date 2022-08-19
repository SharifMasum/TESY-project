package com.example.tesy.right;

import com.example.tesy.people.PeopleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RightService {

    private final RightRepository rightRepository;

    @Autowired
    public RightService(RightRepository rightRepository) {
        this.rightRepository = rightRepository;
    }

    public List<RightEntity> getRight(){
        return rightRepository.findAll();
    }

    public void addNewRight(RightEntity rightName) {
        System.out.println(rightName);

        Optional<RightEntity> rightOptional = rightRepository.findRightByRightName(rightName.getRightName());
        if (rightOptional.isPresent()) {
            throw new IllegalStateException("This Right is registered before !");
        }
        rightRepository.save(rightName);
    }

    public void deleteRight(Integer rightId) {
        boolean exists = rightRepository.existsById(rightId);
        if (!exists) {
            throw new IllegalStateException("This Person whit id "+ rightId+" do not exists!");
        }
        rightRepository.deleteById(rightId);
    }
    @Transactional
    public void updateRight(Integer rightId,
                             String rightName) {
        RightEntity right = rightRepository.findById(rightId)
                .orElseThrow(() -> new IllegalStateException("person with ID " + rightId + " do not exists!"));

        if ( rightName != null &&
                rightName.length() > 0 &&
                !Objects.equals(right.getRightName(), rightName)) {
            Optional <RightEntity> rightEntityOptional = rightRepository.findRightByRightName(rightName);
            if (rightEntityOptional.isPresent()) {
                throw new IllegalStateException("This right is registered before !");
            }
            right.setRightName(rightName);
        }

        System.out.println(right);
    }
}
