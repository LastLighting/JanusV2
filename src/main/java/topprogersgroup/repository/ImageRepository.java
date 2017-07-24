package topprogersgroup.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import topprogersgroup.entity.Bid;
import topprogersgroup.entity.UploadImage;

import java.util.List;

public interface ImageRepository extends JpaRepository<UploadImage, Integer> {
}
