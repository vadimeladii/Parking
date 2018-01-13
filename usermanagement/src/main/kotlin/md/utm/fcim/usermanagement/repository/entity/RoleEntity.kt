package md.utm.fcim.usermanagement.repository.entity

import javax.persistence.*

@Entity
@Table(name = "role")
data class RoleEntity(@Id
                      @GeneratedValue(strategy = GenerationType.IDENTITY)
                      @Column(name = "id")
                      val id: Long? = null,

                      @Column(name = "name")
                      val name: String) {
    @Suppress(names = ["unused"])
    private constructor() : this(name = "")
}