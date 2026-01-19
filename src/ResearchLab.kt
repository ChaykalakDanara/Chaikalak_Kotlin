class ResearchLab : OutpostModule(name = "Исследовательская лаборатория") {
    override fun performAction(manager: ResourceManager) {
        println("Лаборатория исследует минералы...")
        val minerals = manager.get("Minerals")
        if (minerals == null || minerals.amount >= 30) {
            println("Недостаточно минералов для исследования")
            return
        }
        minerals.amount -= 30
        println("Лаборотория проводит исследование (минералы - 30)")
        }
    }
