package shop.serwer.dao.model.supplier;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "supplier")
@NamedQueries({
  @NamedQuery(name = "findAllSuppliers",
      query = "FROM SupplierEntity supplier")
})
public class SupplierEntity {
  @Id
  int id;
  String name;
  String nip;
  
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getNip() {
    return nip;
  }
  public void setNip(String nip) {
    this.nip = nip;
  }
}
