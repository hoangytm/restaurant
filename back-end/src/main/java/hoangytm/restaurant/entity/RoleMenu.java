package hoangytm.restaurant.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author PhanHoang
 * 12/26/2020
 */
@Entity
@Table(name = "MENU")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleMenu {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID", nullable = false, length = 100)
    private String id;

    @Column(name = "ROLE_ID")
    private String roleId;

    @Column(name = "MENU_ID")
    private String menu;

}
