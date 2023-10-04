package com.example.martapp.product.business

import com.example.martapp.product.business.model.ProductModel
import com.example.martapp.product.component.ProductNameChecker
import com.example.martapp.product.persistence.entity.Product
import com.example.mock.FakeProductRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class GiveProductInfoServiceTest {

    @Test
    @DisplayName("사용자가 상품의 번호를 입력하면 해당 상품을 모델로 감싼 객체를 응답한다.")
    fun getProductInfo() {
        // Given
        val fakeProductRepository = FakeProductRepository()
        val productNameChecker = ProductNameChecker()
        val giveProductInfoService = GiveProductInfoService(fakeProductRepository, productNameChecker)
        val product = Product(1, "000","SampleProductName", 1000)
        fakeProductRepository.addProduct(product)
        val expected = ProductModel.of(product)

        // When
        val actual = giveProductInfoService.getProductInfo("000")

        // Then
        assertEquals(expected, actual)
    }

    @Test
    @DisplayName("사용자가 상품의 번호를 입력시 영어이면 에러를 뱉는다.")
    fun getProductInfoWithWrongInput() {
        // Given

        // When

        // Then

        // ....

    }
}
