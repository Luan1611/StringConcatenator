package br.edu.ifsp.scl.prdm.sc3029531.stringconcatenator.ui.composable

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
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
fun AddWordScreen(
    modifier: Modifier,
    textReceived: String,
    onConcatenateClick: (String) -> Unit
) {
    var textReceived by remember { mutableStateOf(value = textReceived) }
    var textToSend by remember { mutableStateOf(value = "") }

    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = textReceived //valor recebido da HomeScreen
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = textToSend,
            label = {Text(text = "Text to send")},
            onValueChange = {textToSend = it}
        )

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onConcatenateClick(textToSend)
            }
        ) {
            Text(text = "Concatenar")
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
fun AddWordScreenPreview() {
    StringConcatenatorTheme {
        Surface {
            AddWordScreen(
                modifier = Modifier,
                textReceived = "textReceived",
                onConcatenateClick = {}
            )
        }
    }
}