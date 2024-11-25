package com.example.mvvmcleanarchitectureflavors.presentation.view.compose_function

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.mvvmcleanarchitectureflavors.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mvvmcleanarchitectureflavors.presentation.viewmodel.CalculatorViewModel

@Composable
fun CalculatorScreen(viewModel: CalculatorViewModel = viewModel()) {
   // var input by remember { mutableStateOf("") }
    val input = viewModel.input.value
    val buttons = listOf(
        listOf("7", "8", "9", "/"),
        listOf("4", "5", "6", "*"),
        listOf("1", "2", "3", "-"),
        listOf("C", "0", "=", "+"))
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(Color.Black)
        .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        //Display
        Image(
            painter = painterResource(id = R.drawable.prasant_pic),
            contentDescription = "story1",
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
        )
            Text(
                text = input.ifEmpty { "0" },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
                    .background(Color.DarkGray),
                fontSize = 48.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )


        buttons.forEach { row ->
            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween){
                row.forEach{ symbol->
                    CalculatorButton(symbol = symbol, onClick = {
                        viewModel.onButtonClick(symbol)
                    })

                }
            }

        }
    }
}

@Composable
fun CalculatorButton(symbol: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .size(80.dp)
            .padding(4.dp),
        colors = ButtonDefaults.buttonColors(contentColor = Color.Gray)
    ) {
        Text(
            text = symbol,
            fontSize = 24.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }
}