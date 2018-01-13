package md.utm.fcim.usermanagement.repository.entity

import javax.persistence.*

@Entity
@Table(name = "user_security")
data class UserEntity(@Id
                      @GeneratedValue(strategy = GenerationType.IDENTITY)
                      @Column(name = "id")
                      val id: Long? = null,

                      @Column(name = "username")
                      val username: String,

                      @Column(name = "password")
                      val password: String,

                      @Column(name = "id_parking_lot")
                      val idParkingLot: Long? = null,

                      @ManyToMany(fetch = FetchType.EAGER)
                      @JoinTable(name = "user_role",
                              joinColumns = [(JoinColumn(name = "id_user"))],
                              inverseJoinColumns = [(JoinColumn(name = "id_role"))])
                      val roles: Set<RoleEntity?> = HashSet()) {
    @Suppress(names = ["unused"])
    private constructor() : this(username = "", password = "")
}
