package shop.serwer.dao.model.deliveries;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="supplier")
public class SupplierEntity {
  @Id
  private int id;
}
