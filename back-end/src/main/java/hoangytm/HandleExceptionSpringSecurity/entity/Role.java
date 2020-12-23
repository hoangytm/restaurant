package hoangytm.HandleExceptionSpringSecurity.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author PhanHoang
 * 2/6/2020
 */
@Entity
@Table(name = "ROLES")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @Column(name = "USER_ID")
    private long userID;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "CREATED_ON")
    private Long createdOn;
    @Column(name = "MODIFIED_ON")
    private Long modifiedOn;
}

