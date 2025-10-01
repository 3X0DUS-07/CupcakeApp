package com.example.cupcakeapp1.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cupcakeapp1.R
import com.example.cupcakeapp1.ui.theme.CupcakeApp1Theme

@Composable
fun SelectOptionScreen(
    subtotal: String,
    options: List<String>,
    onSelectionChanged: (String) -> Unit = {},
    onCancelButtonClicked: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    var selectedValue by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = modifier
    ) {
        // Opciones de selección
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(dimensionResource(R.dimen.padding_medium))
        ) {
            options.forEach { item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = selectedValue == item,
                            onClick = {
                                selectedValue = item
                                onSelectionChanged(item)
                            }
                        )
                        .padding(vertical = dimensionResource(R.dimen.padding_small)),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = selectedValue == item,
                        onClick = {
                            selectedValue = item
                            onSelectionChanged(item)
                        }
                    )
                    Text(
                        text = item,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }

            HorizontalDivider(
                thickness = dimensionResource(R.dimen.thickness_divider),
                modifier = Modifier.padding(
                    top = dimensionResource(R.dimen.padding_medium),
                    bottom = dimensionResource(R.dimen.padding_medium)
                )
            )

            // Mostrar subtotal
            Text(
                text = stringResource(R.string.subtotal_price, subtotal),
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(
                        top = dimensionResource(R.dimen.padding_medium),
                        bottom = dimensionResource(R.dimen.padding_medium)
                    ),
                style = MaterialTheme.typography.headlineSmall
            )
        }

        // Botón Cancel
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_medium)),
            horizontalArrangement = Arrangement.Center
        ) {
            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = onCancelButtonClicked
            ) {
                Text(stringResource(R.string.cancel))
            }
        }
    }
}

@Preview
@Composable
fun SelectOptionPreview() {
    CupcakeApp1Theme {
        SelectOptionScreen(
            subtotal = "$3.00",
            options = listOf("Vanilla", "Chocolate", "Red Velvet", "Coffee"),
            modifier = Modifier.fillMaxWidth()
        )
    }
}