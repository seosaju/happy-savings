package seosaju.happysavings.module.paper.domain;

import java.util.List;

public interface PaperRepository {

    Paper save(Paper paper);

    List<Paper> findAllByStorageId(long storageId);
}
