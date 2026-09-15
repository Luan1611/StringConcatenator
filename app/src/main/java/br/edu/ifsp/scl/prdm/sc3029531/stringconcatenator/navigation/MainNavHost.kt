package br.edu.ifsp.scl.prdm.sc3029531.stringconcatenator.navigation

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import br.edu.ifsp.scl.prdm.sc3029531.stringconcatenator.ui.composable.AddWordScreen
import br.edu.ifsp.scl.prdm.sc3029531.stringconcatenator.ui.composable.HomeScreen

private const val TEXT_TO_CONCATENATE = "text_to_concatenate"
private const val TEXT_TO_SHOW = "text_to_show"

@Composable
fun MainNavHost(navHostController: NavHostController, modifier: Modifier) {

    NavHost(
        navController = navHostController,
        startDestination = Screen.HomeScreen.route
    ) {

        // Nó HomeScreen
        composable(
            route = Screen.HomeScreen.route
        ) { backStackEntry ->

            val textToConcatenate = backStackEntry.savedStateHandle.get<String>(TEXT_TO_CONCATENATE)?: ""
            val textToShow = backStackEntry.savedStateHandle.get<String>(TEXT_TO_SHOW)?: ""

            if (textToConcatenate.isNotEmpty()) {
                backStackEntry.savedStateHandle.set(TEXT_TO_CONCATENATE, "")
            }

            HomeScreen(
                modifier = modifier,
                textToShow = textToShow,
                textToConcatenate = textToConcatenate,
                onAddWordClick = { textToSend ->
                    navHostController.navigate(
                        route = "${Screen.AddWordScreen.route}/${Uri.encode(textToSend)}"
                    )
                },
                onResetClick = {
                    backStackEntry.savedStateHandle.set(TEXT_TO_SHOW, "")
                    backStackEntry.savedStateHandle.set(TEXT_TO_CONCATENATE, "")
                }
            )
        }

            // Nó AddWordScreen
        composable(
            route = "${Screen.AddWordScreen.route}/{textReceived}",
            arguments = listOf(
                navArgument(name = "textReceived") {type = NavType.StringType}
            )
        ) { backStackEntry ->

            val textReceived = backStackEntry.arguments?.getString("textReceived")?: ""

            navHostController.previousBackStackEntry?.savedStateHandle?.set(TEXT_TO_SHOW, textReceived)

            AddWordScreen(
                textReceived = textReceived,
                modifier = modifier
            ) { textToConcatenate ->
                navHostController.previousBackStackEntry?.savedStateHandle?.set(TEXT_TO_CONCATENATE, textToConcatenate)
                navHostController.popBackStack()
            }

        }

    }

}