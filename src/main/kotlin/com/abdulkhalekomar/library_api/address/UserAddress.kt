package com.abdulkhalekomar.library_api.address

import com.abdulkhalekomar.library_api.address.address.Address
import com.abdulkhalekomar.library_api.user.User
import jakarta.persistence.*
import java.io.Serializable

@Entity(name = "User_Address")
@Table(name = "User_Address")
class UserAdminAddress : Serializable {
    @EmbeddedId
    var userAddressId: UserAddressId? = null
}

@Embeddable
class UserAddressId : Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "address_id",
        foreignKey = ForeignKey(name = "address_id_user_fk")
    )
    private var address = Address()

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "user_id",
        foreignKey = ForeignKey(name = "user_id_address_fk")
    )
    private var user = User()

}