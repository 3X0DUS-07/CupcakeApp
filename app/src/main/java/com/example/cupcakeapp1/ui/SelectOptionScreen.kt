package com.example.cupcakeapp1.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.cupcakeapp1.R
import com.example.cupcakeapp1.ui.theme.CupcakeApp1Theme


@Composable
fun SelectOptionScreen(
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(R.string.choose_flavor),
        style = MaterialTheme.typography.bodySmall
    )
}



@Preview
@Composable
fun SelectOptionPreview() {
    CupcakeApp1Theme {
        SelectOptionScreen(
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(R.dimen.padding_medium))
        )
    }
}