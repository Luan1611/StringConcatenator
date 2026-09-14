package br.edu.ifsp.scl.prdm.sc3029531.stringconcatenator.ui.composable

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.edu.ifsp.scl.prdm.sc3029531.stringconcatenator.ui.theme.StringConcatenatorTheme

@Composable
fun HomeScreen(modifier: Modifier, textToShow: String = "", textToConcatenate: String = "", onAddWordClick: (String) -> Unit) {

    var textToShow by remember { mutableStateOf(value = textToShow) }
    var textToConcatenate by remember { mutableStateOf(value = textToConcatenate) }

    textToShow += textToConcatenate

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text= textToShow
        )

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onAddWordClick(textToShow)
            }
        ) {
            Text(text = "Adicionar palavra")
        }

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {

            }
        ) {
            Text(text = "Reiniciar")
        }

    }

}

@Preview(
    name = "Light Mode",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)

@Preview(
    name = "Dark Mode",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)

@Composable
fun HomeScreenPreview() {
    StringConcatenatorTheme {
        Surface {
            HomeScreen(
                modifier = Modifier,
                textToShow = "Texto a ser mostrado",
                textToConcatenate = "Texto a ser concatenado",
                onAddWordClick = {}
            )
        }
    }
}