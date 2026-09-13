package br.edu.ifsp.scl.prdm.sc3029531.stringconcatenator.ui.composable

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.edu.ifsp.scl.prdm.sc3029531.stringconcatenator.ui.theme.StringConcatenatorTheme

@Composable
fun AddWordScreen(
    modifier: Modifier
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "String no estado atual"
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = "texto estático",
            label = {Text(text = "Text to send")},
            onValueChange = {}
        )

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {

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
                modifier = Modifier
            )
        }
    }
}