package com.example.mypokedex.presentation.pokemon_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    hint: String = "",
    onSearch: (String) -> Unit = {}
) {
    var text by remember {
        mutableStateOf("")
    }
    var isHintDisplayed by remember {
        mutableStateOf(hint != "")
    }

    Box(modifier = modifier) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(4.dp, RoundedCornerShape(26.dp))
                .clip(AbsoluteRoundedCornerShape(20.dp)),
            value = text,
            placeholder = {
                Text(text = hint)
            },
            onValueChange = {
                text = it
                onSearch(it)
            },
            maxLines = 1,
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
    }

//    Box(modifier = modifier) {
//        BasicTextField(
//            value = text,
//            onValueChange = {
//                text = it
//                onSearch(it)
//            },
//            maxLines = 1,
//            singleLine = true,
//            textStyle = TextStyle(color = Color.Black),
//            modifier = Modifier
//                .fillMaxWidth()
//                .shadow(5.dp, CircleShape)
//                .background(Color.White, CircleShape)
//                .padding(horizontal = 20.dp, vertical = 12.dp)
//                .onFocusChanged {
//                    isHintDisplayed = it.isFocused != true
//                }
//        )
//        if (isHintDisplayed) {
//            Text(
//                text = hint,
//                color = Color.LightGray,
//                modifier = Modifier
//                    .padding(horizontal = 20.dp, vertical = 12.dp)
//            )
//        }
//    }
}