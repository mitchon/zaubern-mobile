package com.example.zaubernapp.ui.screens.shared.products_list

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zaubernapp.ui.screens.product.ProductState
import com.example.zaubernapp.ui.theme.onestFamily
import java.util.UUID


@Composable
fun ProductItemView(
    state: ProductState,
    onClicked: (UUID) -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 2.dp,
                color = Color.Black,
                shape = RoundedCornerShape(size = 15.dp),
            )
            .padding(15.dp)
            .background(MaterialTheme.colorScheme.primaryContainer)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) { onClicked(state.id) },
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primaryContainer),
            horizontalArrangement = Arrangement.spacedBy(15.dp, Alignment.Start),
            verticalAlignment = Alignment.Top,
        ) {
            FakeImage()
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
                horizontalAlignment = Alignment.Start,
            ) {
                Text(
                    text = state.name,
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 19.sp,
                        fontFamily = onestFamily,
                        fontWeight = FontWeight.Normal,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        letterSpacing = 0.2.sp
                    )
                )
                Text(
                    text = state.description,
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 14.sp,
                        fontFamily = onestFamily,
                        fontWeight = FontWeight.Normal,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        letterSpacing = 0.2.sp
                    )
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(30.dp, Alignment.Start),
                    verticalAlignment = Alignment.Top,
                ) {
                    Text(
                        text = "${state.price} ₽",
                        style = TextStyle(
                            fontSize = 18.sp,
                            lineHeight = 14.sp,
                            fontFamily = onestFamily,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                            letterSpacing = 0.2.sp
                        )
                    )
                    state.beforeSale?.let {
                        Text(
                            text = "${it} ₽",
                            style = TextStyle(
                                fontSize = 18.sp,
                                lineHeight = 14.sp,
                                fontFamily = onestFamily,
                                fontWeight = FontWeight.Normal,
                                color = Color(0xFF828282),
                                letterSpacing = 0.2.sp,
                                textDecoration = TextDecoration.LineThrough,
                            )
                        )
                    }
                }

            }
        }
    }
}

@Composable
fun FakeImage() {
    Card(
        modifier = Modifier
            .height(90.dp)
            .width(90.dp)
            .background(color = Color(0xFFD9D9D9), shape = RoundedCornerShape(size = 15.dp))
    ) {

    }
}

//@Preview(showBackground = true, widthDp = 320)
//@Composable
//fun PreviewProductMenuItem() {
//    ZaubernAppTheme {
//        ProductMenuItem()
//    }
//}