package br.edu.ifsp.scl.prdm.sc3029531.stringconcatenator.navigation

// "lista" dos nomes dos nós (cada nó é uma tela)
sealed class Screen(val route: String) {
    object HomeScreen: Screen(route = "home_screen")

    object AddWordScreen: Screen(route = "add_word_screen")

}

//sealed class é uma classe especial que conhece seus objetos
// todas as instâncias de uma sealed class estão contidas dentro da própria classe
// o construtor de uma sealed class só pode ser chamado dentro da própria sealed class