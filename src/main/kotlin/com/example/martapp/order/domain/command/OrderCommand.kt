package com.example.martapp.order.domain.command

class OrderCommand {
    data class Register(
        val ordererName: String,
        val ordererAddress: String,
        val totalPrice: Double,
    ) {
        companion object {
            fun of(
                ordererName: String,
                ordererAddress: String,
                totalPrice: Double,
            ): Register {
                return Register(
                    ordererName = ordererName,
                    ordererAddress = ordererAddress,
                    totalPrice = totalPrice,
                )
            }
        }
    }

    data class Update(
        val orderNo: Long,
        val ordererAddress: String,
    ) {
        companion object {
            fun of(
                orderNo: Long,
                ordererAddress: String,
            ): Update {
                return Update(
                    orderNo = orderNo,
                    ordererAddress = ordererAddress,
                )
            }
        }
    }
}