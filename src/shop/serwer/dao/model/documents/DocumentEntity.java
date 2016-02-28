package shop.serwer.dao.model.documents;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="documents")
public class DocumentEntity {
  @Id
  int id;
}
