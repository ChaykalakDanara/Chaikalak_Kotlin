package payment

class PaymentProcessor {
    private val validator = PaymentValidator()

    fun pay(payment: Payment): PaymentResult{
        if (!validator.check(payment)){
            return PaymentResult.Error(reason = "Ошибка валидации")
        }
        return when (payment.type) {
            payment.CardType.VISA -> PaymentResult.Success(id = "VISA-${System.currentTimeMillis()}")
            payment.CardType.MASTERCARD -> PaymentResult.Processing
            payment.CardType.MIR -> PaymentResult.Success(id = "MIR-${System.currentTimeMillis()}")
            payment.CardType.UNKNOWN -> PaymentResult.Error(reason = "Неизвестный тип карты")
        }
    }
}
