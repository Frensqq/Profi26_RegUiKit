package com.example.uikit.Controls

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.UI.Accent
import com.example.uikit.UI.InputBg
import com.example.uikit.UI.InputIcon
import com.example.uikit.UI.InputStr
import com.example.uikit.UI.Placeholder
import com.example.uikit.UI.White

@Composable
fun Counter(
    count: Int,
    onClick: (Int) -> Unit,
){
    Box(
        modifier = Modifier
            .width(64.dp)
            .height(32.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(InputBg)
            .padding(6.dp),
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(painter = painterResource(R.drawable.icon_minus),
                modifier = Modifier
                    .clickable{onClick(if (count > 1)count-1 else count)},
                tint = if (count > 1) Placeholder else InputIcon, contentDescription = null)

            Box(modifier = Modifier.width(1.dp).fillMaxHeight().background(InputStr))

            Icon(painter = painterResource(R.drawable.icon_plus),
                modifier = Modifier
                    .clickable{onClick(count+1)},
                tint = Placeholder, contentDescription = null)
        }
    }
}